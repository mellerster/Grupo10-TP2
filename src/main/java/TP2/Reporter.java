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
			appendLine(stringBuilder, r.toString());
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

	public void saveResults() {
	}

	public static Reporter getReporter() {
		if (reporter == null) {
			reporter = new Reporter();
		}
		return reporter;
	}

	public static void clear() {
		reporter = new Reporter();
	}

}
