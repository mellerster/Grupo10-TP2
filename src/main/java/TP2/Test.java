package TP2;

/** Test
 * Esta clase representa los test individuales que se desean probar.
 **/

public abstract class Test implements Testeable {
	
	private String name;
	private Fixture fixture;
	
	public Test(String name) {
		this.name = name;
	}
	
	public abstract void run();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString() {
		return getName();
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
	
}
