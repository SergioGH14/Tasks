package persistence.dao;

import java.util.List;

import bussines.Actividad;
import bussines.Asignatura;
import bussines.Clase;

public interface ClaseDAO {
    
	public Clase obtenerInformacionDeClase(int id_clase);
	
	public void eliminarClase(int id_clase);
	
	public Clase crearClase(Clase clase);
	
	public void editarClase(Clase clase);
	
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura);

	public List<Actividad> obtenerTodasActividades();
		
	public List<Actividad> obtenerActividadesHoy();
	
	public List<Actividad> obtenerActividadesParaDespues();
}
