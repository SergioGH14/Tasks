package bussines;

import java.util.Date;

public abstract class Examen extends Actividad{


	private boolean ultimo;
	private boolean recuperable;
	
	public Examen(Asignatura asignatura, String titulo, String descripcion, Date fechafinalizacion,
			         int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal,boolean finalizada, boolean recuperable, boolean ultimo) {
		
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, prioridadtotal, finalizada);
		this.setUltimo(ultimo);
		this.setRecuperable(recuperable);
		
		
	}

	public boolean isUltimo() {
		return ultimo;
	}

	public void setUltimo(boolean ultimo) {
		this.ultimo = ultimo;
	}

	public boolean isRecuperable() {
		return recuperable;
	}

	public void setRecuperable(boolean recuperable) {
		this.recuperable = recuperable;
	}
}
