package bussines;

import java.util.Date;

public class Clase extends Actividad{


	private boolean puntuable;
	
	public Clase(Asignatura asignatura, String titulo, String descripcion, Date fechafinalizacion,
			         int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal,boolean finalizada, boolean puntuable) {
		
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, prioridadtotal, finalizada);
		this.setPuntuable(puntuable);
		
		
	}

	public boolean isPuntuable() {
		return puntuable;
	}

	public void setPuntuable(boolean puntuable) {
		this.puntuable = puntuable;
	}
	
}
