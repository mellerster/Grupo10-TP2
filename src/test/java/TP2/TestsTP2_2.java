package TP2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestsTP2_2 {

	@Test
	public void testCaseWithTagFromTestSuite() {
		TestSuite TS1 = new TestSuite("TS1") {

			@Override
			protected void init() {
			}

		};
		TP2.Test T1 = new TP2.Test("T1") {

			@Override
			public void run() {
				Assert.isTrue(true, "T1");
			}

		};
		T1.setTag("SLOW");
		TP2.Test T2 = new TP2.Test("T2") {

			@Override
			public void run() {
				Assert.isTrue(true, "T2");
			}

		};
		TP2.Test T3 = new TP2.Test("T3") {

			@Override
			public void run() {
				Assert.isTrue(true, "T3");
			}

		};
		T3.setTag("SLOW");
		TS1.addTest(T1);
		TS1.addTest(T2);
		TS1.addTest(T3);
		TS1.setTag("SLOW");
		TS1.init();
		TS1.run();
		assertEquals(2, Reporter.getReporter().getResults().size());
	}
}
