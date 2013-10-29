package TP2;

public class Assert {

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

	public static void AreEquals(Object object1, Object object2, String testName) {
		Reporter r = Reporter.getReporter();
		if (object1.equals(object2)) {
			r.addResult(new ResultOk(testName.concat(": " + object1.toString()
					+ " and " + object2.toString() + " are equals")));
		} else {
			r.addResult(new ResultFail(testName.concat(": "
					+ object1.toString() + " and " + object2.toString()
					+ " are not equals")));
		}

	}

}
