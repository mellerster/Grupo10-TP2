package ClientTP2;

import TP2.Fixture;
import TP2.TestSuite;

public class MyProjectTests extends TestSuite {

	public MyProjectTests() {
		super("MyProjectTests");
	}

	protected void suiteSetUp() {
		System.out.println("suiteSetUp: -->" + getPackageName());
		System.out.flush();
		Fixture fixture = getFixture();
		Integer counter = new Integer(0);
		fixture.add("counter", counter);
		System.out.println("counter is 0");
	}

	protected void setUp() {
		System.out.println("setUp: --> " + getPackageName());
		System.out.flush();
	}

	protected void suiteTearDown() {
		System.out.println("counter is " + getFixture().get("counter"));
		System.out.println("suiteTearDown: -->" + getPackageName());
		System.out.flush();
	}

	@Override
	protected void init() {
		setName("MyProjectTests");
		MyTests tests = new MyTests();
		tests.setName("code");
		super.addTest(tests);
		tests = new MyTests();
		tests.setName("node");
		super.addTest(tests);
	}

}
