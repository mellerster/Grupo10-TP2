package fi.uba.ar.unittester.framework;

import org.junit.Before;

import java.util.List;

public class TestRunnerTagsTest {

    private TestRunner runner;

    @Before
    public void setUp() {
        runner = new TestRunner();
    }


    /**
     * Execute only tests with the DB tag.
     */
    @org.junit.Test
    public void execute_dbTagTests() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        IsNullTest isNullTest = new IsNullTest();
        isNullTest.addTag("DB");
        testEqual.addTag("DB");
        runner.addTest(testEqual);
        runner.addTest(isNullTest);
        runner.execute("DB");
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 2);
    }


    /**
     * Execute tests that matches with at least one tag in a list.
     */
    @org.junit.Test
    public void execute_differentTagsTests() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        IsNullTest isNullTest = new IsNullTest();
        IsNullTest isNullTest2 = new IsNullTest();
        IsNullTest isNullTest3 = new IsNullTest();
        isNullTest.addTag("DB");
        testEqual.addTag("DB");
        isNullTest2.addTag("slow");
        runner.addTest(testEqual);
        runner.addTest(isNullTest);
        runner.addTest(isNullTest2);
        runner.addTest(isNullTest3);
        runner.execute("DB", "slow");
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 3);
    }


    /**
     * Execute <test case> with match some tag and not start with a given name.
     *
     */
    @org.junit.Test
    public void execute_testCaseWithTagAndNotStartWith() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        NotNullNewStringTest testNotNull= new NotNullNewStringTest();
        IsNullTest isNullTest = new IsNullTest();
        testEqual.addTag("TAG");
        isNullTest.addTag("TAG");
        testNotNull.addTag("TAG");
        runner.setValidTestRegex("^(?!One).*$");
        runner.addTest(testEqual);
        runner.addTest(isNullTest);
        runner.addTest(testNotNull);
        runner.execute("TAG");
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 2);
    }


    /**
     * Execute <test case> with match some tag and contains some string.
     *
     */
    @org.junit.Test
    public void execute_testCaseWithTagAndNameContains() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        NotNullNewStringTest testNotNull= new NotNullNewStringTest();
        IsNullTest isNullTest = new IsNullTest();
        testEqual.addTag("TAG");
        isNullTest.addTag("TAG2");
        testNotNull.addTag("TAG3");
        runner.setValidTestRegex("^.*Null.*$");
        runner.addTest(testEqual);
        runner.addTest(isNullTest);
        runner.addTest(testNotNull);
        runner.execute("TAG2","TAG3");
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 2);
    }


    /**
     * Execute <test case> with match some tag of a test suite.
     *
     */
    @org.junit.Test
    public void execute_testSuiteWithTag() {
        SampleTestContainer sampleTestContainer= new SampleTestContainer();
        List<Test> tests = sampleTestContainer.getTests();
        tests.get(0).addTag("TAG");
        tests.get(1).addTag("TAG2");
        tests.get(2).addTag("TAG3");
        sampleTestContainer.addTag("TAG");
        runner.addTest(sampleTestContainer);
        runner.execute("TAG");
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 1);
    }

    /**
     * Avoid execute <test case> with a skip tag.
     *
     */
    @org.junit.Test
    public void execute_testCaseWithSkip() {
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        testEqual.addTag(Test.SKIP_TAG);
        runner.addTest(testEqual);
        runner.execute();
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 0);
    }


    /**
     * Avoid execute <test case> with a skip tag contained into a testSuite.
     *
     */
    @org.junit.Test
    public void execute_testCaseInsideTestSuitWithSkip() {
        SampleTestContainer sampleTestContainer= new SampleTestContainer();
        OneEqualsOneTest testEqual = new OneEqualsOneTest();
        testEqual.addTag(Test.SKIP_TAG);
        sampleTestContainer.addTest(testEqual);
        runner.execute();
        Assert.assertTrue(runner.getAnalyzer().getTestsAnalyzedCount() == 0);
    }




}
