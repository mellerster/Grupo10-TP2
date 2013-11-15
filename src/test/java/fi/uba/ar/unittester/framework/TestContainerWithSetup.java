package fi.uba.ar.unittester.framework;
import org.junit.Before;

import java.util.Map;

public class TestContainerWithSetup extends TestContainer{

    TestRunner testRunner;

    @Override
    public void setup(Map<String, Object> context) {
        context.put("value",4);
    }

    @Before
    public void setUp() {
        testRunner=new TestRunner();
    }


    @org.junit.Test
    public void execute_fixtureTest() {
        addTest(new InnerTest());
        testRunner.addTest(this);
        testRunner.execute();
        Assert.assertTrue(testRunner.getAnalyzer().getSuccessfulTestsCount()==1);
    }


    private class InnerTest extends UnitTest{
        @Override
        public void test(Map<String, Object> context) {
            int value = (Integer) context.get("value");
            Assert.assertTrue(value==4);
        }
    }

}
