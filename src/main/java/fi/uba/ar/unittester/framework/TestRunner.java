package fi.uba.ar.unittester.framework;

import java.util.*;

import fi.uba.ar.unittester.framework.TestStorerFactory.StorerType;
import fi.uba.ar.unittester.framework.report.ReportFactory;

import org.apache.commons.lang.Validate;

/**
 * Runs and analyzes {@link Test} associated to it.
 * 
 * @author ivan.bedecarats (igbedecarats@gmail.com)
 */
public class TestRunner {
	public TestRunner() {
	}

	public TestRunner(boolean runOnlyNewFailedAndWithErrors, StorerType storerType){
		if (runOnlyNewFailedAndWithErrors) {
			alreadyPassed = new TestStorerFactory().getStorer(storerType).getStored();
		} else {
			new TestStorerFactory().getStorer(storerType).reset();
		}
	}
	
	public TestRunner(boolean runOnlyNewFailedAndWithErrors) {
		if (runOnlyNewFailedAndWithErrors) {
			alreadyPassed = new TestStorerFactory().getStorer().getStored();
		} else {
			new TestStorerFactory().getStorer().reset();
		}
	}

	/**
	 * Regular expression to match valid tests names.
	 */
	public String validTestRegex = "";

	/**
	 * The tests to be run and analyzed. It's never null nor empty.
	 */
	private List<Test> tests = new ArrayList<Test>();

	private List<String> alreadyPassed = new ArrayList<String>();
	/**
	 * Entity responsible of analyze tests execution.
	 */
	private TestAnalyzer analyzer;
	private ReportFactory factory;

	public void execute(final String... tags) {
		Iterator<Test> iterator = tests.iterator();
		analyzer = new TestAnalyzer();

		// This way all tests in the list have the same context.
		Map<String, Object> context = new HashMap<String, Object>();
		while (iterator.hasNext()) {
			Test test = iterator.next();
			if (!test.hasTag(Test.SKIP_TAG)
					&& (tags.length == 0 || test.hasValidTagToRun(tags)
							&& (!alreadyPassed.contains(test.getTestName())))) {
				if(!alreadyPassed.contains(test.getTestName())){
					test.run(analyzer, context, tags);
				}
			}
			analyzer.clearCurrentTestName();
		}
		// By default we generate a console report but we can change format
		// using setFormat method.
		factory = new ReportFactory(ReportFactory.CONSOLE_REPORT);
		factory.generateReport(analyzer);
	}

	/**
	 * Adds a Test to be run and analyzed.
	 * 
	 * @param test
	 *            The Test to be run and analyzed. It cannot be null.
	 * @return true if test was added, false otherwise
	 */
	public boolean addTest(final Test test) {
		Validate.notNull(test, "The Test cannot be null.");
		String fullName = test.getTestName();
		String name = fullName.substring(fullName.lastIndexOf(".") + 1);
		if (validTestRegex.isEmpty() || name.matches(validTestRegex)) {
			tests.add(test);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add a validTestRegex for matching tests names
	 * 
	 * @param validTestRegex
	 *            The regex expression to be used for matching.
	 */
	public void setValidTestRegex(final String validTestRegex) {
		this.validTestRegex = validTestRegex;
	}

	/**
	 * Disable regex matching.
	 */
	public void clearTestsRegex() {
		validTestRegex = "";
	}

	/**
	 * Returns the analyzer that's been used by the test runner.
	 * 
	 * @return the analyzer that's been used by the test runner.
	 */
	public TestAnalyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * Set the format output to the report.
	 * 
	 * @param format
	 */
	public void setReportFormat(final String format) {
		factory.setFormat(format);
	}

}
