package ClientTP2;

import TP2.Assert;
import TP2.Test;
import TP2.Testeable;

public class MyTests extends Testeable {

	public MyTests() {
	}

	public void test1() {
		Assert.isTrue(true,"Test 1");
	}
	
	public void test2() {
		Assert.isTrue(false, "Test 2");
	}
	
	public void test3(){
		Assert.AreEquals(1, 1,"Test 3");
	}
	
	public void test4(){
		Assert.AreEquals(1, 2, "Test 4");
	}
	
	 public void init(){
		super.addTest(new Test(){
			public void run(){
				test1();
			}
		});
		super.addTest(new Test(){
			public void run(){
				test2();
			}
		});
		super.addTest(new Test(){
			public void run(){
				test3();
			}
		});
		super.addTest(new Test(){
			public void run(){
				test4();
			}
		});
	}
	
}
