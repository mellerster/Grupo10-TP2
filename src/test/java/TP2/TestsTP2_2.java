package TP2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestsTP2_2 {

	@Test
	public void testCaseWithTagFromTestSuite() {
		Reporter.clear();
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

	@Test
	public void testCaseWithAnyOfTheTestSuiteTags() {
		Reporter.clear();
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
		T1.setTag("DB");
		TP2.Test T2 = new TP2.Test("T2") {

			@Override
			public void run() {
				Assert.isTrue(true, "T2");
			}

		};
		T2.setTag("SLOW");
		TP2.Test T3 = new TP2.Test("T3") {

			@Override
			public void run() {
				Assert.isTrue(true, "T3");
			}

		};
		T3.setTag("DB");
		TP2.Test T4 = new TP2.Test("T4") {

			@Override
			public void run() {
				Assert.isTrue(true, "T4");
			}

		};
		T4.setTag("FAST");
		TP2.Test T5 = new TP2.Test("T5") {

			@Override
			public void run() {
				Assert.isTrue(true, "T5");
			}

		};
		T5.setTag("SMOKE");
		TP2.Test T6 = new TP2.Test("T6") {

			@Override
			public void run() {
				Assert.isTrue(true, "T6");
			}

		};

		TS1.addTest(T1);
		TS1.addTest(T2);
		TS1.addTest(T3);
		TS1.addTest(T4);
		TS1.addTest(T5);
		TS1.addTest(T6);
		TS1.setTag("DB");
		TS1.setTag("FAST");
		TS1.setTag("SMOKE");
		TS1.init();
		TS1.run();
		assertEquals(4, Reporter.getReporter().getResults().size());
	}
}