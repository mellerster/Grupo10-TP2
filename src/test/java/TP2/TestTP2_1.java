package TP2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestTP2_1 {

	@Test(expected = TestAlreadyAddedException.class)
	public void UnicityTestCase() {
		TestSuite testSuiteB = new TestSuite("B") {
			@Override
			protected void init() { }
		};
		testSuiteB.addTest(new TP2.Test("A") {
			public void run() { }
		});	
		testSuiteB.addTest(new TP2.Test("A") {
			public void run() { }
		});
	}

	@Test(expected = TestAlreadyAddedException.class)
	public void UnicityTestSuite() {
		TestSuite testSuiteB = new TestSuite("B") {
			@Override
			protected void init() { }
		};
		TestSuite testSuiteA = new TestSuite("A") {
			@Override
			protected void init() { }
		};
		testSuiteB.addTest(testSuiteA);
		testSuiteB.addTest(testSuiteA);
	}

	String out;
	@Test
	public void TestSetUp() {
		out = "";
		TestSuite testSuiteA = new TestSuite("A") {
			@Override
			protected void init() { }
			@Override
			protected void setUp() {
				out += "setUp --> ";
			}
		};
		TP2.Test testB = new TP2.Test("B") {
			@Override
			public void run() {
				out += "testCase Run";
			}
		};
		testSuiteA.addTest(testB);
		testSuiteA.init();
		testSuiteA.run();
		org.junit.Assert.assertEquals("setUp --> testCase Run", out);
	}

	@Test
	public void TestCaseFailure() {
		Reporter.clear();
		TP2.Test testFailure = new TP2.Test("withFailure") {
			@Override
			public void run() {
				Assert.isTrue(false, "withFailure");
			}
		};
		TestSuite testSuite = new TestSuite("testSuite") {
			@Override
			protected void init() { }
		};
		testSuite.addTest(testFailure);
		testSuite.init();
		testSuite.run();
		assertEquals(1, Reporter.getReporter().getFailures().size());
	}

	@Test
	public void testCaseError() {
		Reporter.clear();
		TP2.Test testError = new TP2.Test("withError") {
			@Override
			public void run() {
				throw new RuntimeException();
			}
		};
		TestSuite testSuite = new TestSuite("testSuite") {
			@Override
			protected void init() { }
		};
		testSuite.addTest(testError);
		testSuite.init();
		testSuite.run();
		assertEquals(1, Reporter.getReporter().getErrors().size());
	}

	@Test
	public void specialTests() {
		Reporter.clear();
		TP2.Test testMySpecialTestCase = new TP2.Test("my special test case") {
			@Override
			public void run() {
				Assert.isTrue(true, "my special test case");
			}
		};
		TP2.Test testMySpecialTestCase1 = new TP2.Test("my special test case 1") {
			@Override
			public void run() {
				Assert.isTrue(true, "my special test case 1");
			}
		};
		TP2.Test testMySpecial = new TP2.Test("my special") {
			@Override
			public void run() {
				Assert.isTrue(true, "my special");
			}
		};
		TP2.Test testATest = new TP2.Test("a test") {
			@Override
			public void run() {
				Assert.isTrue(true, "a test");
			}
		};
		TP2.TestSuite testSuite = new TP2.TestSuite() {
			@Override
			protected void init() {
				setPattern(".*special.*");
			}
		};
		testSuite.addTest(testMySpecial);
		testSuite.addTest(testMySpecialTestCase);
		testSuite.addTest(testMySpecialTestCase1);
		testSuite.addTest(testATest);
		testSuite.init();
		testSuite.run();
		assertEquals(3, Reporter.getReporter().getResults().size());
	}

	@Test
	public void UnexistentName() {
		Reporter.clear();
		TP2.Test testMySpecialTestCase = new TP2.Test("my special test case") {
			@Override
			public void run() {
				Assert.isTrue(true, "my special test case");
			}
		};
		TP2.Test testMySpecialTestCase1 = new TP2.Test("my special test case 1") {
			@Override
			public void run() {
				Assert.isTrue(true, "my special test case 1");
			}
		};
		TP2.Test testMySpecial = new TP2.Test("my special") {
			@Override
			public void run() {
				Assert.isTrue(true, "my special");
			}
		};
		TP2.Test testATest = new TP2.Test("a test") {
			@Override
			public void run() {
				Assert.isTrue(true, "a test");
			}
		};
		TP2.TestSuite testSuite = new TP2.TestSuite() {
			@Override
			protected void init() {
				setPattern(".*no existe");
			}
		};
		testSuite.addTest(testMySpecial);
		testSuite.addTest(testMySpecialTestCase);
		testSuite.addTest(testMySpecialTestCase1);
		testSuite.addTest(testATest);
		testSuite.init();
		testSuite.run();
		assertEquals(0, Reporter.getReporter().getResults().size());
	}

	@Test
	public void testSetupTestSuite(){
		final StringBuilder result = new StringBuilder("");
		TP2.TestSuite testSuite = new TP2.TestSuite(){
			protected void init(){ }
			protected void setUp(){ result.append("setup+"); }
			public void test1(){ result.append("test1+"); }
			public void test2(){ result.append("test2+"); }
			@Override
			public void run(){
				super.addTest( new TP2.Test("test1"){ public void run(){ test1(); } });
				super.addTest( new TP2.Test("test2"){ public void run(){ test2(); } });
				super.run();
			}
		};
		testSuite.run();
		assertEquals("setup+test1+setup+test2+", result.toString());
	}


	@Test
	public void testSetupEnSuiteEnSuite_1(){
		// Arrange: un testCase dentro de un testSuite que esta dentro de otro testSuite
		TP2.Test tCase = new TP2.Test("t"){ public void run(){ } };
		
		TP2.TestSuite tsInner = new TP2.TestSuite(){
			protected void init(){ }
			protected void setUp(){ }
		};
		
		TP2.TestSuite tsOutter = new TP2.TestSuite(){ protected void init(){ } };
		
		tsInner.addTest( tCase );
		tsOutter.addTest( tsInner );
		
		// Act
		tsOutter.run();
		
		// TODO: Setup en testSuite de testSuite
	}


	@Test
	public void testSetupEnSuiteEnSuite_2(){
		// TODO: Setup en testSuite de testSuite
	}


	@Test
	public void testSetupEnSuiteEnSuite_3(){
		// TODO: Setup en testSuite de testSuite
	}


	@Test
	public void testSetupEnSuiteEnSuite(){
		final StringBuilder result = new StringBuilder("");
		TP2.TestSuite testSuiteB = new TP2.TestSuite("B") {
			protected void init(){ }
			protected void suiteSetUp(){ result.append("setupB+"); }
			public void testB(){ result.append("testB+"); }
			@Override
			public void run(){
				super.addTest( new TP2.Test("testB") { public void run(){ testB(); } });
				super.run();
			}
		};
		TP2.TestSuite testSuiteC = new TP2.TestSuite("C") {
			protected void init(){ }
			protected void suiteSetUp(){ result.append("setupC+"); }
			public void testC(){ result.append("testC+"); }
			@Override
			public void run(){
				super.addTest( new TP2.Test("testC"){ public void run(){ testC(); } });
				super.run();
			}
		};
		TP2.TestSuite tSuiteA = new TP2.TestSuite("A") {
			protected void init(){ }
			protected void suiteSetUp(){ result.append("setupA+"); }
			@Override
			public void run() {
				super.run();
			}
		};
		tSuiteA.addTest(testSuiteB);
		tSuiteA.addTest(testSuiteC);
		tSuiteA.run();
		assertEquals("setupA+setupB+testB+setupC+testC+", result.toString());
	}


	@Test
	public void testFixtureTest() {
		Reporter.clear();
		TestSuite testSuiteA = new TestSuite("A") {
			@Override
			protected void init() { }
			public void suiteSetUp() {
				String stringA = "setUpA";
				getFixture().add("stringA", stringA);
			}
			public void setUp() {
				String stringTestCase = "stringTestCase";
				getFixture().add("stringTestCase", stringTestCase);
			}
		};
		TestSuite testSuiteB = new TestSuite("B") {
			@Override
			protected void init() { }
			public void suiteSetUp() {
				String stringB = "setUpB";
				getFixture().add("stringB", stringB);
			}
		};
		testSuiteB.addTest(testSuiteA);
		TP2.Test testCase = new TP2.Test("testCase") {
			@Override
			public void run() {
				String stringA = (String)getFixture().get("stringA");
				String stringB = (String)getFixture().get("stringB");
				String stringTestCase = (String)getFixture().get("stringTestCase");
				String allTogether = stringA.concat(stringB.concat(stringTestCase));
				Assert.AreEquals(allTogether, "setUpAsetUpBstringTestCase" , "");
			}
		};
		testSuiteA.addTest(testCase);
		testSuiteB.init();
		testSuiteB.run();
		assertTrue(Reporter.getReporter().getResults().get(0).wasSuccessfull());
	}

	@Test(expected = AssertFailedException.class)
	public void TestFailure() {
		new TP2.Test("TestFailure") {
			public void run() { }
		};
		Assert.Fail("TestFailure");
	}
	
	@Test
	public void TestClearOfReporter() {
		TP2.Test testOk = new TP2.Test("test") {
			@Override
			public void run() {
				Assert.isTrue(true, "testOk");
				Assert.Fail("testOk");
				throw new RuntimeException();
			}
		};
		TP2.Test testFail = new TP2.Test("testFail") {
			@Override
			public void run() {
				Assert.Fail("testFail");
			}
		};
		TP2.Test testError = new TP2.Test("testError") {
			@Override
			public void run() {
				throw new RuntimeException();
			}
		};
		TestSuite testSuite = new TestSuite("testSuite") {
			@Override
			protected void init() { }
		};
		testSuite.addTest(testOk);
		testSuite.addTest(testFail);
		testSuite.addTest(testError);
		testSuite.init();
		testSuite.run();
		Reporter.clear();
		assertEquals(0, Reporter.getReporter().getResults().size());
		assertEquals(0, Reporter.getReporter().getFailures().size());
		assertEquals(0, Reporter.getReporter().getErrors().size());
	}

}
