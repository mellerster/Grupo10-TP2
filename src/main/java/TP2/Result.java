package TP2;

/** Result
 * Esta clase tiene el estado del resultado, exitoso, fallido o con errores,
 * y una descripcion del mismo.
 **/

public class Result {
	
	private ResultType state;
	private String description;

	protected Result() {
		state = ResultType.Error;
		description = "";
	}

	protected Result(ResultType state, String description) {
		this.state = state;
		this.description = description;
	}

	public ResultType getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}

	public boolean wasSuccessfull(){
		return (state == ResultType.Ok);
	}
	
	@Override
	public String toString() {
		return description;
	}
	
}
