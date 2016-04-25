package bussines;

import java.util.Date;

public class Examen_Concreto extends Examen {

	public Examen_Concreto(Asignatura asignatura, String titulo, String descripcion, Date fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario,  boolean finalizada,
			boolean recuperable, boolean ultimo) {
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, finalizada, recuperable, ultimo);
		 setPrioridadtotal(establecerPrioridadTotal());
			
			
		}

		private int establecerPrioridadTotal(){
			int aux =getAsignatura().getDificultad()+getPrioridadusuario()+getTiempoestimado()+10;
		
			if(isUltimo())aux = aux+10;
			if(!isRecuperable())aux = aux+14;
			return aux;
		}

}
