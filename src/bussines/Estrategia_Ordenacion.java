package bussines;

import java.util.List;

//Esta clase es similar a la clase sistemaLineal/shoppingCart de los ejemplos de los pdf
//Esta clase es una clase intermiediaria entre los sistemas de ordenacion, como si fuese un DAL del estrategia.
public class Estrategia_Ordenacion {
		
	public List<Actividad> ordenar(Estrategia_Ordenacion_Actividades estrategiaOrdenacion){
		return estrategiaOrdenacion.ordenar();
	}

}
