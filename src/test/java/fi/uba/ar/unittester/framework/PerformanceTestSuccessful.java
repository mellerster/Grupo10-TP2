package fi.uba.ar.unittester.framework;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;

public class PerformanceTestSuccessful extends UnitTest {

	private TestRunner runner;

	@Before
	public void setUp() {
		runner = new TestRunner();
		limitTo(657415745 + 1);
	}

	@org.junit.Test
	public void execute_Test() {
		runner.addTest(this);
		runner.execute();
		TestAnalyzer analyzer = runner.getAnalyzer();
		assertEquals(analyzer.getPassed().size(),1);
	}

	@Override
	public void test(Map<String, Object> context) {
		Assert.assertTrue(true);
	}
}
