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
		String res = "";
		
		if(actividad instanceof Practicas)
			return PRACTICAS;
		
		if(actividad instanceof Clase)
			return CLASE;
		
		try{
			
			Actividad_Examen actividadAuxiliar = (Actividad_Examen)actividad;
			if(actividadAuxiliar instanceof Examen)
				res = EXAMEN;
			
			if(actividadAuxiliar instanceof Examen_Poliformat){
				res = EXAMEN_POLIFORMAT;
				if( ((Examen_Poliformat) actividadAuxiliar).getExamen() instanceof Examen_Practicas ){
					res +=" y " + EXAMEN_PRACTICAS.toLowerCase();;
				}
				if( ((Examen_Poliformat) actividadAuxiliar).getExamen() instanceof Examen_Clase ){
					res +=" y " + EXAMEN_CLASE.toLowerCase();
				}
			}
			
			if( actividadAuxiliar instanceof Examen_Clase){
				res =  EXAMEN_CLASE;
				if( ((Examen_Clase) actividadAuxiliar).getExamen() instanceof Examen_Poliformat ){
					res +=" y " + EXAMEN_POLIFORMAT.toLowerCase();;
				}
			}
			
			if( actividadAuxiliar instanceof Examen_Practicas){
				res = EXAMEN_PRACTICAS;
				if( ((Examen_Practicas) actividadAuxiliar).getExamen() instanceof Examen_Poliformat ){
					res +=" y " + EXAMEN_POLIFORMAT.toLowerCase();;
				}
			}
		
		}catch(Exception e){
			System.err.println("Error al castear" + e.getLocalizedMessage());
		}
		
		return res;
		
	}

}
