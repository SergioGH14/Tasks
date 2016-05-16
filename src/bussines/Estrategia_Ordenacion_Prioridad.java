package bussines;

import java.util.ArrayList;
import java.util.List;

public class Estrategia_Ordenacion_Prioridad implements Estrategia_Ordenacion_Actividades{
	private List<Actividad> listaActividades;
	
	public Estrategia_Ordenacion_Prioridad(Asignatura asignatura) {
		this.listaActividades = new ArrayList<Actividad>();
		for(Integer id_actividad : asignatura.getListaActividades().keySet()){
			this.listaActividades.add(asignatura.obtenerActividad(id_actividad));
		}

	}

	@Override
	public List<Actividad> ordenar() {
		// if(listaActividades!=null && !listaActividades.isEmpty()){ //operaciones para ordenar por prioridad }
		return listaActividades;
	}

}
