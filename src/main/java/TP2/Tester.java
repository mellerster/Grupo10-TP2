package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Tester Su responsabilidad es agregar los testeables para poder ejecutar los
 * test del cliente uno a uno y guardar los resultados del reporte.
 **/

public class Tester {

	private List<TestSuite> list;

	private ReportMode reportMode;

	public Tester() {
		list = new LinkedList<TestSuite>();
		reportMode = ReportMode.Console;
	}
	
	public Tester(ReportMode reportMode){
		list = new LinkedList<TestSuite>();
		this.reportMode = reportMode;
	}

	public void addTests(TestSuite testeable) {
		list.add(testeable);
	}

	public void execute() {
		for (TestSuite t : list) {
			t.init();
			t.run();
		}
		switch (reportMode) {
		case Console:
			ReportConsole.getReporter().saveResults();
			break;
		case TextFile:
			break;
		default:
			break;
		}
	}

}
