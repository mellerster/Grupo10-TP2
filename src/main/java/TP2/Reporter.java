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
	protected static Reporter reporter;

	protected Reporter() {
		results = new LinkedList<Result>();
		failures = new LinkedList<ResultFail>();
		errors = new LinkedList<ResultError>();
		name = "";
	}
	
	protected void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
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
	
	protected String getStringResults(){
		StringBuilder stringBuilder = new StringBuilder();
		String packageName = "";
		for (Result r : reporter.getResults()) {
			if (!packageName.equals(r.getPackageName())) {
				packageName = r.getPackageName();
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append(packageName + "\n");
				stringBuilder.append("-------------------" + "\n");
			}
				stringBuilder.append(r + "\n");
		}
		int failures = reporter.getFailures().size();
		int errors = reporter.getErrors().size();
		String type = (failures == 0 && errors == 0 ? "success" : "failure");
		System.out.flush();
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(type.concat(" Summary" + "\n"));
		stringBuilder.append("=========================" + "\n");
		stringBuilder.append("Run: " + reporter.getResults().size() + "\n");
		stringBuilder.append("Errors: " + errors + "\n");
		stringBuilder.append("Failures: " + failures + "\n");
		return stringBuilder.toString();
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
