package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import Util.Date_solver;
import bussines.*; 
import javafx.scene.paint.Color;
import persistence.ActividadDAOImp;
import persistence.DAL;
import persistence.dto.ActividadDTO;

public class Prueba_Fabrica {
/*AVISO PARA NAVEGANTES esto es el main que he hecho yo SERGIO para probar el fabrica. 
 * Podemos usarlo tambien para probar la persistencia mas adelante
 * :)
 * */
	private static Scanner teclado;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			teclado = new Scanner(System.in);	
			int dificultadAsignatura = 21;
			int tiempoestimado= 15;
			double porcentaje = 0.5;
			ArrayList<Boolean> especificaciones = new ArrayList<Boolean>();
			especificaciones.add(true);
			especificaciones.add(true);
			LocalDateTime fecha = LocalDateTime.now();
			
	
	    Cuatrimestre cuatrimestre = DAL.getInstance().obtenerInformacionCuatrimestre(3);
		System.out.println(cuatrimestre);
		
		Asignatura CSD = new Asignatura(cuatrimestre, "PRUEBA", 0, 0, false, Color.ANTIQUEWHITE);
		CSD = DAL.getInstance().crearAsignatura(CSD);
		System.out.println(CSD);
		
		System.out.println("Crear nueva tarea de "+CSD.getTitulo()+" .");
		System.out.println("Introduce Titulo: ");
		String Titulo = teclado.nextLine();
		System.out.println("Introduce Descripcion: ");
		String descripcion = teclado.nextLine();
		System.out.println("Introduce tu prioridad(10   20    30): ");
		int prioridadusuario = teclado.nextInt();
		System.out.println("Introduce tu tipo(1 practica   2 clase   3 examen): ");
		int tipo = teclado.nextInt();
		
		Fabrica_Actividad constructora = Fabrica_Actividad.getInstance();
		
		ActividadDTO adto= new ActividadDTO( CSD.getTitulo(), Titulo, descripcion, fecha, tiempoestimado, porcentaje, prioridadusuario,false);
		Actividad actividad = constructora.crearActividad(tipo,adto,especificaciones );
		System.out.println("Actividad sin id: " + actividad);
		//actividad = new ActividadDAOImp().crearActividad(actividad);
		System.out.println("Actividad CON id: " + actividad);

		System.out.println("Has creado con exito una actividad de nombre "+actividad.getTitulo()+"\nCuya descripcion es la siguiente: "+actividad.getDescripcion()+"\ny mas importante, su prioridad total es "+actividad.getPrioridadTotal()+"");
		Iterator<Notificacion> it = Unidad_Logica.getInstance().notificacionesDeHoy().iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		//System.out.println("Asignatura 2: " + DAL.getInstance().obtenerInformacionAsignatura("PRUEBA"));
		
	}

}
