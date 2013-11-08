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

	public ResultError(String description) {
		super(ResultType.Error, "[Error] " + description);
	}

	public ResultError(String description, String packageName) {
		super(ResultType.Error, "[Error] " + description, packageName);
	}

	public ResultError(String description, String packageName, double time) {
		super(ResultType.Error, "[Error] " + description, packageName, time);
	}
}
