package ClientTP2;


public class Main {

	public static void main(String[] args) {
		TP2.Tester tester = new TP2.Tester(TP2.ReportMode.AllAvailable);

		tester.addTests(new MyProjectTests());

		tester.execute();
	}

}
