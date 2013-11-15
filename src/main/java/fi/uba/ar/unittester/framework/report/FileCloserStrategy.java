package fi.uba.ar.unittester.framework.report;

import fi.uba.ar.unittester.framework.report.ReporterCloserStrategy;

import java.io.PrintWriter;

public class FileCloserStrategy implements ReporterCloserStrategy {

    /**
     * Close the given writer.
     * @param writer
     */
    public void close(final PrintWriter writer) {
    writer.close();
  }
}
