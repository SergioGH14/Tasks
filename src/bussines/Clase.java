package bussines;

import java.time.LocalDateTime;

public class Clase extends Actividad{

	private int id_clase;
	private boolean puntuable;
	
	public Clase(int id_clase, int id_actividad, Asignatura asignatura, String titulo, String descripcion,  LocalDateTime fechafinalizacion,
	         int tiempoestimado, double porcentaje, int prioridadusuario, int prioridadtotal, boolean finalizada, boolean para_despues, boolean puntuable) {
	super(id_actividad, asignatura, titulo, descripcion, fechafinalizacion,
			tiempoestimado, porcentaje, 
			prioridadusuario, prioridadtotal,finalizada, para_despues);
	
	this.setPuntuable(puntuable);
	}
	
	public Clase(Asignatura asignatura, String titulo, String descripcion,  LocalDateTime fechafinalizacion,
			         int tiempoestimado, double porcentaje, int prioridadusuario,boolean finalizada, boolean para_despues, boolean puntuable) {
		super(asignatura, titulo, descripcion, fechafinalizacion,
				tiempoestimado, porcentaje, 
				prioridadusuario, finalizada, para_despues);
		
		this.setPuntuable(puntuable);
		setPrioridadTotal(establecerPrioridadTotal());
		
	}

	private int establecerPrioridadTotal(){
		int aux = 0;
		if(getAsignatura()!=null){
		 aux =getAsignatura().getDificultad()
				+getPrioridadusuario()
				+getTiempoestimado();
	
		if(isPuntuable())aux = aux+10;
		}
		System.err.println("Puntuable" + isPuntuable());
		return aux;
	}
	
	public boolean isPuntuable() {
		return puntuable;
	}

	public void setPuntuable(boolean puntuable) {
		this.puntuable = puntuable;
	}

	public int getId_clase() {
		return id_clase;
	}

	public void setId_clase(int id_clase) {
		this.id_clase = id_clase;
	}

	@Override
	public String toString() {
		return getTitulo() + "\nDescripcion: " + getDescripcion();
	}
	
	
	
}
