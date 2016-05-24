package bussines;

import java.util.ArrayList;
import java.util.List;

public class Estrategia_Ordenacion_Prioridad implements Estrategia_Ordenacion_Actividades{
	private List<Actividad> listaActividades;
	
	public Estrategia_Ordenacion_Prioridad(Asignatura asignatura) {
		this.listaActividades = new ArrayList<Actividad>();
		this.listaActividades.addAll(Unidad_Logica.getInstance().listaDePracticasDeAsignatura(asignatura));
		this.listaActividades.addAll(Unidad_Logica.getInstance().listaDeExamenesDeAsignatura(asignatura));
	}

	@Override
	public List<Actividad> ordenar() {
		// if(listaActividades!=null && !listaActividades.isEmpty()){ //operaciones para ordenar por prioridad }
		return listaActividades;
	}

}
