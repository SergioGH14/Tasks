package bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;





public class Fabrica_Actividad {
	 public static Fabrica_Actividad instance;
	/*
	 * CrearActividad devuelve una Actividad que ser� Practica o Clase o Examen dependiendo del entero tipo
	 * 1 practica  
	 * 2 clase
	 * 3 examen
	 * NOTA IMPORTANTE
	 * SIEMPRE SE TIENEN QUE PASAR DOS BOOLEANOS DE ESPECIALIZACION DE CLASE AUNQUE CLASE SOLO TENGA UNO
	 * PASADLO EN ESE CASO COMO UN NULL O COMO OS DE LA GANA POR QUE NO SE TIENE DESPUES EN CUENTA
	 * :)
	 * */
	
	 public static Fabrica_Actividad dameFabrica_Actividad() {
		  if(instance == null){
			  instance = new Fabrica_Actividad();
		  }return instance;
	  }
	private Fabrica_Actividad() {
		
	}

	public Actividad crearActividad(int tipo,
			Asignatura asignatura,
			String titulo, 
			String descripcion, 
			LocalDateTime fechafinalizacion, 
			int tiempoestimado, 
			double porcentaje, 
			int prioridadusuario, 
			boolean finalizada,
			ArrayList<Boolean> especificaciones
			//boolean primero,
			//boolean segundo
			){
		switch(tipo){
			
		case 1:
			Actividad practica = crearPractica(
					asignatura,
					titulo, 
					descripcion, 
					fechafinalizacion, 
					tiempoestimado, 
					porcentaje, 
					prioridadusuario, 
					finalizada,
					especificaciones);
			return practica;
			
		case 2:
			Actividad clase = crearClase(
					asignatura,
					titulo, 
					descripcion, 
					fechafinalizacion, 
					tiempoestimado, 
					porcentaje, 
					prioridadusuario, 
					finalizada,
					especificaciones);
			return clase;
			
		case 3:
			Actividad examen_concreto = crearExamen(
					asignatura,
					titulo, 
					descripcion, 
					fechafinalizacion, 
					tiempoestimado, 
					porcentaje, 
					prioridadusuario, 
					finalizada,
					especificaciones);
			return examen_concreto;
			
		default: return null;
			
		
		}
		
	}
	
	private Actividad crearPractica(Asignatura asignatura,String titulo, String descripcion,LocalDateTime fechafinalizacion, int tiempoestimado, 
			double porcentaje, int prioridadusuario,  boolean finalizada,ArrayList<Boolean> especificaciones){
		
		Practicas practica = new Practicas(asignatura,
				titulo, 
				descripcion, 
				fechafinalizacion, 
				tiempoestimado, 
				porcentaje, 
				prioridadusuario, 
				
				finalizada,
				especificaciones.get(0),
				especificaciones.get(1));
		return practica;
	}
	
	private Actividad crearClase(Asignatura asignatura,String titulo, String descripcion,LocalDateTime fechafinalizacion, int tiempoestimado, 
			double porcentaje, int prioridadusuario, boolean finalizada ,ArrayList<Boolean> especificaciones){
		
		
		Clase clase = new Clase(asignatura,
				titulo, 
				descripcion, 
				fechafinalizacion, 
				tiempoestimado, 
				porcentaje, 
				prioridadusuario, 
				
				finalizada,
				especificaciones.get(0));
		return clase;
	}

	private Actividad crearExamen(Asignatura asignatura,String titulo, String descripcion,LocalDateTime fechafinalizacion, int tiempoestimado, 
			double porcentaje, int prioridadusuario,   boolean finalizada,ArrayList<Boolean> especificaciones){
		
		
		Examen examen = new Examen(asignatura,
				titulo, 
				descripcion, 
				fechafinalizacion, 
				tiempoestimado, 
				porcentaje, 
				prioridadusuario, 
				
				finalizada,
				especificaciones.get(0),
				especificaciones.get(1));
		return examen;
	}
}
