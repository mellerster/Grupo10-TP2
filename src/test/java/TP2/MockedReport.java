package TP2;

import java.util.ArrayList;


public class MockedReport extends Reporter {

	private Double ultimoTiempo;
	private ArrayList<Double> lTiempos;

	public MockedReport(){
		ultimoTiempo = 0.0;
		lTiempos = new ArrayList<Double>();
	}


	@Override
	public void addResult(Result result) {
		Double tiempo = result.getTime();
		Double tiempoTotal = tiempo + ultimoTiempo;
		lTiempos.add( tiempoTotal );
	}


	public void saveResult(String result) { }


	public ArrayList<Double> getTimes(){
		return lTiempos;
	}
}


