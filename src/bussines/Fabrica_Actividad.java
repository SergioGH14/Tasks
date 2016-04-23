package bussines;

import java.util.Date;

public class Fabrica_Actividad {
	
	/*
	 * CrearActividad devuelve una Actividad que será Practica o Clase o Examen dependiendo del entero tipo
	 * 1 practica  
	 * 2 clase
	 * 3 examen
	 * NOTA IMPORTANTE
	 * SIEMPRE SE TIENEN QUE PASAR DOS BOOLEANOS DE ESPECIALIZACION DE CLASE AUNQUE CLASE SOLO TENGA UNO
	 * PASADLO EN ESE CASO COMO UN NULL O COMO OS DE LA GANA POR QUE NO SE TIENE DESPUES EN CUENTA
	 * :)
	 * */
	
	
	public Fabrica_Actividad() {
		
	}

	public Actividad crearActividad(int tipo,
			Asignatura asignatura,
			String titulo, 
			String descripcion, 
			Date fechafinalizacion, 
			int tiempoestimado, 
			double porcentaje, 
			int prioridadusuario, 
			int prioridadtotal,
			boolean finalizada,
			boolean primero,
			boolean segundo){
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
					prioridadtotal,
					finalizada,
					primero,
					segundo);
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
					prioridadtotal,
					finalizada,
					primero);
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
					prioridadtotal,
					finalizada,
					primero,
					segundo);
			return examen_concreto;
			
		default: return null;
			
		
		}
		
	}
	
	private Actividad crearPractica(Asignatura asignatura,String titulo, String descripcion,Date fechafinalizacion, int tiempoestimado, 
			double porcentaje, int prioridadusuario, int prioridadtotal, boolean finalizada, boolean primero, boolean segundo){
		
		prioridadtotal= asignatura.getDificultad()+prioridadusuario+tiempoestimado+5;
		
		if(primero)prioridadtotal= prioridadtotal-5;
		if(!segundo)prioridadtotal=prioridadtotal+14;
		
		Practicas practica = new Practicas(asignatura,
				titulo, 
				descripcion, 
				fechafinalizacion, 
				tiempoestimado, 
				porcentaje, 
				prioridadusuario, 
				prioridadtotal,
				finalizada,
				primero,
				segundo);
		return practica;
	}
	
	private Actividad crearClase(Asignatura asignatura,String titulo, String descripcion,Date fechafinalizacion, int tiempoestimado, 
			double porcentaje, int prioridadusuario, int prioridadtotal, boolean finalizada, boolean primero ){
		
		prioridadtotal= asignatura.getDificultad()+prioridadusuario+tiempoestimado;
		
		if(primero)prioridadtotal= prioridadtotal+10;
		
		Clase clase = new Clase(asignatura,
				titulo, 
				descripcion, 
				fechafinalizacion, 
				tiempoestimado, 
				porcentaje, 
				prioridadusuario, 
				prioridadtotal,
				finalizada,
				primero);
		return clase;
	}

	private Actividad crearExamen(Asignatura asignatura,String titulo, String descripcion,Date fechafinalizacion, int tiempoestimado, 
			double porcentaje, int prioridadusuario, int prioridadtotal, boolean finalizada, boolean primero, boolean segundo){
		
		prioridadtotal= asignatura.getDificultad()+prioridadusuario+tiempoestimado+10;
		
		if(primero)prioridadtotal= prioridadtotal+10;
		if(!segundo)prioridadtotal=prioridadtotal+14;
		
		Examen_Concreto examen = new Examen_Concreto(asignatura,
				titulo, 
				descripcion, 
				fechafinalizacion, 
				tiempoestimado, 
				porcentaje, 
				prioridadusuario, 
				prioridadtotal,
				finalizada,
				primero,
				segundo);
		return examen;
	}
}
