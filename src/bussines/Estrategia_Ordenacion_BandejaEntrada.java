package bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public class Estrategia_Ordenacion_BandejaEntrada implements Estrategia_Ordenacion_Actividades{

	@Override
	public List<Actividad> ordenar() {
	    //List<Actividad> lista = dal.obtenerActividades(asignatura);
		//operaciones para esta lista
		
		//pruebas:
		List<Actividad> listaprueba = new ArrayList<Actividad>();
		Asignatura asignaturaPruebaConActividades = new Asignatura("ASIGNATURA PRUEBA", Color.BLUEVIOLET);

		Actividad actPrueba1 = new Clase(1,asignaturaPruebaConActividades, "Prueba de ordnacion Bandeja", "Descripcion de prueba pendiente", LocalDateTime.now(), 0, 0, 0, true, false, false);
		actPrueba1.setId_actividad(1);
		listaprueba.add(actPrueba1);
		return listaprueba;
	}

}
