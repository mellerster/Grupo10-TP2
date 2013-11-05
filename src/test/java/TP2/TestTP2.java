package TP2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTP2 {
	TP2.TestSuite testSuite;

	@Before
	public void setUp() {
		testSuite = new TestSuite() {
			public void init() {
				setName("B");
			}
		};
	}

	@Test
	public void ReportCountIncreaseTest() {
		int beforeResults = Reporter.getReporter().getResults().size();
		TP2.Test test = new TP2.Test("A") {
			public void run() {
				Assert.isTrue(true, "");
			}
		};
		testSuite.addTest(test);
		testSuite.run();

		assertEquals(beforeResults + 1, Reporter.getReporter().getResults()
				.size());
	}

	@Test(expected = AssertFailedException.class)
	public void ReportFailCountIncreaseTest() {
		int beforeResults = Reporter.getReporter().getFailures().size();
		Assert.isTrue(false, "");
		assertEquals(beforeResults + 1, Reporter.getReporter().getFailures()
				.size());
	}

	@Test
	public void ReportFailCountNotIncreaseTest() {
		int beforeResults = Reporter.getReporter().getFailures().size();

		TP2.Test test = new TP2.Test("A") {
			public void run() {
				Assert.isTrue(true, "");
			}
		};
		testSuite.addTest(test);
		testSuite.run();

		assertEquals(beforeResults, Reporter.getReporter().getFailures().size());
	}

	@Test
	public void ResultOkStateTest() {
		Result result = new ResultOk("Description of result ok");
		assertEquals(true, result.getState() == ResultType.Ok);
	}

	@Test
	public void ResultFailStateTest() {
		Result result = new ResultFail("Description of result fail");
		assertEquals(true, result.getState() == ResultType.Fail);
	}
	
	@Test
	public void ResultErrorStateTest() {
		Result result = new ResultError("Description of result error");
		assertEquals(true, result.getState() == ResultType.Error);
	}

	@Test
	public void AssertIsTrueSuccessfullResultTest() {
		Assert.isTrue(true, "");
		assertEquals(
				true,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull());
	}

	@Test(expected = AssertFailedException.class)
	public void AssertIsTrueNotSuccessfullResultTest() {
		Assert.isTrue(false, "");
		assertEquals(
				false,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull());
	}

	@Test
	public void AssertEqualsSuccessfullResultTest() {
		TP2.Test test = new TP2.Test("A") {
			public void run() {
				Assert.AreEquals(1, 1, "");
			}
		};
		testSuite.addTest(test);
		testSuite.run();
		assertEquals(
				true,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull());
	}

	@Test(expected = AssertFailedException.class)
	public void AssertEqualsNotSuccessfullResultTest() {
		Assert.AreEquals(1, 2, "");
		assertEquals(
				false,
				Reporter.getReporter().getResults()
						.get(Reporter.getReporter().getResults().size() - 1)
						.wasSuccessfull());
	}

}
