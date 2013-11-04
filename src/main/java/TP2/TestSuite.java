package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase TestSuite Es lo que implementa el cliente para ejecutar una serie de
 * tests. Debe hacer que sus tests sean ejecutados dentro del metodo init.
 **/

public abstract class TestSuite implements Testeable {
	private String name;
	private List<Testeable> testeables;
	private String pattern;
	
	public TestSuite() {
		name = "";
		pattern="";
		testeables = new LinkedList<Testeable>();
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getPattern(){
		return pattern;
	}
	
	public void setPattern(String pattern){
		this.pattern = pattern;
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
				throw new TestAlreadyAddedException();
			}
		}
		testeables.add(test);
	}

}
