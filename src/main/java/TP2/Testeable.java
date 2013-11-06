package TP2;

/** Testeable
 * Es una interfaz que define los metodos que deben impplementar
 * las clases que sean testeables.
 **/

public interface Testeable {
	
	public void run();
	public void setName(String name);
	public String getName();
	public void setPattern(String pattern);
	public String getPattern();
	public void addFixture(Fixture fixture);
	
}
