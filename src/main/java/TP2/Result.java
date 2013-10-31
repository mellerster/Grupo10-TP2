package TP2;


/** Result
 * Esta clase tiene el estado del resultado, exitoso o fallido, y una descripción del mismo
 * */
public class Result {
	
	private boolean state;
	private String description;

	protected Result() {
		state = false;
		description = "";
	}

	protected Result(boolean state, String description) {
		this.state = state;
		this.description = description;
	}

	public boolean getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}

	public boolean wasSuccessfull() {
		return getState();
	}

	@Override
	public String toString() {
		return description;
	}
	
}
