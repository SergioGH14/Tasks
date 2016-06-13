package test;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;







import org.junit.Test;

import javafx.scene.paint.Color;
import bussines.Actividad;
import bussines.Asignatura;
import bussines.Clase;
import bussines.Notificacion;
import bussines.Papinoti;

public class Prueba_Papinoti {
	
	@Test
	public  void main() {
		
		List<Notificacion> noti = new ArrayList<Notificacion>();
		CSD.anyadirActividad(ActividadZ);
		introducirNotificaciones(noti, Papinoti.crearNotificaciones(ActividadZ) );
		System.out.println(imprimir(noti));
		 assertTrue(noti.size() == 3);

	}
	
	static Color colorRosa = new Color(0,0,0,0);
	static Asignatura CSD = new Asignatura(null, "CSD", 6, 10, false, colorRosa );
	static Clase ActividadZ = new Clase(CSD, "Clase Z", "", Util.Date_solver.fechaDeHoy().minusDays(3), 10, 0.4, 10, false, false, false);

	public static String imprimir(List<Notificacion> noti){
		String res = "";
		Iterator<Notificacion> it = noti.iterator();
	   while (it.hasNext()) {
		   Notificacion A = it.next();
		   res = res + A.toString()+"\n";
		   //res = res + "Titulo ->"+A.getTitulo()+"\nFecha de notificacion ->"+A.getFecha_notificacion()+"\nPrioridad ->"+A.getPrioridad()+"\n\n\n";
	   }
	   return res;
	}
	public static void introducirNotificaciones(List<Notificacion> noti,List <Notificacion> papinoti){
		Iterator<Notificacion> it = papinoti.iterator();
		   while (it.hasNext()) {
			 noti.add(it.next());
		   }
	}
}
