package TP2;

import java.io.NotActiveException;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase TestSuite Es lo que implementa el cliente para ejecutar una serie de
 * tests. Debe hacer que sus tests sean ejecutados dentro del metodo init.
 **/

public abstract class TestSuite implements Testeable {
	private String name;
	private List<Testeable> testeables;

	public TestSuite() {
		name = "";
		testeables = new LinkedList<Testeable>();
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected abstract void init();

	public void run() {
		suiteSetUp();
		for (Testeable t : testeables) {
			setUp();
			t.run();
			tearDown();
		}
		suiteTearDown();
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	protected void suiteSetUp() {
	}

	protected void suiteTearDown() {
	}

	public String toString() {
		return getName();
	}

	protected void addTest(Testeable test) {
		for (Testeable t : testeables) {
			if (t.getName().equals(test.getName())) {
				throw new RuntimeException();

			}
		}
		testeables.add(test);
	}

}
