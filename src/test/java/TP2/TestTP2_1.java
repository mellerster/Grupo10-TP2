package TP2;

import org.junit.Test;

//import static org.junit.Assert.assertEquals;

public class TestTP2_1 {

	@Test(expected = TestAlreadyAddedException.class)
	public void UnicityTestCase() {
		TestSuite testeable = new TestSuite() {

			@Override
			protected void init() {
				setName("B");
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
		TestSuite testeable = new TestSuite() {

			@Override
			protected void init() {
				setName("B");
			}
		};
		Testeable test = new TP2.TestSuite() {
			@Override
			protected void init(){
				setName("A");
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
	

}