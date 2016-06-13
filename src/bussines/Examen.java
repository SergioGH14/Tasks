package bussines;

import java.time.LocalDateTime;

public class Examen extends Actividad_Examen {
	
	private boolean ultimo;
	private boolean recuperable;
	
	public Examen(Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario,  boolean finalizada, boolean para_despues,
			boolean recuperable, boolean ultimo) {
		
		 super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, finalizada, para_despues);
		 
		 this.ultimo = ultimo;
		 this.recuperable = recuperable;
		 setPrioridadTotal(this.establecerPrioridadTotal());
			
    }
	
	public Examen(Integer id_examen, int id_actividad, Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal ,boolean finalizada, boolean para_despues,
			boolean recuperable, boolean ultimo) {
		
		 super(id_examen,id_actividad,asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario,prioridadtotal, finalizada,para_despues);
		 this.ultimo = ultimo;
		 this.recuperable = recuperable;
	
    }

	private int establecerPrioridadTotal(){
		int aux =getAsignatura().getDificultad()+getPrioridadUsuario()+getTiempoEstimado()+10;
		if(ultimo)aux = aux+10;
		if(!isRecuperable())aux = aux+14;
		return aux;
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

	@Override
	public String toString() {
		return "Examen [ultimo=" + ultimo + ", recuperable=" + recuperable + "]";
	}
		
		
}
