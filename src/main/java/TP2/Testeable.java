package TP2;

/**
 * Clase Testeable Es lo que implementa el cliente para ejecutar una serie de
 * tests. Debe hacer que sus tests sean ejecutados dentro del metodo init.
 **/

public abstract class Testeable {

	public abstract void init();

	public void execute() {
		suiteSetUp();
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

}
