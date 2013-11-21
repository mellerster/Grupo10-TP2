package fi.uba.ar.unittester.framework;

import java.util.Map;
import org.junit.Before;

public class PerformanceTestFailed extends UnitTest {

    private TestRunner runner;

    @Before
    public void setUp() {
        runner = new TestRunner();
        limitTo(65741574);
    }

    @org.junit.Test
    public void execute_Test() {
        runner.addTest(this);
        runner.execute();
        TestAnalyzer analyzer = runner.getAnalyzer();
        Assert.assertEquals(analyzer.getTestWithTimeLimitErrors(),1);
    }

    @Override
    public void test(Map<String, Object> context) {
        try {
			Thread.sleep(100);
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        Assert.assertTrue(true);
    }

}
