package bussines;



import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import Util.Basics;
import Util.Constantes;
import Util.Date_solver;

public class Papinoti {
	
	public static int[] diasArestar ={1,7,14};
	public static String[] titulo = {" ma�ana"," en 7 dias"," en 14 dias"};
	public static int[] prioridad = {0,-10,-20};
	static List <Notificacion> noti = new ArrayList<Notificacion>();
	
	public static List<Notificacion> crearNotificaciones(Actividad actividad){
		
		LocalDateTime fechaAct = actividad.getFechaFinalizacion();
		int prioridadAct =  actividad.getPrioridadTotal();
		String tituloAct =  actividad.getTitulo();
		int tipoActividad = tipoActividad(actividad);
		int id_actividad = ((Actividad)actividad).getId_actividad();
		String colAsig =  Basics.RGBToHex(actividad.getAsignatura().getColor());
		
		for(int i = 0; i<3;i++){
			
			noti.add(new  Notificacion(id_actividad,
					  concat(tituloAct, titulo[i]),
					  colAsig,
					  descripcionActividad(tipoActividad),
					  prioridadNotificacion(prioridadAct, prioridad[i]),
					  restar(fechaAct, diasArestar[i])));
		}
		
		return noti;
	}
	private static String concat(String X, String Y){
		return X+Y;
	}
		
	private static int tipoActividad(Actividad actividad){
		if(actividad instanceof Practicas){return 3;}
		else if(actividad instanceof Clase){return 2;}
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

	private static LocalDateTime restar(LocalDateTime fecha, int DiasARestar){
				
		return Date_solver.restar(DiasARestar, fecha);
	} 

	private static int prioridadNotificacion(int PrioActividad, int PrioARestar){
		return PrioActividad-PrioARestar;
	}
}
