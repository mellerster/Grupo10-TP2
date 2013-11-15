package fi.uba.ar.unittester.framework.report;

import java.io.PrintWriter;

/**
 * Empty closer is a way to close a report without behaviour.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public class EmptyCloserStrategy implements ReporterCloserStrategy {

    /**
     * Do nothing.
     * @param writer
     */
    public void close(final PrintWriter writer) {}
}
