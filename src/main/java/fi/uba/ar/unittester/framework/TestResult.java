package fi.uba.ar.unittester.framework;

import org.apache.commons.lang.Validate;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * The result of a Test execution.
 *
 * @author federico.farina (federicofarina22@gmail.com)
 */
public class TestResult {

    /**
     * The test that was executed that resulted in a failure or error. It's never
     * null.
     */
    protected Test test;

    /**
     * The {@link message} that might have caused a test failure, error ot succesfull. It
     * cannot be null.
     */
    protected String message;
    protected String stackTrace;
    protected float time;


    /**
     * Makes a new instance of a {@link TestResult} with the given parameters.
     *
     * @param theTest The test that was executed. It cannot be null.
     * @param message The {@link Throwable} that might have caused a test
     *                failure or error. It cannot be null.
     * @param theTime Execution time of the test.
     */

    public TestResult(final Test theTest, final String message, final float theTime, Throwable throwable) {

        Validate.notNull(theTest, "The Test cannot be null.");
        Validate.notNull(message, "The message cannot be null.");
        Validate.notNull(time, "The time cannot be null.");
        Validate.notNull(throwable, "The throwable cannot be null.");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        test = theTest;
        this.message = message;
        time = theTime;
        stackTrace = sw.toString();
        pw.close();
    }

    public TestResult(Test theTest, String message, long testTime) {

        Validate.notNull(message, "The message cannot be null.");
        Validate.notNull(time, "The time cannot be null.");
        Validate.notNull(theTest, "The time cannot be null.");

        test = theTest;
        this.message = message;
        time = testTime;

    }

    /**
     * Returns the test that was executed that resulted in a failure or error.
     *
     * @return The test that failed or had an error.
     */
    public Test getTest() {
        return test;
    }

    /**
     * Returns the exception that was raised by the test.
     *
     * @return The exception that was raised by the test.
     */
    public String getMessage() {
        return message;
    }


    public float getTime() {
        return time;
    }


    public String getStackTrace() {
        return stackTrace;
    }
}
