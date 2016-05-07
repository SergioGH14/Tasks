package bussines;

import java.time.LocalDateTime;

public class Practicas extends Actividad {

	private boolean grupal;
	private boolean recuperable;
	
	public Practicas(Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			         int tiempoestimado, Double porcentaje, int prioridadusuario,boolean finalizada, boolean grupal, boolean recuperable) {
		
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, finalizada);
		this.grupal = grupal;
		this.recuperable = recuperable;
		 setPrioridadtotal(establecerPrioridadTotal());
			
			
		}

		private int establecerPrioridadTotal(){
			int aux =getAsignatura().getDificultad()+getPrioridadusuario()+getTiempoestimado()+5;
		
			if(isGrupal())aux = aux+10;
			if(!isRecuperable())aux = aux+14;
			return aux;
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
