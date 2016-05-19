package bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Util.Constantes;
import Util.Date_solver;

public class Papinoti {
	
	public static List<Notificacion> crearNotificaciones(Actividad d){
		List <Notificacion> noti = new ArrayList<Notificacion>();;
		LocalDateTime fechaAct = d.getFechafinalizacion();
		int prioridadAct =  d.getPrioridadtotal();
		String tituloAct =  d.getTitulo();
		int tipoActividad = tipoActividad(d);
		
		
		Notificacion a = new Notificacion(d,tituloAct+" en 14 dias",
										  descripcionActividad(tipoActividad),
										  prioridadAct-20,
										  Date_solver.restar(14, fechaAct));
		Notificacion b = new Notificacion(d,tituloAct+" en 7 dias",
										  descripcionActividad(tipoActividad),
										  prioridadAct-10,
								          Date_solver.restar(7, fechaAct));
		Notificacion c = new Notificacion(d,tituloAct+" mañana",
				                          descripcionActividad(tipoActividad),
				                          prioridadAct,
				                          Date_solver.restar(1, fechaAct) );
		
	
		noti.add(a);
		noti.add(b);
		noti.add(c);
		
		return noti;
		
		
	}
		
	private static int tipoActividad(Actividad d){
		if(d instanceof Examen){return 1;}
		else if(d instanceof Clase){return 2;}
		else return 3;
	}
	
	private static String descripcionActividad(int tipo){
		String des = null;
		switch (tipo) {
		case 1: des = Constantes.descripcionExamen();
		case 2: des = Constantes.descripcionClase();
		case 3: des = Constantes.descripcionPracticas();
		}
		return des;
	}
}
