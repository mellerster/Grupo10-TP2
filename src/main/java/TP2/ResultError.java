package TP2;

public class ResultError extends Result {
	
	public ResultError(String description){
		super(ResultType.Error, "[Error] " + description);
	}
}
