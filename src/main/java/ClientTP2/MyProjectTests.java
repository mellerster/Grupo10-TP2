package ClientTP2;

import TP2.TestSuite;

public class MyProjectTests extends TestSuite {

	public MyProjectTests() {
		super("MyProjectTests");
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
