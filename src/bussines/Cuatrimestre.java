package bussines;

import java.util.Map;

public class Cuatrimestre {

	private int cuatrimestre;
	private Map<Integer, Asignatura> listaasignaturas;
	
	
	public Cuatrimestre(int cuatrimestre) {
		super();
		this.cuatrimestre = cuatrimestre;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	
}
