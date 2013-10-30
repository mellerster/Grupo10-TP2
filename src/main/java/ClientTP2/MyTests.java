package ClientTP2;

import TP2.Assert;
import TP2.Reporter;
import TP2.Result;
import TP2.ResultFail;
import TP2.ResultOk;
import TP2.Test;
import TP2.Testeable;

public class MyTests extends Testeable {

	public MyTests() {
	}

	public void ReportCountIncreaseTest() {
		int beforeResults = Reporter.getReporter().getResults().size();
		Assert.isTrue(true,"ReportCountIncreaseTest");
		Assert.AreEquals(beforeResults + 1, Reporter.getReporter().getResults().size(),"ReportCountIncreaseTest");
	}
	
	public void ReportFailCountIncreaseTest(){
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(false,"ReportFailCountIncreaseTest");
		Assert.AreEquals(beforeResults + 1, Reporter.getReporter().getFailures().size(),"ReportFailCountIncreaseTest");
	}
	
	public void ReportFailCountNotIncreaseTest(){
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(true,"ReportFailCountNotIncreaseTest");
		Assert.AreEquals(beforeResults, Reporter.getReporter().getFailures().size(),"ReportFailCountNotIncreaseTest");
	}
	
	public void ResultOkStateTest(){
		Result result = new ResultOk("ResultOkStateTest");
		Assert.AreEquals(true, result.getState(), "ResultOkStateTest");
	}
	
	public void ResultFailStateTest(){
		Result result = new ResultFail("ResultFailStateTest");
		Assert.AreEquals(false, result.getState(), "ResultFailStateTest");
	}
	
	public void AssertIsTrueSuccessfullResultTest(){
		Assert.isTrue(true, "AssertIsTrueSuccessfullResultTest");
		Assert.AreEquals(true, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1).
				wasSuccessfull(), "AssertIsTrueSuccessfullResultTest");
	}
	
	public void AssertIsTrueNotSuccessfullResultTest(){
		Assert.isTrue(false, "AssertIsTrueNotSuccessfullResultTest");
		Assert.AreEquals(false, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1)
				.wasSuccessfull(), "AssertIsTrueNotSuccessfullResultTest");
	}
	
	public void AssertEqualsSuccessfullResultTest(){
		Assert.AreEquals(1, 1, "AssertEqualsSuccessfullResultTest");
		Assert.AreEquals(true, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1)
				.wasSuccessfull(), "AssertEqualsSuccessfullResultTest");
	}
	
	public void AssertEqualsNotSuccessfullResultTest(){
		Assert.AreEquals(1, 2, "AssertEqualsNotSuccessfullResultTest");
		Assert.AreEquals(false, Reporter.getReporter().getResults()
				.get(Reporter.getReporter().getResults().size()-1)
				.wasSuccessfull(), "AssertEqualsNotSuccessfullResultTest");
	}
	
/*
	public void test1() {
		Assert.isTrue(true,"Test 1");
	}
	
	public void test2() {
		Assert.isTrue(false, "Test 2");
	}
	
	public void test3(){
		Assert.AreEquals(1, 1,"Test 3");
	}
	
	public void test4(){
		Assert.AreEquals(1, 2, "Test 4");
	}
*/
	public void init() {
		super.addTest(new Test() {
			public void run() {
				ReportCountIncreaseTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				ReportFailCountIncreaseTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				ReportFailCountNotIncreaseTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				ResultOkStateTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				ResultFailStateTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				AssertIsTrueSuccessfullResultTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				AssertIsTrueNotSuccessfullResultTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				AssertEqualsSuccessfullResultTest();
			}
		});
		super.addTest(new Test() {
			public void run() {
				AssertEqualsNotSuccessfullResultTest();
			}
		});
/*
		super.addTest(new Test() {
			public void run() {
				test1();
			}
		});
		super.addTest(new Test() {
			public void run() {
				test2();
			}
		});
		super.addTest(new Test() {
			public void run() {
				test3();
			}
		});
		super.addTest(new Test() {
			public void run() {
				test4();
			}
		});
*/
	}
	
}
