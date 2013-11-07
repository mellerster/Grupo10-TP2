package TP2;

/**
 * ReportConsole Esta clase tiene como responsabilidad, enviar los resultados de
 * las pruebas a la consola y un comentario final si pasaron o no todos los
 * tests. Herencia: Esta clase hereda de Reporter ya que es un reporte, pero en
 * este caso al grabarse (metodo saveResults()) lo muestra por pantalla.
 **/

public class ReportConsole extends Reporter {

	private static ReportConsole report;

	private ReportConsole() {
	}

	private ReportConsole(Reporter report) {
		super(report);
	}

	public void saveResults() {
		String packageName = "";
		for (Result r : reporter.getResults()) {
			if (!packageName.equals(r.getPackageName())) {
				packageName = r.getPackageName();
				System.out.println();
				System.out.println(packageName);
				System.out.println("----------");
				System.out.flush();
			}
			if (r.getState() == ResultType.Ok) {
				System.out.println(r);
			} else {
				System.out.println(r);
			}
			
			System.out.flush();
		}
		int failures = reporter.getFailures().size();
		int errors = reporter.getErrors().size();
		String type = (failures == 0 && errors == 0 ? "success" : "failure");
		System.out.flush();
		System.out.println("");
		System.out.println(type.concat(" Summary"));
		System.out.println("=========================");
		System.out.println("Run: " + reporter.getResults().size());
		System.out.println("Errors: " + errors);
		System.out.println("Failures: " + failures);
		System.out.flush();
	}

	public static ReportConsole getReporter() {
		if (report == null) {
			report = new ReportConsole(Reporter.getReporter());
		}
		return report;
	}

}
