package fi.uba.ar.unittester.framework.report;

import java.io.PrintWriter;

import fi.uba.ar.unittester.framework.TestAnalyzer;
import org.apache.commons.lang.Validate;

/**
 *
 * Generic report
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */
public abstract class Reporter {

    /**
     * Writer to handle output
     */
    protected PrintWriter writer;

    /**
     * Reporter strategy
     */
    protected ReporterStrategy reporter;

    /**
     * Report closer strategy
     */
    protected ReporterCloserStrategy closer;

    /**
     * Creates a new file handler for the report
     */
    public final void createReporter(){

        buildWriter();
        buildReporter();
        buildCloser();

        Validate.notNull(writer,"Writer can not be null");
        Validate.notNull(reporter,"Reporter can not be null");
        Validate.notNull(closer,"Closer can not be null");
    }

    /**
     * Fills the report file with the result of tests contained in the given
     * {@link fi.uba.ar.unittester.framework.TestAnalyzer}.
     *
     * @param analyzer The {@link fi.uba.ar.unittester.framework.TestAnalyzer} which contains the test results.
     *                 It cannot be null.
     */
    public void generateTestReport(final TestAnalyzer analyzer) {
        reporter.createReport(analyzer, writer);
    }

    /**
     * Close the writer
     */
    public void close() {
        closer.close(writer);
    }

    /**
     * Set and specific writer
     * @param writer
     */
    public void setWriter(PrintWriter writer) {
        this.writer= writer;
    }

    /**
     * Set and specific reporter strategy
     * @param reporter
     */
    public void setReporter(ReporterStrategy reporter) {
        this.reporter = reporter;
    }

    /**
     * Set the report closer strategy
     * @param closer
     */
    public void setCloser(ReporterCloserStrategy closer) {
        this.closer = closer;
    }

    protected abstract void buildWriter();
    protected abstract void buildReporter();
    protected abstract void buildCloser();

}
