package fi.uba.ar.unittester.framework;

/**
 * Error caused when a Test passed the time limit.
 */

@SuppressWarnings("serial")
public class TestTimeLimitException extends RuntimeException {

	public TestTimeLimitException() {
		super();
	}

	public TestTimeLimitException(String message) {
		super(message);
	}

}
