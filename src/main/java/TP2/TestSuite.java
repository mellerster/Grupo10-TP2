package TP2;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase TestSuite Es lo que implementa el cliente para ejecutar una serie de
 * tests. Debe hacer que sus tests sean ejecutados dentro del metodo init.
 **/

public abstract class TestSuite implements Testeable {
	private String name;
	private List<Testeable> testeables;
	private String pattern;
	private Fixture fixture;
	public TestSuite() {
		name = "";
		pattern = "";
		testeables = new LinkedList<Testeable>();
		fixture = new Fixture();
	}

	public void setName(String name) {
		this.name = name;
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
		// SubReport reporter= new SubReport(this.getName());
		Reporter reporter = Reporter.getReporter();
		for (Testeable t : testeables) {
			setUp();
			try {
				if (isTestInPattern(t)) {
					t.addFixture(this.fixture);
					t.run();
					reporter.addResult(new ResultOk(t.getName()));
				}
			} catch (AssertFailedException e) {
				reporter.addResult(new ResultFail(t.getName()));
			} catch (Exception e) {
				reporter.addResult(new ResultError(t.getName()));
			}
			tearDown();
		}
		suiteTearDown();
		// Reporter.getReporter().addSubReport(reporter);
	}

	public void addFixture(Fixture fixture){
		this.fixture.addFixture(fixture);
	}
	
	private boolean isTestInPattern(Testeable t) {
		return true;
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

	protected void addTest(Testeable test) {
		String testName = test.getName();
		for (Testeable t : testeables) {
			if (t.getName().equals(testName)) {
				throw new TestAlreadyAddedException();
			}
		}
		testeables.add(test);
	}

}
