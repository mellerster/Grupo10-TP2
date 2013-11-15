package fi.uba.ar.unittester.framework;

import org.junit.Before;

import java.util.Map;

public class FailTest extends UnitTest{


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
        Assert.assertEquals(analyzer.getTestWithFails(),1);
    }

    @Override
    public void test(Map<String, Object> context) {
        String nullString=null;
        nullString.equals(nullString);
        Assert.assertFalse(false);
    }
}
