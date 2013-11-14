package TP2;

import java.util.LinkedList;


public class MockedReport extends Reporter {

	private double ultimoTiempo;
	private LinkedList<double> lTiempos;

	public MockedReport(){
		ultimoTiempo = 0.0;
		lTiempos = new LinkedList<double>();
	}


	@override
	public void addResult(Result result) {
		double tiempo = result.getTime();
		double tiempoTotal = tiempo + ultimoTiempo;
		lTiempos.add( tiempoTotal );
	}


	public void saveResult(String result) { }

	
	public LinkedList<double> getTimes(){
		return lTiempos;
	}
}


