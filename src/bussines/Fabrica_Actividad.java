package bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;

import persistence.dto.ActividadDTO;





public class Fabrica_Actividad {
	 public static Fabrica_Actividad instance;
	
	 public static Fabrica_Actividad getInstance() {
		  if(instance == null){
			  instance = new Fabrica_Actividad();
		  }return instance;
	  }
	private Fabrica_Actividad() {
		
	}
/*
 * TIPO 1 PRACTICA
 * TIPO 2 CLASE
 * TIPO 3 EXAMEN
 */
	public Actividad crearActividad(int tipo,
			ActividadDTO actividaddto,
			ArrayList<Boolean> especificaciones
			){
		switch(tipo){
			
		case 1:
			Actividad practica = crearPractica(
					actividaddto,
					especificaciones);
			return practica;
			
		case 2:
			Actividad clase = crearClase(
					actividaddto,
					especificaciones);
			return clase;
			
		case 3:
			Actividad examen_concreto = crearExamen(
					actividaddto,
					especificaciones);
			return examen_concreto;
			
		default: return null;
			
		
		}
		
	}
	
	private Actividad crearPractica(ActividadDTO actividaddto,ArrayList<Boolean> especificaciones){
		
		Practicas practica = new Practicas(Unidad_Logica.getInstance().informacionAsignatura(actividaddto.getId_asignatura()),
				actividaddto.getTitulo(), 
				actividaddto.getDescripcion(), 
				actividaddto.getFechaFinalizacion(), 
				actividaddto.getTiempoEstimado(), 
				actividaddto.getPorcentaje(), 
				actividaddto.getPrioridadTotal(), 
				actividaddto.isFinalizada(),
				especificaciones.get(0),
				especificaciones.get(1));
		return practica;
	}
	
	private Actividad crearClase(ActividadDTO actividaddto,ArrayList<Boolean> especificaciones){
		
		
		Clase clase = new Clase(Unidad_Logica.getInstance().informacionAsignatura(actividaddto.getId_asignatura()),
				actividaddto.getTitulo(), 
				actividaddto.getDescripcion(), 
				actividaddto.getFechaFinalizacion(), 
				actividaddto.getTiempoEstimado(), 
				actividaddto.getPorcentaje(), 
				actividaddto.getPrioridadTotal(), 
				actividaddto.isFinalizada(),
				
				especificaciones.get(0));
		return clase;
	}

	private Actividad crearExamen(ActividadDTO actividaddto,ArrayList<Boolean> especificaciones){
		
		
		Examen examen = new Examen(Unidad_Logica.getInstance().informacionAsignatura(actividaddto.getId_asignatura()),
				actividaddto.getTitulo(), 
				actividaddto.getDescripcion(), 
				actividaddto.getFechaFinalizacion(), 
				actividaddto.getTiempoEstimado(), 
				actividaddto.getPorcentaje(), 
				actividaddto.getPrioridadTotal(), 
				actividaddto.isFinalizada(),
				
				especificaciones.get(0),
				especificaciones.get(1));
		return examen;
	}
}
