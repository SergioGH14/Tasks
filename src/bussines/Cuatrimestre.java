package bussines;

import java.util.Map;

public class Cuatrimestre {

	private Map<Integer, Asignatura> listaasignaturas;
	
	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	private int cuatrimestre;
	
}
