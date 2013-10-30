package TP2;

import java.util.LinkedList;
import java.util.List;

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
