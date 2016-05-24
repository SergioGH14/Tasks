package bussines;

import java.util.ArrayList;
import java.util.List;


public class Estrategia_Ordenacion_ParaDespues implements Estrategia_Ordenacion_Actividades{

	@Override
	public List<Actividad> ordenar() {
		List<Actividad> lista = new ArrayList<Actividad>();
		lista.addAll(Unidad_Logica.getInstance().listaDePracticasParaDespues());
		lista.addAll(Unidad_Logica.getInstance().listaDeClasesParaDespues());
		lista.addAll(Unidad_Logica.getInstance().listaDeExamenesParaDespues());
		
		//operaciones de ordenacion para esta lista de "para despues"
		return lista;
	}

}
