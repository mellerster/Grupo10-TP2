package fi.uba.ar.unittester.framework.report;

import fi.uba.ar.unittester.framework.TestAnalyzer;
import fi.uba.ar.unittester.framework.TestResult;
import fi.uba.ar.unittester.framework.report.model.*;
import fi.uba.ar.unittester.framework.report.model.Error;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class XmlReporterStrategy implements ReporterStrategy {


    final String TEST_WITH_ERROR = "Test with error";
    final String TEST_WITH_FAILURE = "Test with failure";

    /**
     * Create a xml reporter strategy
     *
     * @param analyzer
     * @param printWriter
     */
    public void createReport(final TestAnalyzer analyzer, final PrintWriter printWriter) {

        try {
            JAXBContext jc = JAXBContext.newInstance(getClass().getPackage().getName().toString() + ".model");
            Marshaller marshaller = jc.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            List<String> allTests = analyzer.getAllTests();
            Map<String, List<TestResult>> passedTestsMap = analyzer.getPassed();
            Map<String, List<TestResult>> failedTestsMap = analyzer.getFailures();
            Map<String, List<TestResult>> errorTestsMap = analyzer.getErrors();

            Testsuites testsuites = new Testsuites();
            List<Testsuite> testsuitesList = testsuites.getTestsuite();

            for (String testName : allTests) {

                float time = 0f;

                Testsuite testSuite = new Testsuite();
                testSuite.setName(testName);
                List<Testcase> testCases = testSuite.getTestcase();
                testSuite.setErrors(analyzer.getTestsErrorsCount(testName) + "");
                testSuite.setFailures(analyzer.getTestsFailedCount(testName) + "");
                Date date = new java.util.Date();
                testSuite.setTimestamp(new Timestamp(date.getTime()).toString());

                if (passedTestsMap.containsKey(testName)) {
                    List<TestResult> passedTests = passedTestsMap.get(testName);
                    for (TestResult passedTest : passedTests) {
                        Testcase testcase = new Testcase();
                        testcase.setAssertions("1");
                        testcase.setName(passedTest.getTest().getTestSimpleName());
                        testcase.setClassname(passedTest.getTest().getTestName());
                        testcase.setTime(passedTest.getTime() + "");
                        time += passedTest.getTime();
                        testCases.add(testcase);
                    }
                }

                if (errorTestsMap.containsKey(testName)) {
                    List<TestResult> errorTests = errorTestsMap.get(testName);
                    if (errorTests != null)
                        for (TestResult errorTest : errorTests) {
                            Testcase testcase = new Testcase();
                            testcase.setAssertions("1");
                            testcase.setName(errorTest.getTest().getTestSimpleName());
                            testcase.setClassname(errorTest.getTest().getTestName());
                            testcase.setTime(errorTest.getTime() + "");
                            List<Error> errors = testcase.getError();
                            Error error = new Error();
                            error.setMessage(TEST_WITH_ERROR);
                            error.setType(errorTest.getMessage());
                            List<String> systemOut = testcase.getSystemErr();
                            systemOut.add(errorTest.getStackTrace());
                            time += errorTest.getTime();
                            errors.add(error);
                            testCases.add(testcase);
                        }
                }


                if (failedTestsMap.containsKey(testName)) {
                    List<TestResult> failedTests = failedTestsMap.get(testName);
                    if (failedTests != null)
                        for (TestResult failedTest : failedTests) {
                            Testcase testcase = new Testcase();
                            testcase.setAssertions("1");
                            testcase.setName(failedTest.getTest().getTestSimpleName());
                            testcase.setClassname(failedTest.getTest().getTestName());
                            testcase.setTime(failedTest.getTime() + "");
                            List<Failure> failures = testcase.getFailure();
                            Failure failure = new Failure();
                            failure.setType(failedTest.getMessage());
                            failure.setMessage(TEST_WITH_FAILURE);
                            List<String> systemOut = testcase.getSystemErr();
                            systemOut.add(failedTest.getStackTrace());
                            time += failedTest.getTime();
                            failures.add(failure);
                            testCases.add(testcase);
                        }
                }
                testSuite.setTime(time + "");
                testsuitesList.add(testSuite);
                testsuites.setFailures(analyzer.getTestWithFails()+"");
                testsuites.setErrors(analyzer.getTestWithErrors()+"");
                final String totalTime = testsuites.getTime();
                testsuites.setTime(Float.valueOf(totalTime==null?"0":totalTime) + time +"");
            }
            testsuites.setName("All test suites");
            marshaller.marshal(testsuites, printWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
