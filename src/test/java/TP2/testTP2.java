package TP2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class testTP2 {
	
	@Test
	public void AssertReportCount(){
		int beforeResults = Reporter.getReporter().getResults().size();
		Assert.isTrue(true,"");
		assertEquals(beforeResults + 1, Reporter.getReporter().getResults().size());
	}
	
	@Test
	public void testResultOkState(){
		Result result = new ResultOk("una descripcion");
		assertEquals(true, result.getState());
	}

	@Test
	public void testResultFailState(){
		Result result = new ResultFail("una descripcion");
		assertEquals(false, result.getState());
	}
	
	@Test
	public void AssertAddSuccessfullResult(){
		Assert.isTrue(true, "");
		assertEquals(true, Reporter.getReporter().getResults().get(Reporter.getReporter().getResults().size()-1).successfull());
	}
	
	@Test
	public void AssertAddNotSuccessfullResult(){
		Assert.isTrue(false, "");
		assertEquals(false, Reporter.getReporter().getResults().get(Reporter.getReporter().getResults().size()-1).successfull());
	}
}
