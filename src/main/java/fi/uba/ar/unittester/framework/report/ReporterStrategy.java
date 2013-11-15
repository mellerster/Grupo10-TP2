package fi.uba.ar.unittester.framework.report;

import fi.uba.ar.unittester.framework.TestAnalyzer;

import java.io.PrintWriter;

/**
 * Defines the output format strategy
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public interface ReporterStrategy {
    void createReport(TestAnalyzer testAnalyzer,PrintWriter printWriter);
}
