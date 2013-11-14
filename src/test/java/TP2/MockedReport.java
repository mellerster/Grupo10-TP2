package TP2;

import java.util.LinkedList;


public class MockedReport extends Reporter {

	private LinkedList<double> lTiempos;

	public MockedReport(){
		lTiempos = new LinkedList<double>();
	}


	@override
	public void addResult(Result result) {
		double tiempo = result.getTime();
		lTiempos.add( tiempo );
	}


	public void saveResult(String result) { }

	
	public LinkedList<double> getTimes(){
		return lTiempos;
	}
}


