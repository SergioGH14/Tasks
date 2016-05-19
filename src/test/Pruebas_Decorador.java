package test;

import java.time.LocalDateTime;
import java.util.Scanner;

import bussines.*;
import persistence.DAL;

public class Pruebas_Decorador {
	private static Scanner teclado;

	public static void main(String[] args) {
		teclado = new Scanner(System.in);	
		LocalDateTime l = LocalDateTime.now();
		
		System.out.println("Vamos a crear la actividad de examen: ");
		Asignatura asignatura = DAL.getInstance().obtenerInformacionAsignatura("DSM");
		System.out.println("Asignatura: " + asignatura);
		
		Actividad examen = new Examen(asignatura, "Examen de DSM para decorar de poliformat y de practicas a la vez ", "Descripcion de examen de dsm", l, 0, 22.0, 10, false, true, false);
		System.err.println("Examen : "  + examen.getPrioridadtotal());
		
		Examen examen2 = (Examen) examen;

		/*if(examen instanceof Actividad_Examen){
			
			Actividad_Examen examen_pr= new Examen_Practicas(examen2);
			
			System.err.println("Examen decorado el mismo con solo poliformat: " + new Examen_Poliformat(examen2).getPrioridadtotal());
			
			System.err.println("Examen decorado con solo Practicas: " +examen_pr.getPrioridadtotal() );
			
			System.err.println("Examen decorado tambien con Poliformat - Practicas: " + new Examen_Poliformat(examen_pr).getPrioridadtotal());
			
			System.out.println("Voy a descastear el examen... " );
			Actividad examenasdasd = (Actividad)examen_pr;
			if(examenasdasd instanceof Examen_Practicas){
				System.out.println("Ha sido todo un exito, mis dieses");
			}
		}*/
		
	
		
		System.out.println("##### VAMOS A PERSISTENCIA ####### " );
		//System.out.println("Vamos a escribir el examen sin decorar en bbdd");
		//examen2 = DAL.getInstance().crearExamen(examen2);
		//System.err.println("Examen creado en persistencia: " + examen2);
		
		
		System.out.println("##### VAMOS A PERSISTENCIA ####### " );

		System.out.println("\nVamos a decorar el examen en examen_clase ");
		//Examen_Practicas examen_practiacs_poli= new Examen_Practicas(examen2);
		Examen_Clase examen_clase= new Examen_Clase(examen2);

		System.out.println("\nVamos a decorar el examen en examen_poliformat-clase ");
		Examen_Poliformat examen_pol= new Examen_Poliformat(examen_clase);
		
		examen_pol = DAL.getInstance().crearExamenPoliformat(examen_pol);
		

		System.err.println("Examen creado en persistencia: " + examen_pol);


		

	}
	
}
