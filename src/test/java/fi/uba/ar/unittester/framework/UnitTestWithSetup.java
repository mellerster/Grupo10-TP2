package fi.uba.ar.unittester.framework;
import org.junit.Before;

import java.util.Map;

public class UnitTestWithSetup extends UnitTest{

    TestRunner testRunner;

    @Before
    public void setUp() {
        testRunner=new TestRunner();
    }

    @Override
    public void setup(Map<String, Object> context) {
        context.put("value",2);
    }

    @Override
    public void test(Map<String, Object> context) {
        int value = (Integer) context.get("value");
        Assert.assertTrue(value==2);
    }

    @org.junit.Test
    public void execute_fixtureTest() {
        testRunner.addTest(this);
        testRunner.execute();
        Assert.assertTrue(testRunner.getAnalyzer().getSuccessfulTestsCount()==1);
    }
}
