package bussines;

import java.util.ArrayList;
import java.util.List;

public class Estrategia_Ordenacion_Hoy implements Estrategia_Ordenacion_Actividades {
	
	@Override
	public List<Actividad> ordenar() {
		List<Actividad> lista = new ArrayList<Actividad>();
		lista.addAll(Unidad_Logica.getInstance().listaDePracticasDeHoy());
		lista.addAll(Unidad_Logica.getInstance().listaDeClasesDeHoy());
		lista.addAll(Unidad_Logica.getInstance().listaDeExamenesDeHoy());
		
		//operaciones de ordenacion por prioridad obteniendo TODAS las actividades de TODOS los tipos

		return lista;
	}

}
