package TP2;

import java.util.LinkedList;
import java.util.List;

/** Tester
 * Su responsabilidad es agregar los testeables para poder ejecutar los
 * tests del cliente uno a uno y guardar los resultados del reporte.
 **/

public class Tester {

	private List<TestSuite> testSuites;
	private ReportMode reportMode;

	public Tester() {
		testSuites = new LinkedList<TestSuite>();
		reportMode = ReportMode.Console;
	}
	
	public Tester(ReportMode reportMode) {
		testSuites = new LinkedList<TestSuite>();
		this.reportMode = reportMode;
	}

	public void addTests(TestSuite testeable) {
		testSuites.add(testeable);
	}

	public void execute() {
		for (TestSuite t : testSuites) {
			t.init();
			t.run();
		}
		
		switch (reportMode) {
			case Console:
				ReportConsole.getReporter().saveResults();
				break;
				
			case TextFile:
				ReportText.getReporter().saveResults();
				break;
				
			case AllAvailable:
				ReportConsole.getReporter().saveResults();
				ReportText.getReporter().saveResults();
				break;
		}
	}

}
