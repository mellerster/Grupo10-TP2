package TP2;

/** ReportConsole
 * Esta clase tiene como responsabilidad, enviar los resultados de las pruebas 
 * a la consola y un comentario final si pasaron o no todos los tests.
 * Herencia: Esta clase hereda de Reporter ya que es un reporte, pero en este 
 * caso al grabarse (metodo saveResults()) lo muestra por pantalla.
 **/

public class ReportConsole extends Reporter {
	
	private static ReportConsole report;

	private ReportConsole() { }

	private ReportConsole(Reporter report) {
		super(report);
	}

	public void saveResults() {
		for (Result r : reporter.getResults()) {
			if (r.getState() == ResultType.Ok) {
				System.out.println(r);
			} else {
				System.err.println(r);
			}
		}
		int failures = reporter.getFailures().size();
		int errors = reporter.getErrors().size();
		String type = (failures == 0 && errors == 0 ? "success" : "failure");
		System.out.println("");
		System.out.println(type.concat(" Summary"));
		System.out.println("=========================");
		System.out.println("Run: " + reporter.getResults().size());
		System.out.println("Errors: " + errors);
		System.out.println("Failures: " + failures);
		
	}

	public static ReportConsole getReporter() {
		if (report == null) {
			report = new ReportConsole(Reporter.getReporter());
		}
		return report;
	}

}
