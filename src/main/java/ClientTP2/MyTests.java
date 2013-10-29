package ClientTP2;

import TP2.Assert;
import TP2.Testeable;

public class MyTests extends Testeable {

	public MyTests() {

	}

	public void test1() {
		System.out.println("test1");
		Assert.isTrue(true);
	}
	
	public void test2() {
		System.out.println("test2");
		Assert.isTrue(false);
	}
	
	 public void init(){
		 System.out.println("init");
		super.addTest(new TP2.Test(){
			public void run(){
				test1();
			}
		});
		super.addTest(new TP2.Test(){
			public void run(){
				test2();
			}
		});
	}
	
}
