package TP2;

import java.io.*;

public class ReportText extends Reporter {
	private static ReportText report;

	private ReportText() {
	}

	private ReportText(Reporter report) {
		super(report);
	}

	public void saveResults() {
		FileWriter outFile;
		try {
			String fileName = "Report"+".txt";
			System.out.println(fileName);
			outFile = new FileWriter(fileName);
			PrintWriter out = new PrintWriter(outFile);

			for (Result r : reporter.getResults()) {
				if (r.wasSuccessfull()) {
					out.println(r);
				} else {
					out.println(r);
				}
			}	
			int failures = reporter.getFailures().size();
			if (failures == 0) {
				out.println("All Tests Succeeded");
			} else {
				out.println(String.format("Test Fail: %0$1s %2$2s Failed",
						failures, failures == 1 ? "Test" : "Tests"));
			}
			out.close();
			System.out.print("Grabado");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public static ReportText getReporter() {
		if (report == null) {
			report = new ReportText(Reporter.getReporter());
		}
		return report;
	}
}
