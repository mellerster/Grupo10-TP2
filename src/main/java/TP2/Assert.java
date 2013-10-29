package TP2;

import java.util.LinkedList;
import java.util.List;

public class Assert {
	
	static List<Reporter> lstReporter = new LinkedList<Reporter>();
	public Assert() {
	}

	public static void isTrue(boolean aProbar, String testName) {	
		Reporter r = Reporter.getReporter();
		if (aProbar) {
			r.addResult(new ResultOk(testName
					.concat(": Expected true, value true")));
		} else {
			r.addResult(new ResultFail(testName
					.concat(": Expected true, value false")));
		}

	}

	public static void AreEquals(Object uno, Object dos,String testName) {
		Reporter r = Reporter.getReporter();
		if (uno.equals(dos)) {
			r.addResult(new ResultOk(testName
					.concat(": " + uno.toString() + " and " + dos.toString() + " are equals")));
		} else {
			r.addResult(new ResultFail(testName
					.concat(": " + uno.toString() + " and " + dos.toString() + " are not equals")));
		}

	}
	
}
