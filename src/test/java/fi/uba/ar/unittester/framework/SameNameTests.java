package fi.uba.ar.unittester.framework;

import org.junit.Before;
import static org.junit.Assert.assertTrue;

public class SameNameTests extends TestContainer {


    @org.junit.Test
    public void execute_notAddedUnitTest() {
        addTest(new IsNullTest());
        addTest(new IsNullTest());
        Assert.assertTrue(getTests().size() == 1);
    }


    @org.junit.Test
    public void execute_notAddedTestContainer() {
        addTest(new SampleTestContainer());
        addTest(new SampleTestContainer());
        Assert.assertTrue(getTests().size() == 1);
    }



}
