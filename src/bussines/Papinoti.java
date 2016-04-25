package bussines;

import java.util.Date;
import java.util.List;

import Util.Date_solver;

public class Papinoti {
	
	public static List crearNotificaciones(Actividad d){
		List noti = null;
      /* Recuperando los parametros de la actividad necesarios para crear las notificaciones
	   falta crear los arrays para crear las descripciones de las notificaciones 
	   y que las seleccione de foma aleatoria 	   
	*/
		Date fechaAct = d.getFechafinalizacion();
		int prioridadAct =  d.getPrioridadtotal();
		String tituloAct =  d.getTitulo();
		// creando las notificaciones una por una 
		
		
		
		Notificacion a = new Notificacion(tituloAct+"en 14 dias", tituloAct, prioridadAct-20,Date_solver.restarFechasDias(fechaAct, 14) );
		Notificacion b = new Notificacion(tituloAct+"en 7 dias", tituloAct, prioridadAct-10, Date_solver.restarFechasDias(fechaAct, 7));
		Notificacion c = new Notificacion(tituloAct+" mañana", tituloAct, prioridadAct, Date_solver.restarFechasDias(fechaAct, 1) );
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		noti.add(a);
		noti.add(b);
		noti.add(c);
		
		return noti;
		
		
	}
	
}
