package TP2;

/** AssertFailedException
 * Exception que se lanza cuando no se devuelve el resultado
 * que se esperaba en un assert.
 **/

@SuppressWarnings("serial")
public class AssertFailedException extends RuntimeException { 
	
	public AssertFailedException() {
		super();
	}
	
	public AssertFailedException(String message) {
		super(message);
	}
	
}
