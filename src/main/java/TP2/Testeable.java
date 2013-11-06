package TP2;

/** Testeable
 * Es lo que implementa el cliente para ejecutar una serie de tests,
 * debe hacer que sus tests sean ejecutados dentro del metodo init().
 **/

public interface Testeable {
	public void run();
	public void setName(String name);
	public String getName();
	public void setPattern(String pattern);
	public String getPattern();
	public void addFixture(Fixture fixture);
}
