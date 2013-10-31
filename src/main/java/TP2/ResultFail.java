package TP2;
/*
	Clase ResultFail
	Esta clase se utiliza para separar los casos de resultados exitosos de los fallidos, en este caso es el fallido y lo que hace
	es heredar de Result y cuando se crea le dice que es un resultado fallido y a la descripcion se le agrega el texto para que cuando se grabe el reporte se vea eso.
*/
public class ResultFail extends Result {

	public ResultFail(String description) {
		super(false, "[Fail] --> " + description);
	}

}
