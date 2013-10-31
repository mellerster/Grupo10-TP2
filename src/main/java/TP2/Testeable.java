package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase Testeable Es lo que implementa el cliente para ejecutar una serie de
 * tests. Debe hacer que sus tests sean ejecutados dentro del metodo init.
 **/

public abstract class Testeable {
	private String name;
	private List<Test> tests;

	public Testeable() {
		name = "";
		tests = new LinkedList<Test>();
	}

	protected void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	protected abstract void init();

	public void execute() {
		suiteSetUp();
		for (Test t : tests) {
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

	protected void addTest(Test test) {
		tests.add(test);
	}

}
