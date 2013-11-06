package TP2;

public abstract class Test implements Testeable {
	
	private String name;
	
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
	
	public String getPattern(){
		return ".*";
	}
	
	public void setPattern(String pattern) {
	}
	
	public void addFixture(Fixture fixture){		
	}
	
}
