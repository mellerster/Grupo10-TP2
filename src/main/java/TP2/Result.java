package TP2;

public class Result {
	String description;
	boolean state;
	protected Result() {
		state = false;
		description = "";
	}
	
	
	protected  Result(String description, boolean state) {
		this.description = description;
		this.state = state;
	}
	
	public boolean getState(){
		return state;
	}
	
	public String getDescription(){
		return description;
	}
	
	public boolean successfull(){
		return getState();
	}
	@Override
	public String toString(){
		return description;
	}
}
