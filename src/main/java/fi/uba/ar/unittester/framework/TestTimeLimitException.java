package fi.uba.ar.unittester.framework;

@SuppressWarnings("serial")
public class TestTimeLimitException extends RuntimeException {
	
	public TestTimeLimitException(){
		super();
	}
	
	public TestTimeLimitException(String message){
		super(message);
	}
	
}
