package TP2;

import org.junit.Test;

//import static org.junit.Assert.assertEquals;

public class TestTP2_1 {

	@Test(expected = RuntimeException.class)
	public void UnicityTestCase() {
		TestSuite testeable = new TestSuite() {

			@Override
			protected void init() {
				setName("B");
			}
		};
		testeable.addTest(new TP2.Test("A") {
			public void run() {
			}
		});
		testeable.addTest(new TP2.Test("A") {
			public void run() {
			}
		});
	}

}