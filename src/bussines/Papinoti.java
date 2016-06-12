package bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Util.Basics;
import Util.Constantes;
import Util.Date_solver;

public class Papinoti {
	
	public static List<Notificacion> crearNotificaciones(Actividad actividad){
		List <Notificacion> noti = new ArrayList<Notificacion>();;
		LocalDateTime fechaAct = actividad.getFechafinalizacion();
		int prioridadAct =  actividad.getPrioridadtotal();
		String tituloAct =  actividad.getTitulo();
		int tipoActividad = tipoActividad(actividad);
		int id_actividad = ((Actividad)actividad).getId_actividad();
		
		System.err.println("Tipo actividad: " + tipoActividad);
		
		Notificacion a = new Notificacion(id_actividad,tituloAct+" en 14 días",
										  Basics.RGBToHex(actividad.getAsignatura().getColor()),
										  descripcionActividad(tipoActividad),
										  prioridadAct-20,
										  Date_solver.restar(14, fechaAct));
		Notificacion b = new Notificacion(id_actividad,tituloAct+" en 7 días",
										Basics.RGBToHex(actividad.getAsignatura().getColor()),
										  descripcionActividad(tipoActividad),
										  prioridadAct-10,
								          Date_solver.restar(7, fechaAct));
		Notificacion c = new Notificacion(id_actividad,tituloAct+" mañana",
										Basics.RGBToHex(actividad.getAsignatura().getColor()),
				                          descripcionActividad(tipoActividad),
				                          prioridadAct,
				                          Date_solver.restar(1, fechaAct) );
		
	
		noti.add(a);
		noti.add(b);
		noti.add(c);
		
		return noti;
		
		
	}
		
	private static int tipoActividad(Actividad d){
		if(d instanceof Practicas){return 3;}
		else if(d instanceof Clase){return 2;}
		else return 1;
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
