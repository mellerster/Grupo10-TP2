package TP2;

import java.util.LinkedList;
import java.util.List;

public class Reporter {
	private List<Result> results;
	private List<ResultFail> failures;
	protected static Reporter reporter;

	protected Reporter() {
		results = new LinkedList<Result>();
		failures = new LinkedList<ResultFail>();
	}

	protected Reporter(Reporter report) {
		this.results = report.results;
		this.failures = report.failures;
	}

	public void addResult(Result aResult) {
		results.add(aResult);
		if (!aResult.wasSuccessfull()) {
			failures.add((ResultFail) aResult);
		}
	}

	public List<Result> getResults() {
		return results;
	}

	public List<ResultFail> getFailures() {
		return failures;
	}

	public void saveResults() {
	}

	public static Reporter getReporter() {
		if (reporter == null) {
			reporter = new Reporter();
		}
		return reporter;
	}
}