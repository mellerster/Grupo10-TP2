package fi.uba.ar.unittester.framework;

import java.util.Map;

import org.junit.Before;

public class IsNullTest extends UnitTest {

	private TestRunner runner;

	@Before
	public void setUp() {
		runner = new TestRunner();
	}

	@org.junit.Test
	public void execute_failTest() {
		runner.addTest(this);
		runner.execute();
		TestAnalyzer analyzer = runner.getAnalyzer();
		Assert.assertEquals(analyzer.getTestWithErrors(), 1);
	}

	@Override
	public void test(Map<String, Object> context) {
		Assert.assertNull(1);
	}
}
