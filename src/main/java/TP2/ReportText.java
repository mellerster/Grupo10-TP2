package TP2;

import java.io.*;

/** ReportText 
 * Esta clase tiene como responsabilidad, enviar los resultados de
 * las pruebas a un archivo de texto y un comentario final si pasaron o no todos
 * los tests. Herencia: Esta clase hereda de Reporter ya que es un reporte, pero
 * en este caso al grabarse (metodo saveResults()) lo graba en un archivo de
 * texto.
 **/

public class ReportText extends Reporter {

	public ReportText() {
	}
	
	public void saveResults() {
		super.saveResults();
		String fileName = "Report.txt";
		String path = fileName;
		System.out.println("Report saved at path: " + path);
		System.out.flush();

	}

	public void saveResult(String result) {
		FileWriter outFile;
		try {
			String fileName = "Report.txt";
			outFile = new FileWriter(fileName, true);
			PrintWriter out = new PrintWriter(outFile);
			out.print(result);
			out.print("\n");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
