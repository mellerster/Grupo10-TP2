package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Reporter Esta clase se encarga de ir agregando los resultados para generar un
 * reporte.
 **/

public abstract class Reporter {

	private List<Result> results;
	private List<ResultFail> failures;
	private List<ResultError> errors;
	protected static Reporter reporter;
	protected static ReportMode mode = ReportMode.Console;
	private String packageName = "";

	protected Reporter() {
		results = new LinkedList<Result>();
		failures = new LinkedList<ResultFail>();
		errors = new LinkedList<ResultError>();
		mode = ReportMode.Console;
	}

	protected Reporter(Reporter report) {
		this.results = report.results;
		this.failures = report.failures;
		this.errors = report.errors;
	}

	public void addResult(Result result) {
		if (!packageName.equals(result.getPackageName())) {
			packageName = result.getPackageName();
			saveResult("");
			saveResult(packageName);
			saveResult("-------------------");
		}
		results.add(result);
		if (result.getState() == ResultType.Fail) {
			failures.add((ResultFail) result);
		}
		if (result.getState() == ResultType.Error) {
			errors.add((ResultError) result);
		}
		Reporter.getReporter().saveResult(
				result.toString() + "(" + result.getTime() + "s)");
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

	protected abstract void saveResult(String result);

	public void saveResults() {
		StringBuilder stringBuilder = new StringBuilder();
		int failures = reporter.getFailures().size();
		int errors = reporter.getErrors().size();
		String type = (failures == 0 && errors == 0 ? "success" : "failure");
		appendLine(stringBuilder, "");
		appendLine(stringBuilder, type.concat(" Summary"));
		appendLine(stringBuilder, "===============");
		appendLine(stringBuilder, "Run: " + reporter.getResults().size());
		appendLine(stringBuilder, "Errors: " + errors);
		appendLine(stringBuilder, "Failures: " + failures);
		Reporter.getReporter().saveResult(stringBuilder.toString());

	}

	public static void setMode(ReportMode aMode) {
		mode = aMode;
	}

	public static ReportMode getMode() {
		return mode;
	}

	public static Reporter getReporter() {
		if (reporter == null) {
			switch (Reporter.getMode()) {
			case Console:
				reporter = new ReportConsole();
				break;
			case TextFile:
				reporter = new ReportText();
				break;
			default:
				break;
			}
		}
		return reporter;
	}

	public static void clear() {
		reporter = null;
	}

}
