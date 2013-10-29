package TP2;

import java.util.LinkedList;
import java.util.List;

public class Reporter {
	List<Result> results;

	private Reporter() {
		results = new LinkedList<Result>();
	}

	public void addResult(Result aResult) {
		results.add(aResult);
	}

	List<Result> getResults() {
		return results;
	}	
	private static Reporter r;
	public static Reporter getReporter(){
		if(r == null)
			r = new Reporter();
		return r;
	}
}