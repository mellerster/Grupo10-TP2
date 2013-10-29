package TP2;

import java.util.LinkedList;
import java.util.List;

public class Tester {
	private List<Testeable> list;

	public Tester() {
		list = new LinkedList<Testeable>();
	}

	public void addTests(Testeable t) {
		list.add(t);
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
