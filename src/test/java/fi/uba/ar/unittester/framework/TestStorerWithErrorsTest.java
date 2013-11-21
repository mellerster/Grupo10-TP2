package fi.uba.ar.unittester.framework;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestStorerWithErrorsTest {
	
	@Before
	public void firstRun() {
		TestRunner testRunner = new TestRunner(false);
		testRunner.addTest(new ErrorTest());
		testRunner.addTest(new FailTest());
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.execute();
	}

	@Test
	public void secondRunCheckNew() {
		TestRunner testRunner = new TestRunner(true);
		testRunner.addTest(new ErrorTest());
		testRunner.addTest(new FailTest());
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.addTest(new OneEqualsOneTest());
		testRunner.execute();
		assertEquals(testRunner.getAnalyzer().getPassed().size(), 1);
	}
	
	@Test
	public void secondRunCheckFailed() {
		TestRunner testRunner = new TestRunner(true);
		testRunner.addTest(new ErrorTest());
		testRunner.addTest(new FailTest());
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.addTest(new OneEqualsOneTest());
		testRunner.execute();
		assertEquals(testRunner.getAnalyzer().getFailures().size(), 1);
	}
	
	@Test
	public void secondRunCheckWithError() {
		TestRunner testRunner = new TestRunner(true);
		testRunner.addTest(new ErrorTest());
		testRunner.addTest(new FailTest());
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.addTest(new OneEqualsOneTest());
		testRunner.execute();
		assertEquals(testRunner.getAnalyzer().getErrors().size(), 1);
	}
	
}