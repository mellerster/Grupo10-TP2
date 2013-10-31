package TP2;

import java.util.LinkedList;
import java.util.List;
/*
	Clase Tester
	Su responsabilidad es agregar los testeables para poder ejecutar los test del cliente uno a uno y guardar los resultados del reporte
*/
public class Tester {
	
	private List<Testeable> list;

	public Tester() {
		list = new LinkedList<Testeable>();
	}

	public void addTests(Testeable testeable) {
		list.add(testeable);
	}

	public void execute() {
		Reporter reporter = ReportConsole.getReporter();
		for (Testeable t : list) {
			t.init();
			t.execute();
		}
		reporter.saveResults();
	}

}
