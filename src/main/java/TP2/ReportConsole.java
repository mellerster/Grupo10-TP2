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
		System.out.print(getStringResults());
		System.out.flush();
	}

	public static ReportConsole getReporter() {
		if (report == null) {
			report = new ReportConsole(Reporter.getReporter());
		}
		return report;
	}

}
