package bussines;

import java.util.Date;

public class Practicas extends Actividad {

	private boolean grupal;
	private boolean recuperable;
	
	public Practicas(Asignatura asignatura, String titulo, String descripcion, Date fechafinalizacion,
			         int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal, boolean grupal, boolean recuperable,boolean finalizada) {
		
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, prioridadtotal, finalizada);
		this.grupal = grupal;
		this.recuperable = recuperable;
		
		
	}

	public boolean isGrupal() {
		return grupal;
	}

	public void setGrupal(boolean grupal) {
		this.grupal = grupal;
	}

	public boolean isRecuperable() {
		return recuperable;
	}

	public void setRecuperable(boolean recuperable) {
		this.recuperable = recuperable;
	}

}
