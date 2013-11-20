package fi.uba.ar.unittester.framework;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestStorerWithoutErrorsTest {
	
	@Before
	public void firstRun() {
		TestRunner testRunner = new TestRunner(false);
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.addTest(new PerformanceTestSuccessful());
		testRunner.execute();
	}

	@Test
	public void secondRun() {
		TestRunner testRunner = new TestRunner(true);
		testRunner.execute();
		assertEquals(testRunner.getAnalyzer().getPassed().size(), 0);
	}
	
}
