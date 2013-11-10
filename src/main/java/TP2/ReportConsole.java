package TP2;

/** ReportConsole
 * Esta clase tiene como responsabilidad, enviar los resultados de las pruebas
 * la consola y un comentario final si pasaron o no todos los tests. 
 * Herencia: Esta clase hereda de Reporter ya que es un reporte, pero en
 * este caso al grabarse (metodo saveResults()) lo muestra por pantalla.
 **/

public class ReportConsole extends Reporter {

	public ReportConsole() {
	}

	public void saveResult(String result){
		System.out.println(result);
		System.out.flush();
	}

}
