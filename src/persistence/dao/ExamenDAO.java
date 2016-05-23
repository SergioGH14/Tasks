package persistence.dao;

import java.util.List;

import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen;

public interface ExamenDAO {
    
	public Examen obtenerInformacionDeExamen(int id);
	
	public void eliminarExamen(int id);
	
	public Actividad_Examen crearExamen(Actividad_Examen examen);
	
	public void editarExamen(Examen examen);
	
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura);

	public List<Actividad> obtenerTodasActividades();
		
	public List<Actividad> obtenerActividadesHoy();
	
	public List<Actividad> obtenerActividadesParaDespues();
}
