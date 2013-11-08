package TP2;

/** Result
 * Esta clase tiene el estado del resultado, exitoso, fallido o con errores,
 * y una descripcion del mismo.
 **/

public class Result {
	
	private ResultType state;
	private String description;
	private String packageName;
	private double time;
	
	protected Result() {
		state = ResultType.Error;
		description = "";
		packageName = "";
		time = 0;
	}

	protected Result(ResultType state, String description) {
		this.state = state;
		this.description = description;
		packageName = "";
		time = 0;
	}
	
	protected Result(ResultType state, String description, String packageName){
		this.state = state;
		this.description = description;
		this.packageName = packageName;
		time = 0;
	}
	
	protected Result(ResultType state, String description, String packageName, double time){
		this.state = state;
		this.description = description;
		this.packageName = packageName;
		this.time = time;
	}
	
	public double getTime(){
		return time;
	}

	public ResultType getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}
	
	public String getPackageName(){
		return packageName;
	}

	public boolean wasSuccessfull(){
		return (state == ResultType.Ok);
	}
	
	@Override
	public String toString(){
		return getDescription();
	}
	
}
