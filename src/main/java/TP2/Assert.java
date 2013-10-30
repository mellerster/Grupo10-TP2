package TP2;

public class Assert {

	public Assert() {
	}

	public static void isTrue(boolean toTest, String testName) {
		Reporter reporter = Reporter.getReporter();
		if (toTest) {
			reporter.addResult(new ResultOk(testName
					.concat(": Expected true, value true")));
		} else {
			reporter.addResult(new ResultFail(testName
					.concat(": Expected true, value false")));
		}
	}

	public static void AreEquals(Object object1, Object object2, String testName) {
		Reporter reporter = Reporter.getReporter();
		if (object1.equals(object2)) {
			reporter.addResult(new ResultOk(testName.concat(": " + object1.toString()
					+ " and " + object2.toString() + " are equals")));
		} else {
			reporter.addResult(new ResultFail(testName.concat(": "
					+ object1.toString() + " and " + object2.toString()
					+ " are not equals")));
		}
	}

}
