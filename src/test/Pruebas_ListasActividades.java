package test;

import java.util.List;

import bussines.*;
import persistence.ActividadDAOImp;
import persistence.DAL;

public class Pruebas_ListasActividades {
	
	public static void main(String args[]){
		//probarListaActividades();
	}

	private static void probarListaActividades() {
		System.out.println("Vamos a probar la lista de actividades que devuelve persistencia:\n");
		Asignatura asignatura = DAL.getInstance().obtenerInformacionAsignatura(2);
		List<Actividad> lista = DAL.getInstance().obtenerPracticasDeAsignatura(asignatura);
		
		for(Actividad act : lista){
			System.err.println("Actividad: " + (Practicas)act);
		}
	}

	private static void probarListaActividadesDecorador(){
		
	}
}
