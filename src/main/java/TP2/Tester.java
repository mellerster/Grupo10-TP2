package TP2;

import java.util.LinkedList;
import java.util.List;

/** Tester
 * Su responsabilidad es agregar los testeables para poder ejecutar los 
 * test del cliente uno a uno y guardar los resultados del reporte.
 **/

public class Tester {
	
	private List<TestSuite> list;

	public Tester() {
		list = new LinkedList<TestSuite>();
	}

	public void addTests(TestSuite testeable) {
		list.add(testeable);
	}

	public void execute() {
		Reporter reporter = ReportConsole.getReporter();
		for (TestSuite t : list) {
			t.init();
			t.run();
		}
		reporter.saveResults();
	}

}
