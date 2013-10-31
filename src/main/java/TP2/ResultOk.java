package TP2;

/*
	Clase ResultOk
	Esta clase se utiliza para separar los casos de resultados exitosos de los fallidos, en este caso es el exitoso y lo que hace
	es heredar de Result y cuando se crea le dice que es un resultado exitoso y a la descripcion se le agrega el texto para que cuando se grabe el reporte se vea eso.
*/
public class ResultOk extends Result {

	public ResultOk(String description) {
		super(true, "[Ok] --> " + description);
	}

}
