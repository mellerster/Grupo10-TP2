package fi.uba.ar.unittester.framework.report;


/**
 * Encapsulate the creation of a Reporter {@link Reporter}.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public class ReportFactory extends ReportGeneratorAbsractFactory {

    public static final String CONSOLE_REPORT = "CONSOLE_REPORT";
    public static final String TEXT_REPORT = "TEXT_REPORT";
    public static final String XML_REPORT = "XML_REPORT";
    private String format;

    /**
     * Defines the format of the report, it can be one of:
     * {@link CONSOLE_REPORT}
     * {@link TEXT_REPORT}
     * {@link XML_REPORT}
     *
     * @param aFormat
     */
    public ReportFactory(String aFormat) {
        format = aFormat;
    }


    /**
     * Create reporter type
     *
     * @return Reporter
     */
    public Reporter createReportGenerator() {
        if (format.equals(CONSOLE_REPORT)) {
            return new ConsoleReporter();
        } else if (format.equals(TEXT_REPORT)) {
            return new TextReporter();
        } else {
            return new XmlReporter();
        }
    }

    /**
     * Set a specific report format. We can change it at runtime.
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }
}
