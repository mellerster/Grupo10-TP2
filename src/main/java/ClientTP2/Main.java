package ClientTP2;

import TP2.Tester;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		Tester t = 	new Tester();
		t.addTests(new myTests());
		t.execute();
	}

}
