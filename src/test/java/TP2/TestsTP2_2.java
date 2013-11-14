package TP2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

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

	@Test
	public void testCaseWitTagAndWithoutAName() {
		Reporter.clear();
		TestSuite TS1 = new TestSuite("TS1") {
			@Override
			protected void init() {
				setPattern("^((?!no correr).)*$");
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
		T2.setTag("FAST");
		TP2.Test T3 = new TP2.Test("T3") {
			@Override
			public void run() {
				Assert.isTrue(true, "T3");
			}
		};
		T3.setTag("SLOW");
		TP2.Test T4 = new TP2.Test("no correr") {
			@Override
			public void run() {
				Assert.isTrue(true, "no correr");
			}
		};
		T4.setTag("SLOW");
		
		TS1.addTest(T1);
		TS1.addTest(T2);
		TS1.addTest(T3);
		TS1.addTest(T4);
		TS1.setTag("SLOW");
		TS1.init();
		TS1.run();
		
		assertEquals(2, Reporter.getReporter().getResults().size());
	}

	@Test
	public void testCaseWitTagsAndWithAName() {
		Reporter.clear();
		TestSuite TS1 = new TestSuite("TS1") {
			@Override
			protected void init() {
				setPattern(".*mysql.*");
			}
		};
		TP2.Test T1 = new TP2.Test("T1") {
			@Override
			public void run() {
				Assert.isTrue(true, "T1");
			}
		};
		T1.setTag("DB");
		TP2.Test T2 = new TP2.Test("T2") {
			@Override
			public void run() {
				Assert.isTrue(true, "T2");
			}
		};
		T2.setTag("DB");
		TP2.Test T3 = new TP2.Test("T3") {
			@Override
			public void run() {
				Assert.isTrue(true, "T3");
			}
		};
		T3.setTag("SLOW");
		TP2.Test T4 = new TP2.Test("Test mysql number 1") {
			@Override
			public void run() {
				Assert.isTrue(true, "Test mysql number 1");
			}
		};
		T4.setTag("DB");
		TP2.Test T5 = new TP2.Test("Test mysql number 2") {
			@Override
			public void run() {
				Assert.isTrue(true, "Test mysql number 2");
			}
		};
		T5.setTag("DB");
		TP2.Test T6 = new TP2.Test("Test mysql number 3") {
			@Override
			public void run() {
				Assert.isTrue(true, "Test mysql number 3");
			}
		};

		TS1.addTest(T1);
		TS1.addTest(T2);
		TS1.addTest(T3);
		TS1.addTest(T4);
		TS1.addTest(T5);
		TS1.addTest(T6);
		TS1.setTag("DB");
		TS1.init();
		TS1.run();
		
		assertEquals(2, Reporter.getReporter().getResults().size());
	}

	@Test
	public void testCaseWithTagInTestSuiteWithSkips() {
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
		TS1.skipTest("T1");
		TS1.init();
		TS1.run();
		
		assertEquals(1, Reporter.getReporter().getResults().size());
	}
	
	@Test
	public void testTimeOfTests() {
		Reporter.clear();
		TestSuite TS1 = new TestSuite("TS") {
			@Override
			protected void init() {
			}
		};
		TP2.Test T1 = new TP2.Test("T1") {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Assert.isTrue(true, "T1");
			}
		};
		TP2.Test T2 = new TP2.Test("T2") {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Assert.isTrue(true, "T2");
			}
		};
		TP2.Test T3 = new TP2.Test("T3") {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Assert.isTrue(true, "T3");
			}
		};

		TS1.addTest(T1);
		TS1.addTest(T2);
		TS1.addTest(T3);
		TS1.init();
		TS1.run();
		
		Map<String, Object> times;
		times = new HashMap<String, Object>();
		for (Result r : Reporter.getReporter().getResults()) {	
			times.put(r.getTestName(), r.getTime());
		}
		
		double time1 = (Double) times.get("[Ok] T1");
		double time2 = (Double) times.get("[Ok] T2");
		double time3 = (Double) times.get("[Ok] T3");
		
		double timeDiff = 0.005;
		assertTrue((time1 < 1+timeDiff) && (time1 > 1-timeDiff));
		assertTrue((time2 < 2+timeDiff) && (time2 > 2-timeDiff));
		assertTrue((time3 < 3+timeDiff) && (time3 > 3-timeDiff));

		double timeTotal = time1 + time2 + time3;
		assertTrue((timeTotal < 6+timeDiff) && (timeTotal > 6-timeDiff));
	}
	

	@Test
	public void testProgressiveReport() {
		// Arrange
		Reporter.clear();
		Reporter.setReportType( new MockedReport() );

		Test t1 = new Test("T1"){
			@override
			public void run(){
				Thread.sleep(1000);
				Assert.isTrue(true, "T3");
			}
		}

		Test t2 = new Test("T2"){
			@override
			public void run(){
				Thread.sleep(1000);
				Assert.isTrue(true, "T3");
			}
		}

		Test t3 = new Test("T3"){
			@override
			public void run(){
				Thread.sleep(1000);
				Assert.isTrue(true, "T3");
			}
		}

		TestSuite TS = new TestSuite("TS") { protected void init() { } }

		TS.addTest( T1 );
		TS.addTest( T2 );
		TS.addTest( T3 );

		// Act
		TS.init();
		TS.run();

		// Assert: Se chequea que los tiempos vayan aumentando
		MockedReport mock = Reporter.getReporter();
		double tiempoAnterior = 0.0;
		for (double tiempoActual : mock.getTimes()){
			assertTrue( tiempoAnterior < tiempoActual );
			tiempoAnterior = tiempoActual;
		}
	}
	
}
