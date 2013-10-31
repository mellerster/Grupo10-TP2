package TP2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestTP2 {
	
	@Test
	public void ReportCountIncreaseTest(){
		int beforeResults = Reporter.getReporter().getResults().size();
		Assert.isTrue(true,"");
		assertEquals(beforeResults + 1, Reporter.getReporter().getResults().size());
	}


	@Test
	public void ReportFailCountIncreaseTest(){
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(false,"");
		assertEquals(beforeResults + 1, Reporter.getReporter().getFailures().size());
	}


	@Test
	public void ReportFailCountNotIncreaseTest(){
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(true,"");
		assertEquals(beforeResults, Reporter.getReporter().getFailures().size());
	}


	@Test
	public void ResultOkStateTest(){
		Result result = new ResultOk("Description of result ok");
		assertEquals(true, result.getState());
	}


	@Test
	public void ResultFailStateTest(){
		Result result = new ResultFail("Description of result fail");
		assertEquals(false, result.getState());
	}


	@Test
	public void AssertIsTrueSuccessfullResultTest(){
		Assert.isTrue(true, "");
		assertEquals(true, Reporter.getReporter().getResults().get(Reporter.getReporter().getResults().size()-1).wasSuccessfull());
	}


	@Test
	public void AssertIsTrueNotSuccessfullResultTest(){
		Assert.isTrue(false, "");
		assertEquals(false, Reporter.getReporter().getResults().get(Reporter.getReporter().getResults().size()-1).wasSuccessfull());
	}


	@Test
	public void AssertEqualsSuccessfullResultTest(){
		Assert.AreEquals(1, 1, "");
		assertEquals(true, Reporter.getReporter().getResults().get(Reporter.getReporter().getResults().size()-1).wasSuccessfull());
	}


	@Test
	public void AssertEqualsNotSuccessfullResultTest(){
		Assert.AreEquals(1, 2, "");
		assertEquals(false, Reporter.getReporter().getResults().get(Reporter.getReporter().getResults().size()-1).wasSuccessfull());
	}

}
