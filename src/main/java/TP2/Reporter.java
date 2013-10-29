package TP2;

import java.util.LinkedList;
import java.util.List;

public class Reporter {
	List<Result> results;

	public Reporter() {
		results = new LinkedList<Result>();
	}

	void addResult(Result aResult) {
		results.add(aResult);
	}

	List<Result> getResults() {
		return results;
	}
}