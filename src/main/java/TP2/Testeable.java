package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase Testeable Es lo que implementa el cliente para ejecutar una serie de
 * tests. Debe hacer que sus tests sean ejecutados dentro del metodo init.
 **/

public abstract class Testeable {
	
	private List<Test> tests;

	public Testeable() {
		tests = new LinkedList<Test>();
	}

	public abstract void init();

	public void execute() {
		suiteSetUp();
		for (Test t : tests) {
			setUp();
			t.run();
			tearDown();
		}
		suiteTearDown();
	}

	public void setUp() {
	}

	public void tearDown() {
	}

	public void suiteSetUp() {
	}

	public void suiteTearDown() {
	}

	public void addTest(Test test) {
		tests.add(test);
	}

}
