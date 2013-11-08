package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Reporter Esta clase se encarga de ir agregando los resultados para generar un
 * reporte.
 **/

public class Reporter {

	private List<Result> results;
	private List<ResultFail> failures;
	private List<ResultError> errors;
	protected static Reporter reporter;
	protected static ReportMode mode;
	
	public static void setMode(ReportMode aMode){
		mode = aMode;
	}

	protected Reporter() {
		results = new LinkedList<Result>();
		failures = new LinkedList<ResultFail>();
		errors = new LinkedList<ResultError>();
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
		//System.out.println(result.toString() + "(" + result.getTime() + "s)");
		Reporter.getReporter().saveResult(result.toString() + "(" + result.getTime() + "s)");
	}

	public List<Result> getResults() {
		return results;
	}

	public List<ResultFail> getFailures() {
		return failures;
	}

	public List<ResultError> getErrors() {
		return errors;
	}

	private void appendLine(StringBuilder builder, String line) {
		builder.append(line);
		builder.append(System.getProperty("line.separator"));
	}

	protected String getStringResults() {
		StringBuilder stringBuilder = new StringBuilder();
		String packageName = "";
		for (Result r : reporter.getResults()) {
			if (!packageName.equals(r.getPackageName())) {
				packageName = r.getPackageName();
				appendLine(stringBuilder, "");
				appendLine(stringBuilder, packageName);
				appendLine(stringBuilder, "-------------------");
			}
			appendLine(stringBuilder, r.toString() + " (" + r.getTime() + "s)");
		}
		int failures = reporter.getFailures().size();
		int errors = reporter.getErrors().size();
		String type = (failures == 0 && errors == 0 ? "success" : "failure");
		appendLine(stringBuilder, "");
		appendLine(stringBuilder, type.concat(" Summary"));
		appendLine(stringBuilder, "===============");
		appendLine(stringBuilder, "Run: " + reporter.getResults().size());
		appendLine(stringBuilder, "Errors: " + errors);
		appendLine(stringBuilder, "Failures: " + failures);
		return stringBuilder.toString();
	}
	
	protected void saveResult(String result){
	}

	public void saveResults() {
	}

	public static ReportMode getMode(){
		return mode;
	}
	public static Reporter getReporter() {
		if (reporter == null) {
			switch(Reporter.getMode()){
				case Console:
					reporter = new ReportConsole();
				case TextFile:
					reporter = new ReportText();
			default:
				break;
			}
		}
		return reporter;
	}

	public static void clear() {
		reporter = new Reporter();
	}

}
