package TP2;

/** Result
 * Esta clase tiene el estado del resultado, exitoso, fallido o con errores,
 * y una descripcion del mismo.
 **/

public class Result {
	
	private ResultType state;
	private String testName;
	private String description;
	private String packageName;
	private double time;
	
	protected Result() {
		state = ResultType.Error;
		description = "";
		packageName = "";
		time = 0;
		testName = "";
	}

	protected Result(ResultType state, String testName) {
		this.state = state;
		this.testName = testName;
		packageName = "";
		time = 0;
		description = "";
	}
	
	protected Result(ResultType state, String testName, String packageName){
		this.state = state;
		this.testName = testName;
		this.packageName = packageName;
		time = 0;
		description = "";
	}
	
	protected Result(ResultType state, String testName, String packageName, double time){
		this.state = state;
		this.testName = testName;
		this.packageName = packageName;
		this.time = time;
		description = "";
	}
	
	protected Result(ResultType state, String testName, String packageName, double time, String description){
		this.description = description;
		this.state = state;
		this.testName = testName;
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
	
	public String getTestName(){
		return testName;
	}
	
	public String getPackageName(){
		return packageName;
	}

	public boolean wasSuccessfull(){
		return (state == ResultType.Ok);
	}
	
	@Override
	public String toString(){
		return getTestName();
	}
	
}
