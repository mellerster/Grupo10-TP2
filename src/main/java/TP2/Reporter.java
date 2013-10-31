package TP2;

import java.util.LinkedList;
import java.util.List;

/** Reporter
 * Esta clase se encarga de ir agregando los resultados para generar un reporte.
 **/

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

	public void addResult(Result result) {
		results.add(result);
		if (!result.wasSuccessfull()) {
			failures.add((ResultFail) result);
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
	
	public static void clear(){
		reporter = new Reporter();
	}
	
}
