package ClientTP2;

import TP2.Assert;
import TP2.AssertFailedException;
import TP2.Reporter;
import TP2.Result;
import TP2.ResultError;
import TP2.ResultFail;
import TP2.ResultOk;
import TP2.ResultType;
import TP2.TestSuite;
import TP2.Test;

public class MyTests extends TestSuite {

	public MyTests() {
		super();
	}

	public void ReportFailCountIncreaseTest() {
		int beforeResults = Reporter.getReporter().getFailures().size();
		try {
			Assert.isTrue(false, "ReportFailCountIncreaseTest");
		} catch (AssertFailedException e) {
		}

		Assert.AreEquals(beforeResults + 1, Reporter.getReporter()
				.getFailures().size(), "ReportFailCountIncreaseTest");
	}

	public void ReportFailCountNotIncreaseTest() {
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(true, "ReportFailCountNotIncreaseTest");
		Assert.AreEquals(beforeResults, Reporter.getReporter().getFailures()
				.size(), "ReportFailCountNotIncreaseTest");
	}

	public void ResultOkStateTest() {
		Result result = new ResultOk("ResultOkStateTest");
		Assert.AreEquals(true, result.getState() == ResultType.Ok,
				"ResultOkStateTest");
	}

	public void ResultFailStateTest() {
		Result result = new ResultFail("ResultFailStateTest");
		Assert.AreEquals(true, result.getState() == ResultType.Fail,
				"ResultFailStateTest");
	}

	public void ResultErrorStateTest() {
		Result result = new ResultError("ResultErrorStateTest");
		Assert.AreEquals(true, result.getState() == ResultType.Error,
				"ResultFailStateTest");
	}

	public void AssertIsTrueSuccessfullResultTest() {
		try {
			Assert.isTrue(true, "AssertIsTrueSuccessfullResultTest");
		} catch (AssertFailedException e) {
		}
		Assert.AreEquals(
				true,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull(), "AssertIsTrueSuccessfullResultTest");
	}

	public void AssertIsTrueNotSuccessfullResultTest() {
		try {
			Assert.isTrue(false, "AssertIsTrueNotSuccessfullResultTest");
		} catch (AssertFailedException e) {
		}
		Assert.AreEquals(
				false,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull(),
				"AssertIsTrueNotSuccessfullResultTest");
	}

	public void AssertEqualsSuccessfullResultTest() {
		try {
			Assert.AreEquals(1, 1, "AssertEqualsSuccessfullResultTest");
		} catch (AssertFailedException e) {
		}
		Assert.AreEquals(
				true,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull(), "AssertEqualsSuccessfullResultTest");
	}

	public void AssertEqualsNotSuccessfullResultTest() {
		try {
			Assert.AreEquals(1, 2, "AssertEqualsNotSuccessfullResultTest");
		} catch (AssertFailedException e) {
		}
		Assert.AreEquals(
				false,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull(),
				"AssertEqualsNotSuccessfullResultTest");
	}

	@Override
	public void run() {

		setName("MyTests");

		super.addTest(new Test("ReportFailCountIncreaseTest") {
			public void run() {
				ReportFailCountIncreaseTest();
			}
		});

		super.addTest(new Test("ReportFailCountNotIncreaseTest") {
			public void run() {
				ReportFailCountNotIncreaseTest();
			}
		});

		super.addTest(new Test("ResultOkStateTest") {
			public void run() {
				ResultOkStateTest();
			}
		});

		super.addTest(new Test("ResultFailStateTest") {
			public void run() {
				ResultFailStateTest();
			}
		});

		super.addTest(new Test("AssertIsTrueSuccessfullResultTest") {
			public void run() {
				AssertIsTrueSuccessfullResultTest();
			}
		});

		super.addTest(new Test("AssertIsTrueNotSuccessfullResultTest") {
			public void run() {
				AssertIsTrueNotSuccessfullResultTest();
			}
		});

		super.addTest(new Test("AssertEqualsSuccessfullResultTest") {
			public void run() {
				AssertEqualsSuccessfullResultTest();
			}
		});

		super.addTest(new Test("AssertEqualsNotSuccessfullResultTest") {
			public void run() {
				AssertEqualsNotSuccessfullResultTest();
			}
		});

		super.run();
	}

	public void init() {
	}

}
