package fi.uba.ar.unittester.framework.report;

import fi.uba.ar.unittester.framework.TestAnalyzer;


/**
 * ReportGeneratorAbsractFactory defines the way that the report is generated.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */
public abstract class ReportGeneratorAbsractFactory {

    /**
     * Factory method
     *
     * @return a concrete Reporter
     */
    public abstract Reporter createReportGenerator();


    /**
     * Report generator building steps.
     *
     */
    public void generateReport(TestAnalyzer analyzer) {
        Reporter reportGenerator = createReportGenerator();
        reportGenerator.createReporter();
        reportGenerator.generateTestReport(analyzer);
        reportGenerator.close();
    }
}
