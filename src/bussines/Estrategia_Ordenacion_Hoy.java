package bussines;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import persistence.DAL;

public class Estrategia_Ordenacion_Hoy implements Estrategia_Ordenacion_Actividades {

	private DAL dal;
	
	@Override
	public List<Actividad> ordenar() {
		//List<Actividad> lista = dal.obtenerActividades(asignatura);
		//operaciones
		
		//pruebas:
		List<Actividad> lista = new ArrayList<Actividad>();
		lista.addAll(Unidad_Logica.getInstance().practicasDeHoy());
	//	lista.addAll(dal.getInstance().obtenerClasesHoy());
		
		 return lista;
	}

}
