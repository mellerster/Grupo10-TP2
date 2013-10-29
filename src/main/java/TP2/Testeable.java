package TP2;

import java.util.LinkedList;
import java.util.List;

public abstract class Testeable {
	List<Test> lista;

	public Testeable() {
		lista = new LinkedList<Test>();
	}

	public void init() {
	};

	protected void addTest(Test test) {
		lista.add(test);
	}
	
	public void execute(){
		for(Test t : lista){
			t.run();
		}
	}
}
