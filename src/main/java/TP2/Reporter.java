package TP2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/** Reporter
 * Esta clase se encarga de ir agregando los resultados para generar un reporte.
 **/

public class Reporter {
	protected String name;
	private List<Result> results;
	private List<ResultFail> failures;
	private List<ResultError> errors;
	protected List<SubReport> subReports;
	protected static Reporter reporter;

	protected Reporter() {
		results = new LinkedList<Result>();
		failures = new LinkedList<ResultFail>();
		errors = new LinkedList<ResultError>();
		subReports = new LinkedList<SubReport>();
		name = "";
	}
	
	protected void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addSubReport(SubReport subReport){
		subReport.setName(this.getName() + (this.getName().equals("") ? "" : ".")
				+ subReport.getName());
		subReports.add(subReport);
		
	}
	protected Reporter(Reporter report) {
		this.results = report.results;
		this.failures = report.failures;
		this.errors = report.errors;
	}

	public void addResult(Result result) {
		results.add(result);
		if (result.getState() == ResultType.Fail) {
			failures.add((ResultFail) result);
		}
		if (result.getState() == ResultType.Error) {
			errors.add((ResultError) result);
		}
	}

	public List<Result> getResults() {
		List<Result> resultsToReturn = results;
		Collections.sort(resultsToReturn, new Comparator<Result>() {
	         @Override
	         public int compare(Result r1, Result r2) {
	             return r1.getPackageName().compareTo(r2.getPackageName());
	         }
	     });
		return results;
	}

	public List<ResultFail> getFailures() {
		return failures;
	}
	
	public List<ResultError> getErrors() {
		return errors;
	}

	void saveResults() {
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
