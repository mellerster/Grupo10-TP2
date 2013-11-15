package fi.uba.ar.unittester.framework.report;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * XmlReporter prints the output in a xml format file {@link Reporter}.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */

public class XmlReporter extends Reporter {

    @Override
    protected void buildWriter() {
        try {
            writer = new PrintWriter("reportXMLFile.xml", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void buildReporter() {
        setReporter(new XmlReporterStrategy());
    }

    @Override
    protected void buildCloser() {
        setCloser(new FileCloserStrategy());
    }

}
