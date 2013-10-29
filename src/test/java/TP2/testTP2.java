package TP2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class testTP2 {
	
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

}
