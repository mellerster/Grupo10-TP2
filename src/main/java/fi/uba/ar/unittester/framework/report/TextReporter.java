package fi.uba.ar.unittester.framework.report;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * TextReporter prints the output in a text file called report {@link Reporter}.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public class TextReporter extends Reporter {


    @Override
    protected void buildWriter() {
        try {
            setWriter(new PrintWriter("reportTextFile", "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void buildReporter() {
        setReporter(new ConsoleAndTextFileReporterStrategy());
    }

    @Override
    protected void buildCloser() {
        setCloser(new FileCloserStrategy());
    }

}
