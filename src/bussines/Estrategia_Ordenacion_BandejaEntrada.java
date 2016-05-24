package bussines;

import java.util.ArrayList;
import java.util.List;


public class Estrategia_Ordenacion_BandejaEntrada implements Estrategia_Ordenacion_Actividades{

	@Override
	public List<Actividad> ordenar() {
	    List<Actividad> lista = new ArrayList<Actividad>();
		lista.addAll(Unidad_Logica.getInstance().listaDeTodasLasPracticas());
		lista.addAll(Unidad_Logica.getInstance().listaDeTodasLasClases());
		lista.addAll(Unidad_Logica.getInstance().listaDeTodosExamenes());
		
		//operaciones de ordenacion para esta lista de la bandeja de entrada, por definir.
		return lista;
	}

}
