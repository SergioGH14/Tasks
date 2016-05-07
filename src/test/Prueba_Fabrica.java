package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import bussines.Actividad;
import bussines.Asignatura;
import bussines.Fabrica_Actividad;

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
			
		Asignatura CSD = new Asignatura("CSD");
		
		
		System.out.println("Crear nueva tarea de "+CSD.getTitulo()+" .");
		System.out.println("Introduce Titulo: ");
		String Titulo = teclado.nextLine();
		System.out.println("Introduce Descripcion: ");
		String descripcion = teclado.nextLine();
		System.out.println("Introduce tu prioridad(10   20    30): ");
		int prioridadusuario = teclado.nextInt();
		System.out.println("Introduce tu tipo(1 practica   2 clase   3 examen): ");
		int tipo = teclado.nextInt();
		
		Fabrica_Actividad constructora = Fabrica_Actividad.dameFabrica_Actividad();
		
		Actividad actividad = constructora.crearActividad(tipo, CSD, Titulo, descripcion, fecha, tiempoestimado, porcentaje, prioridadusuario, false,especificaciones );
		System.out.println("Has creado con exito una actividad de nombre "+actividad.getTitulo()+"\nCuya descripcion es la siguiente: "+actividad.getDescripcion()+"\ny mas importante, su prioridad total es "+actividad.getPrioridadtotal()+"");
		
	}

}
