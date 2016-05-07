package bussines;

import java.time.LocalDateTime;

public class Clase extends Actividad{

	private int id_clase;
	private boolean puntuable;
	
	public Clase(Asignatura asignatura, String titulo, String descripcion,  LocalDateTime fechafinalizacion,
			         int tiempoestimado, double porcentaje, int prioridadusuario,boolean finalizada, boolean puntuable) {
		super(asignatura, titulo, descripcion, fechafinalizacion,
				tiempoestimado, porcentaje, 
				prioridadusuario, finalizada);
		
		this.setPuntuable(puntuable);
		setPrioridadtotal(establecerPrioridadTotal());
		
		
	}

	private int establecerPrioridadTotal(){
		int aux =getAsignatura().getDificultad()+getPrioridadusuario()+getTiempoestimado();
	
		if(isPuntuable())aux = aux+10;
		return aux;
	}
	
	public boolean isPuntuable() {
		return puntuable;
	}

	public void setPuntuable(boolean puntuable) {
		this.puntuable = puntuable;
	}
	
}
