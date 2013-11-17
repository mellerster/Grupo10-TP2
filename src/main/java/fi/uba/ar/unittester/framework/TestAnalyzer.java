package fi.uba.ar.unittester.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;

/**
 * Analyzes the result of tests.
 * 
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */
public class TestAnalyzer {

	/**
	 * The total number of tests which were analyzed.
	 */
	private int testsAnalyzed;
	private int testWithErrors;
	private int testWithFails;
	private int testWithTimeLimit;
	/**
	 * The name of the test currently being tested. It's never null, but it can
	 * be empty if no test is being analyzed.
	 */
	private String currentTestName = "";

	/**
	 * Hold tests that while they were running, there were some
	 * unhandled/unforeseen exceptions, and hence, your test case basically
	 * crashed without executing fully. It's never null, but can be empty. Key:
	 * Test or TestContainer name Value: All the tests that failed in the Test
	 * or TestContainer
	 */
	protected Map<String, List<TestResult>> failures = new HashMap<String, List<TestResult>>();

	/**
	 * Hold tests that was completed successfully, but the test condition of
	 * your test criteria has failed(not what you expected it to be). It's never
	 * null, but can be empty. Key: Test or TestContainer name Value: All the
	 * tests that have an error in the Test or TestContainer
	 */
	protected Map<String, List<TestResult>> errors = new HashMap<String, List<TestResult>>();

	/**
	 * Hold tests that was completed successfully and the test condition of your
	 * test criteria is what you expected. It's never null, but can be empty.
	 * Key: Test or TestContainer name Value: All the tests that have passed in
	 * the Test or TestContainer
	 */
	protected Map<String, List<TestResult>> passed = new HashMap<String, List<TestResult>>();

	protected Map<String, List<TestResult>> timeLimitError = new HashMap<String, List<TestResult>>();
	/**
	 * Hold all tests. It's never null, but can be empty.
	 */
	protected List<String> allTests = new ArrayList<String>();

	/**
	 * Gets the number of successfulTests run.
	 * 
	 * @return The number of successfulTests run.
	 */
	public int getSuccessfulTestsCount() {
		return testsAnalyzed - failures.size() - errors.size();
	}

	/**
	 * Returns the number of analyzed tests.
	 * 
	 * @return the number of analyzed tests.
	 */
	public int getTestsAnalyzedCount() {
		return testsAnalyzed;
	}

	/**
	 * Returns the number of tests that have failed.
	 * 
	 * @return the number of tests that have failed.
	 */
	public int getTestsFailedCount(String testName) {
		List<TestResult> testResults = failures.get(testName);
		return (testResults == null) ? 0 : testResults.size();
	}

	/**
	 * Returns the number of tests that have errors.
	 * 
	 * @return the number of tests that have errors.
	 */
	public int getTestsErrorsCount(String testName) {
		List<TestResult> testResults = errors.get(testName);
		return (testResults == null) ? 0 : testResults.size();
	}

	/**
	 * Returns the tests that have failed.
	 * 
	 * @return tests that have failed. It's never null, but can be empty.
	 */
	public Map<String, List<TestResult>> getFailures() {
		return failures;
	}

	/**
	 * Returns the tests that have errors.
	 * 
	 * @return tests that have errors. It's never null, but can be empty.
	 */
	public Map<String, List<TestResult>> getErrors() {
		return errors;
	}

	/**
	 * Adds a failure test.
	 * 
	 * @param test
	 *            The test that has failed. It cannot be null.
	 * @param message
	 *            A {@link message} about the error. It cannot be null.
	 */
	public void addFailure(final Test test, final String message,
			final long testTime, Throwable throwable) {

		Validate.notNull(test, "The Test cannot be null.");
		Validate.notNull(message, "The throwable cannot be null.");

		TestResult failure = new TestResult(test, message, testTime);
		if (failures.containsKey(currentTestName)) {
			failures.get(currentTestName).add(failure);
		} else {
			List<TestResult> failureList = new ArrayList<TestResult>();
			failureList.add(failure);
			testWithFails++;
			failures.put(currentTestName, failureList);
		}
	}

	/**
	 * Adds an error test.
	 * 
	 * @param test
	 *            The error test. It cannot be null
	 * @param message
	 *            A {@link message} about the error. It cannot be null.
	 */
	public void addError(final Test test, final String message,
			final long testTime, Throwable throwable) {

		Validate.notNull(test, "The Test cannot be null.");
		Validate.notNull(message, "The message cannot be null.");
		Validate.notNull(testTime, "The test time cannot be null.");
		Validate.notNull(throwable, "The throwable cannot be null.");

		currentTestName = currentTestName.isEmpty() ? test.getTestSimpleName()
				: currentTestName;
		TestResult error = new TestResult(test, message, testTime, throwable);
		if (errors.containsKey(currentTestName)) {
			errors.get(currentTestName).add(error);
		} else {
			List<TestResult> errorList = new ArrayList<TestResult>();
			errorList.add(error);
			errors.put(currentTestName, errorList);
		}
		testWithErrors++;
	}

	/**
	 * Adds a passed test.
	 * 
	 * @param test
	 *            The test that has passed. It cannot be null
	 */
	public void addPassed(final Test test, final String message,
			final long testTime) {

		Validate.notNull(test, "The Test cannot be null.");

		String testSimpleName = test.getTestSimpleName();
		currentTestName = currentTestName.isEmpty() ? testSimpleName
				: currentTestName;
		TestResult passedTest = new TestResult(test, message, testTime);

		if (passed.containsKey(currentTestName)) {
			passed.get(currentTestName).add(passedTest);
		} else {
			List<TestResult> passedList = new ArrayList<TestResult>();
			passedList.add(passedTest);
			passed.put(currentTestName, passedList);
		}
	}

	public void addTimeLimitError(final Test test, String message,
			final long testTime, TestTimeLimitException testTimeLimitException) {
		Validate.notNull(test, "The Test cannot be null.");
		Validate.notNull(message, "The message cannot be null.");
		Validate.notNull(testTime, "The test time cannot be null.");
		Validate.notNull(testTimeLimitException, "The throwable cannot be null.");
		String testSimpleName = test.getTestSimpleName();
		currentTestName = currentTestName.isEmpty() ? testSimpleName
				: currentTestName;
		TestResult timeLimitErrorTest = new TestResult(test, message, testTime,testTimeLimitException);

		if (timeLimitError.containsKey(currentTestName)) {
			timeLimitError.get(currentTestName).add(timeLimitErrorTest);
		} else {
			List<TestResult> timeErrorList = new ArrayList<TestResult>();
			timeErrorList.add(timeLimitErrorTest);
			timeLimitError.put(currentTestName, timeErrorList);
		}
		testWithTimeLimit++;
	}

	/**
	 * Adds a test to allTest list.
	 * 
	 * @param test
	 *            The test to be added. It cannot be null.
	 */
	public void addTest(final Test test) {
		Validate.notNull(test, "The Test cannot be null.");

		currentTestName = currentTestName.isEmpty() ? test.getTestSimpleName()
				: currentTestName;
		if (!allTests.contains(getCurrentTestName())) {
			allTests.add(getCurrentTestName());
		}
	}

	/**
	 * Increment the total number of tests and add the new test to allTest list.
	 * 
	 * @param test
	 *            The test to be analyzed. It cannot be null.
	 */
	public void start(final Test test) {
		Validate.notNull(test, "The Test cannot be null.");
		testsAnalyzed++;
		addTest(test);
	}

	/**
	 * Set the name to the test that is being executed. If the test belong to a
	 * TestContainer then testName will be TestContainerName.TestName
	 * 
	 * @param theCurrentTestName
	 *            The name of the Current Test. It cannot be empty nor null.
	 */
	public void setCurrentTestName(final String theCurrentTestName) {
		Validate.notEmpty(theCurrentTestName,
				"The current test name cannot be null nor empty.");
		currentTestName = theCurrentTestName;
	}

	/**
	 * Gets the name of the test that is being executed.
	 * 
	 * @return The name of the test that is being executed.
	 */
	public String getCurrentTestName() {
		return currentTestName;
	}

	/**
	 * Clear the currentTestName
	 */
	public void clearCurrentTestName() {
		currentTestName = "";
	}

	/**
	 * Returns all Tests that were executed.
	 * 
	 * @return All Tests that were executed.
	 */
	public List<String> getAllTests() {
		return allTests;
	}

	/**
	 * Returns all Test that were executed and have passed.
	 * 
	 * @return All Test that were executed and have passed.
	 */
	public Map<String, List<TestResult>> getPassed() {
		return passed;
	}

	public int getTestWithErrors() {
		return testWithErrors;
	}

	public int getTestWithFails() {
		return testWithFails;
	}
	
	public int getTestWithTimeLimitErrors(){
		return testWithTimeLimit;
	}

}
