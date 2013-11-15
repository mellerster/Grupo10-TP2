package fi.uba.ar.unittester.framework;

import org.junit.Before;

import java.util.Map;

public class ErrorTest extends UnitTest {

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
        Assert.assertEquals(analyzer.getTestWithErrors(),1);
    }



    @Override
    public void test(Map<String, Object> context) {
        String test="test";
        Assert.assertTrue(test.equals("anOtherValue"));
    }
}
