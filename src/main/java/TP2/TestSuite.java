package TP2;

import java.util.LinkedList;
import java.util.List;

/** TestSuite
 * Es lo que implementa el cliente para ejecutar una serie de tests. 
 * Debe hacer que sus tests sean ejecutados dentro del metodo init().
 **/

public abstract class TestSuite implements Testeable {
	
	private String name;
	//private List<Testeable> testeables;
	private List<TestSuite> testSuites;
	private List<Test> tests;
	private String pattern;
	private Fixture fixture;
	private String packageName;
	
	public TestSuite() {
		setName("");
		pattern = "";
		tests = new LinkedList<Test>();
		testSuites = new LinkedList<TestSuite>();
		fixture = new Fixture();
		packageName = "";
	}
	
	public TestSuite(String name) {
		setName(name);
		pattern = "";
		testSuites = new LinkedList<TestSuite>();
		tests = new LinkedList<Test>();
		fixture = new Fixture();
		packageName = "";
	}

	public void setName(String name) {
		this.name = name;
		if(getPackageName() == ""){
			setPackageName(name);;
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
			t.run();
		}
		for (Test t : tests) {
			setUp();
			try {
				if (isTestInPattern(t)) {
					t.run();
					reporter.addResult(new ResultOk(t.getName(),getPackageName()));
				}
			} catch (AssertFailedException e) {
				reporter.addResult(new ResultFail(t.getName(),getPackageName()));
			} catch (Exception e) {
				reporter.addResult(new ResultError(t.getName(),getPackageName()));
			}
			tearDown();
		}
		suiteTearDown();
	}

	public void addFixture(Fixture fixture){
		this.fixture.addFixture(fixture);
	}
	
	public Fixture getFixture(){
		return this.fixture;
	}
	private boolean isTestInPattern(Testeable t) {
		return true; // TODO 
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
	
	private void checkNameInList(String name, List<?> list){
		for (Object t : list) {
			if (t.toString().equals(name)) {
				throw new TestAlreadyAddedException();
			}
		}
	}
	
	protected void addTest(TestSuite testSuite){
		checkNameInList(testSuite.getName(), testSuites);
		testSuite.setPackageName(packageName);
		testSuites.add(testSuite);
	}
	
	protected void addTest(Test test) {
		checkNameInList(test.getName(), tests);
		tests.add(test);
	}
	
	public void setPackageName(String packageName){
		String dot = "";
		if(this.packageName != ""){
			dot = ".";
		}
		this.packageName = packageName + dot + this.packageName; 
	}
	public String getPackageName(){
		return packageName;
	}
}
