package ClientTP2;

import TP2.Tester;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		System.out.println("hola");
		Tester t = 	new Tester();
		t.addTests(new MyTests());
		t.execute();
	}

}
