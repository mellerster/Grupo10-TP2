package TP2;

import java.util.LinkedList;
import java.util.List;

public abstract class Testeable {
	
	private List<Test> list;

	public Testeable() {
		list = new LinkedList<Test>();
	}

	public void init() {
	}

	protected void addTest(Test test) {
		list.add(test);
	}

	public void execute() {
		for (Test t : list) {
			t.run();
		}
	}
	
}
