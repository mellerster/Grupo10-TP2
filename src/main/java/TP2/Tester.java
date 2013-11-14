package TP2;

import java.util.LinkedList;
import java.util.List;

/** Tester
 * Su responsabilidad es agregar los testeables para poder ejecutar los
 * tests del cliente uno a uno y guardar los resultados del reporte.
 **/

public class Tester {

	private List<TestSuite> testSuites;

	public Tester() {
		testSuites = new LinkedList<TestSuite>();
	}
	
	public Tester(Reporter reportType) {
		testSuites = new LinkedList<TestSuite>();
		Reporter.setReportType(reportType);
	}

	public void addTests(TestSuite testeable) {
		testSuites.add(testeable);
	}

	public void execute() {
		for (TestSuite t : testSuites) {
			t.init();
			t.run();
		}		
		Reporter.getReporter().saveResults();
	}

}
