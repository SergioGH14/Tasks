package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Clase;
import bussines.Fabrica_Actividad;
import bussines.Practicas;
import bussines.Unidad_Logica;
import persistence.dto.ActividadDTO;

public class Prueba_Fabrica_JUnit {
	private ArrayList<Boolean> especificaciones = new ArrayList<Boolean>();
	private Asignatura CSD = 
			Unidad_Logica.getInstance().obtenerInformacionAsignatura("CSD");
	private ActividadDTO adto = 
			new ActividadDTO(CSD.getTitulo(), 
					"Prueba", "Descripcion Prueba", 
					LocalDateTime.now(), 0, 0, 0, 
					false);
	private int tipo = 0;

	@Test
	public void testCrearPracticaDificil() {
		tipo = 1;
		adto.setPrioridadUsuario(30);
		adto.setTiempoEstimado(15);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad = 
				Fabrica_Actividad.getInstance()
				.crearActividad(tipo, adto, especificaciones);
		
		if(!(actividad instanceof Practicas) )fail("ERROR TIPO NO ESPERADO -PRACTICA-");
		if(actividad.getPrioridadTotal()!=78)fail("ERROR PRIORIDAD != 78 -PRACTICA-");
	}
	@Test
	public void testCrearPracticaMedio() {
		tipo = 1;
		adto.setPrioridadUsuario(20);
		adto.setTiempoEstimado(10);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =Fabrica_Actividad.getInstance().crearActividad(tipo, adto, especificaciones);
		
		if(!(actividad instanceof Practicas) )fail("ERROR TIPO NO ESPERADO -PRACTICA-");
		if(actividad.getPrioridadTotal()!=63)fail("ERROR PRIORIDAD != 63 -PRACTICA-");
	}
	@Test
	public void testCrearPracticaBajo() {
		tipo = 1;
		adto.setPrioridadUsuario(10);
		adto.setTiempoEstimado(5);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =Fabrica_Actividad.getInstance().crearActividad(tipo, adto, especificaciones);
		
		if(!(actividad instanceof Practicas) )fail("ERROR TIPO NO ESPERADO -PRACTICA-");
		if(actividad.getPrioridadTotal()!=48)fail("ERROR PRIORODAD != 48 -PRACTICA-");
	}
	@Test
	public void testCrearClaseDificil() {
		tipo = 2;
		adto.setPrioridadUsuario(30);
		adto.setTiempoEstimado(15);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =Fabrica_Actividad.getInstance().crearActividad(tipo, adto, especificaciones);
		
		if(!(actividad instanceof Clase) )fail("ERROR TIPO NO ESPERADO -CLASE-");
		if(actividad.getPrioridadTotal()!=59)fail("ERROR PRIORODAD != 59 -CLASE-");
	}
	@Test
	public void testCrearClaseMedio() {
		tipo = 2;
		adto.setPrioridadUsuario(20);
		adto.setTiempoEstimado(10);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =
				Fabrica_Actividad.getInstance()
				.crearActividad(tipo, adto, especificaciones);
		if(!(actividad instanceof Clase) )fail("ERROR TIPO NO ESPERADO -CLASE-");
		if(actividad.getPrioridadTotal()!=44)fail("ERROR PRIORODAD != 44 -CLASE-");
	}
	@Test
	public void testCrearClaseBajo() {
		tipo = 2;
		adto.setPrioridadUsuario(10);
		adto.setTiempoEstimado(5);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =Fabrica_Actividad.getInstance().crearActividad(tipo, adto, especificaciones);
		
		if(!(actividad instanceof Clase) )fail("ERROR TIPO NO ESPERADO -CLASE-");	
		if(actividad.getPrioridadTotal()!=29)fail("ERROR PRIORODAD != 29 -CLASE-");
	}
	@Test
	public void testCrearExamenDificil() {
		tipo = 3;
		adto.setPrioridadUsuario(30);
		adto.setTiempoEstimado(15);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =Fabrica_Actividad.getInstance().crearActividad(tipo, adto, especificaciones);
		if(!(actividad instanceof Actividad_Examen) )fail("ERROR TIPO NO ESPERADO -Examen-");	
		if(actividad.getPrioridadTotal()!=83)fail("ERROR PRIORODAD !=  -CLASE-");
	}
	@Test
	public void testCrearExamenMedio() {
		tipo = 3;
		adto.setPrioridadUsuario(20);
		adto.setTiempoEstimado(10);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =Fabrica_Actividad.getInstance().crearActividad(tipo, adto, especificaciones);
		if(!(actividad instanceof Actividad_Examen) )fail("ERROR TIPO NO ESPERADO -Examen-");	
		if(actividad.getPrioridadTotal()!=68)fail("ERROR PRIORODAD != 68 -EXAMEN-");

	}
	@Test
	public void testCrearExamenBajo() {
		tipo = 3;
		adto.setPrioridadUsuario(10);
		adto.setTiempoEstimado(5);
		especificaciones.add(false);
		especificaciones.add(false);
		Actividad actividad =
				Fabrica_Actividad.getInstance()
				.crearActividad(tipo, adto, especificaciones);
		if(!(actividad instanceof Actividad_Examen) )fail("ERROR TIPO NO ESPERADO -Examen-");	
		if(actividad.getPrioridadTotal()!=53)fail("ERROR PRIORODAD != 53 -EXAMEN-");
	}
}
