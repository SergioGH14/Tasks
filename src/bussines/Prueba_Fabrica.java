package bussines;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import javafx.util.converter.LocalDateTimeStringConverter;

public class Prueba_Fabrica {
/*AVISO PARA NAVEGANTES esto es el main que he hecho yo SERGIO para probar el fabrica. 
 * Podemos usarlo tambien para probar la persistencia mas adelante
 * :)
 * */
	private static Scanner teclado;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Asignatura CSD = new Asignatura("CSD", 6.0, 14, false);
		
		teclado = new Scanner(System.in);
		System.out.println("Crear nueva tarea de "+CSD.getTitulo()+" .");
		
		System.out.println("Introduce Titulo: ");
		String Titulo = teclado.nextLine();
		System.out.println("Introduce Descripcion: ");
		String descripcion = teclado.nextLine();
		Date fecha = new Date();
		int tiempoestimado= 10;
		double porcentaje = 0.5;
		System.out.println("Introduce tu prioridad(10   20    30): ");
		int prioridadusuario = teclado.nextInt();
		System.out.println("Introduce tu tipo(1 practica   2 clase   3 examen): ");
		int tipo = teclado.nextInt();
		
		Fabrica_Actividad constructora = new Fabrica_Actividad();
		
		Actividad actividad = constructora.crearActividad(tipo, CSD, Titulo, descripcion, fecha, tiempoestimado, porcentaje, prioridadusuario, 0, false, true, false);
		System.out.println("Has creado con exito una actividad de nombre "+actividad.getTitulo()+"\nCuya descripcion es la siguiente: "+actividad.getDescripcion()+"\ny mas importante, su prioridad total es "+actividad.getPrioridadtotal()+"");
		
	}

}
