package fi.uba.ar.unittester.framework;

import java.util.Map;

/**
 * Runs a Unit Test.
 *
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */

public abstract class UnitTest extends Test {


    /**
     * Runs test method and save the results in analyzer.
     *
     * @param analyzer
     * @param tags
     */
    @Override
    public final void run(final TestAnalyzer analyzer,
                          final Map<String, Object> context,final String... tags) {
        analyzer.start(this);
        long startTime = 0;
        try {
            setup(context);
            startTime = System.nanoTime();
            test(context);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            analyzer.addPassed(this, "This test was succesfull", totalTime);
        } catch (AssertionFailError e) {
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            analyzer.addError(this, e.getAssertionName(), totalTime, e);
        } catch (Throwable e) {
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
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

}
