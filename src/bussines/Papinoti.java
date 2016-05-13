package bussines;

import java.time.LocalDateTime;
import java.util.*;

import Util.Constantes;
import Util.Date_Solver;

public class Papinoti {
	
	public static List<Notificacion> crearNotificaciones(Actividad d){
		List <Notificacion> noti = null;
		LocalDateTime fechaAct = d.getFechafinalizacion();
		int prioridadAct =  d.getPrioridadtotal();
		String tituloAct =  d.getTitulo();
		int tipoActividad = tipoActividad(d);
		
		
		Notificacion a = new Notificacion(tituloAct+"en 14 dias",
										  descripcionActividad(tipoActividad),
										  prioridadAct-20,
										  Date_Solver.restar(14, fechaAct));
		Notificacion b = new Notificacion(tituloAct+"en 7 dias",
										  descripcionActividad(tipoActividad),
										  prioridadAct-10,
								          Date_Solver.restar(7, fechaAct));
		Notificacion c = new Notificacion(tituloAct+" ma�ana",
				                          descripcionActividad(tipoActividad),
				                          prioridadAct,
				                          Date_Solver.restar(1, fechaAct) );
		
	
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
