package TP2;

import java.util.HashMap;
import java.util.Map;

/** Fixture
 * Clase que representa la lista de objetos que son instanciados
 * antes de correr los tests.
 **/

public class Fixture {
	
	private Map<String, Object> fixture;
	
	public Fixture() {
		fixture = new HashMap<String, Object>();
	}
	
	public void add(String name, Object object) {
		fixture.put(name, object);
	}
	
	public Object get(String name) {
		return fixture.get(name);
	}
	
	public void addFixture(Fixture other) {
		this.fixture.putAll(other.fixture);
	}
	
}
