package test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import bussines.Actividad;
import bussines.Asignatura;
import bussines.Clase;
import bussines.Estrategia_Ordenacion_BandejaEntrada;
import bussines.Estrategia_Ordenacion_Hoy;
import bussines.Estrategia_Ordenacion_ParaDespues;
import bussines.Estrategia_Ordenacion_Prioridad;
import bussines.Notificacion;


public class Prueba_Estrategia {
	@Test
	public  void test(){
			 List<Actividad> listaPruebas = new ArrayList<Actividad>();
			 List<Actividad> listaResultado = new ArrayList<Actividad>();
			 List<Actividad> listaResultadoFecha = new ArrayList<Actividad>();
			 listaPruebas.add(ActividadX);
			 listaPruebas.add(ActividadY);
			 listaPruebas.add(ActividadZ);
			 
			 listaResultado.add(ActividadY);
			 listaResultado.add(ActividadX);
			 listaResultado.add(ActividadZ);
			 
			 listaResultadoFecha.add(ActividadX);
			 listaResultadoFecha.add(ActividadZ);
			 listaResultadoFecha.add(ActividadY);		 
			 
			 CSD.anyadirActividad(ActividadX);
			 CSD.anyadirActividad(ActividadY);
			 CSD.anyadirActividad(ActividadZ);
			 
			 System.out.println("Lista inicial:\n"+prioridades(listaPruebas));

			 BandejaEntrada.ordenar(listaPruebas);
			 System.out.println("Resultado Bandeja de entrada:\n"+prioridades(listaPruebas));
			 Assert.assertEquals(listaResultado, listaPruebas);
		
			 Hoy.ordenar(listaPruebas);
			 System.out.println("Resultado Ordenacion hoy:\n"+prioridades(listaPruebas));
			 Assert.assertEquals(listaResultado, listaPruebas);
	
			 ParaDespues.ordenar(listaPruebas);
			 System.out.println("Resultado Para Despues:\n"+Fechas(listaPruebas));
			 Assert.assertEquals(listaResultadoFecha, listaPruebas);
			
			 Prioridad.ordenar(listaPruebas);
			 System.out.println("Resultado Prioridad:\n"+prioridades(listaPruebas));
			 Assert.assertEquals(listaResultado, listaPruebas);
	}
	
 
		 
    static Asignatura CSD = new Asignatura(null, "CSD", 6, 10, false, null);
	static Clase ActividadZ = new Clase(CSD, "Clase Z", "", Util.Date_solver.fechaDeHoy().minusDays(3), 10, 0.4, 10, false, false, false);
	static Clase ActividadX = new Clase(CSD, "Clase X", "", Util.Date_solver.fechaDeHoy().minusDays(5), 10, 8.0, 15, false, false, false);
	static Clase ActividadY = new Clase(CSD, "Clase Y", "", Util.Date_solver.fechaDeHoy().minusDays(1), 10, 9.2, 20, false, false, false);
	static Estrategia_Ordenacion_BandejaEntrada BandejaEntrada = new Estrategia_Ordenacion_BandejaEntrada();
	static Estrategia_Ordenacion_Hoy Hoy = new Estrategia_Ordenacion_Hoy();
	static Estrategia_Ordenacion_ParaDespues ParaDespues = new Estrategia_Ordenacion_ParaDespues();
	static Estrategia_Ordenacion_Prioridad Prioridad = new Estrategia_Ordenacion_Prioridad(CSD);
	
	
	
	public static String prioridades(List<Actividad> list){
		int i = 0;
		String res = "";
		while (i<list.size()) {
			res = res + list.get(i).getTitulo()+"<- Actividad Prioridad ->"+list.get(i).getPrioridadTotal()+"\n"; 
			i++;
		}
		return res;
		
	}
	
	public static String Fechas(List<Actividad> list){
		int i = 0;
		String res = "";
		while (i<list.size()) {
			res = res + list.get(i).getTitulo()+"<- Actividad Fecha ->"+list.get(i).getFechaFinalizacion()+"\n"; 
			i++;
		}
		return res;
		
	}

}

