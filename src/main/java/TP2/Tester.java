package TP2;

import java.util.LinkedList;
import java.util.List;

public class Tester {
	List<Testeable> list;
	public Tester() {
		list = new LinkedList<Testeable>();
	}

	public void addTests(Testeable t){
		list.add(t);
	}
	
	public void execute(){
		System.out.println("execute");
		for(Testeable t : list){
			t.init();
			t.execute();
		}
	}

}
