package TP2;

import org.junit.Test;

public class TestTP2_1 {

	@Test(expected = TestAlreadyAddedException.class)
	public void UnicityTestCase() {
		TestSuite testeable = new TestSuite("B") {
			@Override
			protected void init() {
			}
		};
		testeable.addTest(new TP2.Test("A") {
			public void run() {
			}
		});
		testeable.addTest(new TP2.Test("A") {
			public void run() {
			}
		});
	}
	
	@Test(expected = TestAlreadyAddedException.class)
	public void UnicityTestSuite() {
		TestSuite testeable = new TestSuite("B") {
			@Override
			protected void init() {
			}
		};
		TestSuite test = new TestSuite("A") {
			@Override
			protected void init(){
			}
		};
		testeable.addTest(test);
		testeable.addTest(test);
	}
	
	@Test
	public void TestSetUp(){
		/*TestSuite testeable = new TestSuite(){
			@Override
			protected void init(){
				setName("A");
			}
			@Override
			protected void setUp(){
				number = 5;
			}
		};
		testeable.run();*/
	}
	
	@Test(expected = AssertFailedException.class)
	public void TestFailure(){
		new TP2.Test("TestFailure") {
			public void run() {
			}
		};
		Assert.isTrue(false, "TestFailure");
	}
	/*	
	@Test(expected = Exception.class)
	public void TestError(){
		new TP2.Test("TestError") {
			public void run() {
			}
		};
		Assert.isTrue(false, "TestError");
	}
	*/
	
}