package fi.uba.ar.unittester.framework.report;

import java.io.PrintWriter;

/**
 * ReporterCloserStrategy defines the way that report is closed.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public interface ReporterCloserStrategy {
    public void close(PrintWriter writer);
}
