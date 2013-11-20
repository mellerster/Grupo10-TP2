package fi.uba.ar.unittester.framework;

import java.util.Map;

/**
 * Runs a Unit Test.
 * 
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */

public abstract class UnitTest extends Test {
	long timeToRun = Long.MAX_VALUE;

	/**
	 * Runs test method and save the results in analyzer.
	 * 
	 * @param analyzer
	 * @param tags
	 */
	@Override
	public final void run(final TestAnalyzer analyzer,
			final Map<String, Object> context, final String... tags) {
		analyzer.start(this);
		long startTime = 0;
		long endTime;
		long totalTime = 0;
		try {
			setup(context);
			startTime = System.nanoTime();
			test(context);
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			if (totalTime > getLimitTime()) {
				throw new TestTimeLimitException("Limit:" + timeToRun
						+ ", Time: " + totalTime);
			}
			analyzer.addPassed(this, "This test was succesfull", totalTime);
			TestStorer testStorer = new TestStorerFactory().getStorer();
			testStorer.store(this);
		} catch (AssertionFailError e) {
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			analyzer.addError(this, e.getAssertionName(), totalTime, e);
		} catch (TestTimeLimitException e) {
			analyzer.addTimeLimitError(this, e.getMessage(), totalTime, e);
		} catch (Throwable e) {
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			analyzer.addFailure(this, e.getClass().toString(), totalTime, e);
		}
		tearDown(context);
	}

	/**
	 * Defines the test to be run.
	 * 
	 * @param context
	 */
	public abstract void test(Map<String, Object> context);

	public void limitTo(long timeToRun) {
		this.timeToRun = timeToRun;
	}

	public long getLimitTime() {
		return timeToRun;
	}

}
