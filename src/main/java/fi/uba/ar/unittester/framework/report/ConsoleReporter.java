package fi.uba.ar.unittester.framework.report;


import java.io.PrintWriter;


/**
 * ConsoleReporter prints the results in the standard output {@link Reporter}.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public class ConsoleReporter extends Reporter {


    @Override
    protected void buildWriter() {
        setWriter(new PrintWriter(System.out,true));
    }


    @Override
    protected void buildReporter() {
        setReporter(new ConsoleAndTextFileReporterStrategy());
    }

    @Override
    protected void buildCloser() {
        setCloser(new EmptyCloserStrategy());
    }


}
