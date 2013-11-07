package TP2;

import java.util.HashMap;
import java.util.Map;

public class Fixture {
	private Map<String, Object> fixture;
	
	public Fixture(){
		fixture = new HashMap<String, Object>();
	}
	
	public void add(String name, Object object){
		fixture.put(name, object);
	}
	
	public Object get(String name){
		return fixture.get(name);
	}
	
	public void addFixture(Fixture other){
		this.fixture.putAll(other.fixture);
	}
	
}
