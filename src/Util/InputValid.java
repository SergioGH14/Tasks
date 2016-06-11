package Util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InputValid {

	public InputValid() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean estaRellenado(String texto){
		if(texto==null){
			return false;}
		if(texto.length()>0){
		return true;
		}else
		return false;
		
	}
	
	public static boolean esFechaFutura(LocalDate fecha){
		if(fecha==null)return false;
		if(fecha.isBefore(LocalDate.now()))return false;
		else return true;
		}
	
	public static boolean esFechaCumpleanyos(LocalDate fecha){
		if(fecha==null)return false;
		if(esFechaFutura(fecha)==false)return true;
		return false;
		
	}

	public static boolean esNumerico(String texto){
		if(estaRellenado(texto)==false){
			return false;}
		try{
			Integer.parseInt(texto);
		}catch(Exception e){
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean esAnyo(String texto){
		
		if(esNumerico(texto) && texto.length()==4 && (texto.startsWith("199")|| texto.startsWith("2"))) 
			if(LocalDateTime.now().getYear() >= (Date_solver.setDateinLocaleDateTime(texto).getYear())){ 
				return true;}
		return false;	
	}
	
	
}
