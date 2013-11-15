package fi.uba.ar.unittester.framework.report;

import fi.uba.ar.unittester.framework.TestAnalyzer;
import fi.uba.ar.unittester.framework.TestResult;
import org.apache.commons.lang.Validate;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Defines the output format strategy.
 * We use this strategy to Console and Text output format.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public class ConsoleAndTextFileReporterStrategy implements ReporterStrategy {

    /**
     * Create a console and text report strategy.
     * @param analyzer
     * @param writer
     */
    public void createReport(final TestAnalyzer analyzer, final PrintWriter writer) {
        Validate.notNull(analyzer, "The Test Analyzer cannot be null.");
        writer.println();
        writer.println("Tests Run Report");
        writer.println();
        writer.println();

        List<String> allTests = analyzer.getAllTests();
        Map<String, List<TestResult>> passedTestsMap = analyzer.getPassed();
        Map<String, List<TestResult>> failedTestsMap = analyzer.getFailures();
        Map<String, List<TestResult>> errorTestsMap = analyzer.getErrors();

        for (String testName : allTests) {
            writer.println(testName);
            writer.println("----------------------------------");

            if (passedTestsMap.containsKey(testName)) {
                List<TestResult> passedTests = passedTestsMap.get(testName);
                for (TestResult passedTest : passedTests) {
                    writer.println("  [ok] " + passedTest.getTest().getTestSimpleName());
                }
            }
            if (failedTestsMap.containsKey(testName)) {
                List<TestResult> failedTests = failedTestsMap.get(testName);
                for (TestResult failedTest : failedTests) {
                    writer.println("  [fail] " + failedTest.getTest().getTestSimpleName());
                }
            }
            if (errorTestsMap.containsKey(testName)) {
                List<TestResult> errorTests = errorTestsMap.get(testName);
                for (TestResult errorTest : errorTests) {
                    writer.println("  [error] " + errorTest.getTest().getTestSimpleName());
                }
            }

            writer.println();
        }

        //Summary
        writer.println("[failure] Summary");
        writer.println("==================================");
        writer.println("Run:  " + analyzer.getTestsAnalyzedCount());
        writer.println("Errors:  " + analyzer.getTestWithErrors());
        writer.println("Failures:  " + analyzer.getTestWithFails());
    }
}
