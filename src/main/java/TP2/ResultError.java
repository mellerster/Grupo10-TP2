package TP2;

/**
 * ResultError Esta clase se utiliza para separar los casos de resultados
 * exitosos de los fallidos y con errores. En este caso es con errores y lo que
 * hace es heredar de Result y cuando se crea le dice que es un resultado con
 * errores y a la descripcion se le agrega el texto para que cuando se grabe el
 * reporte se vea eso. Herencia: Esta clase hereda de Result ya que simplifica
 * para separar las pruebas exitosas de las fallidas y con errores, y hacer los
 * reportes de una manera mas sencilla.
 **/

public class ResultError extends Result {

	public ResultError(String testName) {
		super(ResultType.Error, "[Error] " + testName);
	}

	public ResultError(String testName, String packageName) {
		super(ResultType.Error, "[Error] " + testName, packageName);
	}

	public ResultError(String testName, String packageName, double time) {
		super(ResultType.Error, "[Error] " + testName, packageName, time);
	}

	public ResultError(String testName, String packageName, double time,
			String description) {
		super(ResultType.Error, "[Error] " + testName, packageName, time,
				description);
	}
}
