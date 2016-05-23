package Util;

import bussines.*;

public class Tipos {
	public static final String PRACTICAS = "Prácticas";
	public static final String CLASE = "Clase";
	public static final String EXAMEN = "Examen";
	public static final String EXAMEN_POLIFORMAT = "Examen de Poliformat";
	public static final String EXAMEN_CLASE = "Examen de Clase";
	public static final String EXAMEN_PRACTICAS = "Examen de Prácticas";
	
	public static String obtainString(Actividad actividad){		
		if(actividad instanceof Practicas)
			return PRACTICAS;
		
		if(actividad instanceof Clase)
			return CLASE;
		
		try{
			if((Examen)actividad instanceof Examen)
				return EXAMEN;
			
			if( (Examen_Poliformat)actividad instanceof Examen_Poliformat)
				return EXAMEN_POLIFORMAT;
			
			if( (Examen_Clase)actividad instanceof Examen_Clase)
				return EXAMEN_CLASE;
			
			if( (Examen_Practicas)actividad instanceof Examen_Practicas)
				return EXAMEN_PRACTICAS;
		
		}catch(Exception e){
			System.err.println("Error al castear" + e.getLocalizedMessage());
		}
		
		return null;
		
	}

}
