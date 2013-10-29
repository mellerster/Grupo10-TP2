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
		for(Testeable t : list){
			t.init();
			t.execute();
		}
		Reporter reporter = Reporter.getReporter();
		int errorCounter = 0;
		for(Result r : reporter.getResults()){
			System.out.println(r);
			if(!r.successfull()){
				errorCounter++;
			}
		}
		if(errorCounter == 0){
			System.out.println("Test Success");
		}else {
			System.out.println(String.format("Test Fail: %0$2s %2$2s failed",errorCounter,errorCounter == 1? "test":"tests"));
		}
	}

}
