package TP2;

public class ReportConsole extends Reporter {
	private static ReportConsole report;
	private ReportConsole() {
	}
	
	private ReportConsole(Reporter report){
		super(report);
	}

	public void saveResults() {
		for (Result r : reporter.getResults()) {
			if (r.successfull()) {
				System.out.println(r);
			} else {
				System.err.println(r);
			}
		}
		int failures = reporter.getFailures().size();
		if (failures == 0) {
			System.out.println("Test Success");
		} else {
			System.err.println(String.format("Test Fail: %0$2s %2$2s failed",
					failures, failures == 1 ? "test" : "tests"));
		}
	}

	public static ReportConsole getReporter() {
		if(report == null){
			report = new ReportConsole(Reporter.getReporter());
		}
		return report;
		
	}

}
