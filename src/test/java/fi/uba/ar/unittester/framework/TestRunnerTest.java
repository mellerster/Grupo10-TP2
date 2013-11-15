package fi.uba.ar.unittester.framework;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRunnerTest {

    private TestRunner runner;

    @Before
    public void setUp() {
        runner = new TestRunner();
    }

    @org.junit.Test
    public void execute_testContainer() {

        SampleTestContainer sampleTestContainer = new SampleTestContainer();
        runner.addTest(sampleTestContainer);
        runner.addTest(new FailTest());
        runner.execute();
        Assert.assertTrue(runner.getAnalyzer().getSuccessfulTestsCount() == 2);
    }


    @org.junit.Test
    public void execute_testContainerWithTestContainer() {

        SampleTestContainer sampleTestContainer = new SampleTestContainer();
        runner.addTest(sampleTestContainer);
        sampleTestContainer.addTest(new AssertsTestContainer());
        runner.addTest(new FailTest());
        runner.execute();
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 7);
    }

    @org.junit.Test
    public void execute_allTestsPassed() {

        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        NotNullNewStringTest testNotNull = new NotNullNewStringTest();

        runner.addTest(testEqual);
        runner.addTest(testNotNull);
        runner.execute();
        Assert.assertTrue(runner.getAnalyzer().getSuccessfulTestsCount() == 2);
    }


    @org.junit.Test
    public void execute_someTestsPassed() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        IsNullTest isNullTest = new IsNullTest();
        runner.addTest(testEqual);
        runner.addTest(isNullTest);
        runner.execute();
        Assert.assertTrue(runner.getAnalyzer().getSuccessfulTestsCount() == 1);
    }


    @org.junit.Test
    public void execute_regexMatchTests() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        TwoNotEqualsFourTest testNotEquals = new TwoNotEqualsFourTest();
        runner.setValidTestRegex("^.*Equals.*$");
        assertTrue(runner.addTest(testEqual));
        assertTrue(runner.addTest(testNotEquals));

    }

    @org.junit.Test
    public void execute_regexMatchFailTests() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        InvalidNotNullTest testFailed = new InvalidNotNullTest();
        runner.setValidTestRegex("^.*now.*$");
        assertFalse(runner.addTest(testEqual));
        assertFalse(runner.addTest(testFailed));
    }


}
