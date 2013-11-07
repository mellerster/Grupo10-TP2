package TP2;

/** ResultFail
 * Esta clase se utiliza para separar los casos de resultados exitosos de los fallidos y con
 * errores. En este caso es el fallido y lo que hace es heredar de Result y cuando se crea le
 * dice que es un resultado fallido y a la descripcion se le agrega el texto para que cuando
 * se grabe el reporte se vea eso.
 * Herencia: Esta clase hereda de Result ya que simplifica para separar las pruebas 
 * exitosas de las fallidas y con errores, y hacer los reportes de una manera mas sencilla.
 **/

public class ResultFail extends Result {

	public ResultFail(String description) {
		super(ResultType.Fail, "[Fail] " + description);
	}
	
	public ResultFail(String description, String packageName){
		super(ResultType.Fail,"[Fail] " + description, packageName);
	}
}
