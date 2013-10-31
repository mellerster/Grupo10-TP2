package ClientTP2;

import TP2.Assert;
import TP2.Reporter;
import TP2.Result;
import TP2.ResultFail;
import TP2.ResultOk;
import TP2.Testeable;

public class MyTests implements Testeable {

	public MyTests() {
	}

	public void ReportCountIncreaseTest() {
		int beforeResults = Reporter.getReporter().getResults().size();
		Assert.isTrue(true,"ReportCountIncreaseTest");
		Assert.AreEquals(beforeResults + 1, Reporter.getReporter()
				.getResults().size(),"ReportCountIncreaseTest");
	}
	
	public void ReportFailCountIncreaseTest() {
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(false,"ReportFailCountIncreaseTest");
		Assert.AreEquals(beforeResults + 1, Reporter.getReporter()
				.getFailures().size(),"ReportFailCountIncreaseTest");
	}
	
	public void ReportFailCountNotIncreaseTest() {
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(true,"ReportFailCountNotIncreaseTest");
		Assert.AreEquals(beforeResults, Reporter.getReporter()
				.getFailures().size(),"ReportFailCountNotIncreaseTest");
	}
	
	public void ResultOkStateTest() {
		Result result = new ResultOk("ResultOkStateTest");
		Assert.AreEquals(true, result.getState(), "ResultOkStateTest");
	}
	
	public void ResultFailStateTest() {
		Result result = new ResultFail("ResultFailStateTest");
		Assert.AreEquals(false, result.getState(), "ResultFailStateTest");
	}
	
	public void AssertIsTrueSuccessfullResultTest() {
		Assert.isTrue(true, "AssertIsTrueSuccessfullResultTest");
		Assert.AreEquals(true, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1).
				wasSuccessfull(), "AssertIsTrueSuccessfullResultTest");
	}
	
	public void AssertIsTrueNotSuccessfullResultTest() {
		Assert.isTrue(false, "AssertIsTrueNotSuccessfullResultTest");
		Assert.AreEquals(false, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1)
				.wasSuccessfull(), "AssertIsTrueNotSuccessfullResultTest");
	}
	
	public void AssertEqualsSuccessfullResultTest() {
		Assert.AreEquals(1, 1, "AssertEqualsSuccessfullResultTest");
		Assert.AreEquals(true, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1)
				.wasSuccessfull(), "AssertEqualsSuccessfullResultTest");
	}
	
	public void AssertEqualsNotSuccessfullResultTest() {
		Assert.AreEquals(1, 2, "AssertEqualsNotSuccessfullResultTest");
		Assert.AreEquals(false, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1)
				.wasSuccessfull(), "AssertEqualsNotSuccessfullResultTest");
	}
	
	public void init() {
		ReportCountIncreaseTest();
		ReportFailCountIncreaseTest();
		ReportFailCountNotIncreaseTest();
		ResultOkStateTest();
		ResultFailStateTest();
		AssertIsTrueSuccessfullResultTest();
		AssertIsTrueNotSuccessfullResultTest();
		AssertEqualsSuccessfullResultTest();
		AssertEqualsNotSuccessfullResultTest();
	}
	
}
