package ClientTP2;



public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		TP2.Tester t = 	new TP2.Tester();
		t.addTests(new MyTests());
		t.execute();
	}

}
