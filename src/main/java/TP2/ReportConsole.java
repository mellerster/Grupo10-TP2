package TP2;



public class ReportConsole extends Reporter {

	public ReportConsole() {
		// TODO Auto-generated constructor stub
	}
	public void run(){
		for(Result result : getResults()){
			System.out.println(result.getDescription());
		}
	}


}
