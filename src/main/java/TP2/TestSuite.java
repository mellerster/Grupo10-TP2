package TP2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * TestSuite Es lo que implementa el cliente para ejecutar una serie de tests.
 * Debe hacer que sus tests sean ejecutados dentro del metodo init().
 **/

public abstract class TestSuite implements Testeable {

	private String name;
	private String packageName;
	private String pattern;
	private Fixture fixture;
	private List<TestSuite> testSuites;
	private List<Test> tests;
	private List<String> tagsToSearch;

	public TestSuite() {
		setName(name);
		packageName = "";
		pattern = ".*";
		fixture = new Fixture();
		tests = new LinkedList<Test>();
		testSuites = new LinkedList<TestSuite>();
		tagsToSearch = new LinkedList<String>();
	}

	public TestSuite(String name) {
		setName(name);
		packageName = "";
		pattern = ".*";
		fixture = new Fixture();
		testSuites = new LinkedList<TestSuite>();
		tests = new LinkedList<Test>();
		tagsToSearch = new LinkedList<String>();
	}

	public void setName(String name) {
		this.name = name;
		if (getPackageName() == "") {
			setPackageName(name);
			;
		}
	}

	public String getName() {
		return name;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	protected abstract void init();

	public void run() {
		suiteSetUp();
		Reporter reporter = Reporter.getReporter();
		for (TestSuite t : testSuites) {
			t.init();
			t.addFixture(getFixture());
			t.setPattern(getPattern());
			t.run();
		}
		for (Test t : tests) {
			setUp();
			Date before = new Date();
			try {
				if (isTestInPattern(t) && testWithAnyTag(t)) {
					t.setFixture(getFixture());
					t.run();
					reporter.addResult(new ResultOk(t.getName(),
							getPackageName(), CalculateTimeInSeconds(before)));
				}
			} catch (AssertFailedException e) {
				reporter.addResult(new ResultFail(t.getName(),
						getPackageName(), CalculateTimeInSeconds(before), e
								.getMessage()));
			} catch (Exception e) {
				reporter.addResult(new ResultError(t.getName(),
						getPackageName(), CalculateTimeInSeconds(before), e
								.getMessage()));
			}
			tearDown();
		}
		suiteTearDown();
	}

	private boolean testWithAnyTag(Test t) {
		if (tagsToSearch.size() == 0) {
			return true;
		}

		for (String tag : tagsToSearch) {
			if (t.hasTag(tag)) {
				return true;
			}
		}
		return false;
	}

	private double CalculateTimeInSeconds(Date before) {
		Date after = new Date();
		double time = after.getTime() - before.getTime();
		double timeInSeconds = time / 1000;
		return timeInSeconds;
	}

	public void addFixture(Fixture fixture) {
		this.fixture.addFixture(fixture);
	}

	public Fixture getFixture() {
		return fixture;
	}

	private boolean isTestInPattern(Testeable t) {
		return t.getName().matches(getPattern());
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	protected void suiteSetUp() {
	}

	protected void suiteTearDown() {
	}

	public String toString() {
		return getName();
	}

	private void checkNameInList(String name, List<?> list) {
		for (Object t : list) {
			if (t.toString().equals(name)) {
				throw new TestAlreadyAddedException();
			}
		}
	}

	protected void addTest(TestSuite testSuite) {
		checkNameInList(testSuite.getName(), testSuites);
		testSuite.setPackageName(packageName);
		testSuites.add(testSuite);
	}

	protected void addTest(Test test) {
		checkNameInList(test.getName(), tests);
		tests.add(test);
	}

	public void setPackageName(String packageName) {
		String dot = "";
		if (this.packageName != "") {
			dot = ".";
		}
		this.packageName = packageName + dot + this.packageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setTag(String tag) {
		tagsToSearch.add(tag);
	}
}
