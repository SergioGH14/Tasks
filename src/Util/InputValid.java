package Util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InputValid {

	public InputValid() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean estaRellenado(String texto){
		if(texto==null){System.out.println("isEmpty Soy nulo");return false;}
		if(texto.length()>0){
			System.out.println("isEmpty mido mas que 0");return true;
		}else
			System.out.println("isEmpty mido menos que 0");return false;
		
	}
	
	public static boolean esFechaFutura(LocalDate fecha){
		if(fecha==null)return false;
		
		if(fecha.isBefore(LocalDate.now()))return false;
		else return true;
		}
	
	public static boolean esFechaCumpleaños(LocalDate fecha){
		if(fecha==null)return false;
		if(esFechaFutura(fecha)==false)return true;
		return false;
		
	}

	public static boolean esNumerico(String texto){
		if(estaRellenado(texto)==false){System.out.println("isNumeric No estoy rellenado");return false;}
		try{
			Integer.parseInt(texto);
		}catch(Exception e){
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("isNumeric Soy un numero");return true;
	}
	
	public static boolean esAnyo(String texto){
		
		if(esNumerico(texto) && texto.length()==4 && (texto.startsWith("199")|| texto.startsWith("2"))) 
			System.out.println("isYear Cumplo todas Las primeras mierdas");
			if(LocalDateTime.now().getYear() >= (Date_solver.setDateinLocaleDateTime(texto).getYear())){ 
				System.out.println("isYear Lo soy");return true;}
			
			
		System.out.println("isYear No lo soy");return false;	
	}
	
	
}
