package test;

import java.time.LocalDateTime;
import java.util.Scanner;

import bussines.*;
import persistence.DAL;
import persistence.ExamenClaseDAOImp;
import persistence.ExamenPoliformatDAOImp;
import persistence.ExamenPracticasDAOImp;

public class Pruebas_Decorador {
	private static Scanner teclado;

	public static void main(String[] args) {
		teclado = new Scanner(System.in);	
		LocalDateTime l = LocalDateTime.now();
		
		System.out.println("Vamos a crear la actividad de examen: ");
		Asignatura asignatura = DAL.getInstance().obtenerInformacionAsignatura("ETC");
		System.out.println("Asignatura: " + asignatura);
		
		Actividad examen = new Examen(asignatura, " Examen SOLO CLASE de ETC para decorar de poliformat y de practicas a la vez ", "Descripcion de examen de dsm", l, 0, 22.0, 10, false, true, false, false);
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
		
	
		
		/*System.out.println("##### VAMOS A PERSISTENCIA ####### " );
		//System.out.println("Vamos a escribir el examen sin decorar en bbdd");
		//examen2 = DAL.getInstance().crearExamen(examen2);
		//System.err.println("Examen creado en persistencia: " + examen2);
		
		

		System.out.println("\nVamos a decorar el examen en examen_clase ");
		//Examen_Practicas examen_practiacs_poli= new Examen_Practicas(examen2);
		Examen_Practicas examen_clase= new Examen_Practicas(examen2);

		System.out.println("\nVamos a decorar el examen en examen_poliformat-clase ");
		Examen_Poliformat examen_pol= new Examen_Poliformat(examen_clase);
		
		examen_pol = DAL.getInstance().crearExamenPoliformat(examen_pol);
		

		System.err.println("Examen creado en persistencia: " + examen_pol);*/


		
		System.out.println("##### VAMOS A PERSISTENCIA A BUSCAR LOS DECORADOS ####### " );
		/*Actividad_Examen exa = new Examen_Clase(examen2);
		exa = Unidad_Logica.getInstance().crearExamen(exa);
		System.err.println("CREADO: " + exa.getId_examen());*/
		Asignatura asignaturaPruebaConActividades = Unidad_Logica.getInstance().obtenerInformacionAsignatura("ALG");
		Actividad actPrueba1 = new Clase(asignaturaPruebaConActividades, "Prueba de ordnacion Para despues", "Descripcion de prueba pendiente", LocalDateTime.now(), 0, 0, 0, true,true, true);
		actPrueba1 = Unidad_Logica.getInstance().crearClase((Clase)actPrueba1);

		System.out.println("Creada: " + actPrueba1);
		//Siempre se busca con el id_examen no el del examen que decora
		/*Examen_Practicas exa = new ExamenPracticasDAOImp().obtenerInformacionDeExamen_Practicas(3);

		Examen_Clase exa_clase = new ExamenClaseDAOImp().obtenerInformacionDeExamen_Clase(2);

		System.out.println("Examen practicas encontrado: " + exa.getId_actividad() + "\ny con mas detalle: " + exa.getExamen() + "\n" + exa.getTitulo());

		System.out.println("Examen clase encontrado: " + exa_clase.getId_actividad() + "\ny con mas detalle: " + exa_clase.getExamen() + "\n" + exa_clase.getTitulo());
		*/
		
		//System.out.println("Buscamos examen poliformat..... ");
		//Examen_Poliformat a= new ExamenPoliformatDAOImp().obtenerInformacionDeExamenPoliformat(4);
		//Actividad_Examen a = Unidad_Logica.getInstance().obtenerInformacionDeExamen(4);

		//System.err.println("Examen poliformat encontrado" + a.getDescripcion()+"," + a.getId_actividad() +","+ a.getId_examen());
		
		
		/*System.out.println("Vamos a borrar desde persistencia un examen-poliformat-practica");

		DAL.getInstance().eliminarExamen(3);
		System.out.println("Eliminado!");*/
	}
	
}
