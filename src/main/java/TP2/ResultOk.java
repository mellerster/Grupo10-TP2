package TP2;

/** ResultOk
 * Esta clase se utiliza para separar los casos de resultados exitosos de los fallidos y con
 * errores. En este caso es el exitoso y lo que hace es heredar de Result y cuando se crea le
 * dice que es un resultado exitoso y a la descripcion se le agrega el texto para que cuando
 * se grabe el reporte se vea eso.
 * Herencia: Esta clase hereda de Result ya que simplifica para separar las pruebas 
 * exitosas de las fallidas y con errores, y hacer los reportes de una manera mas sencilla.
 **/

public class ResultOk extends Result {

	public ResultOk(String description) {
		super(ResultType.Ok, "[Ok] " + description);
	}
	
	public ResultOk(String description, String packageName){
		super(ResultType.Ok,"[Ok] " + description, packageName);
	}

}
