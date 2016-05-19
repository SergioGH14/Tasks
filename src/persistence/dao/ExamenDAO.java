package persistence.dao;

import bussines.Actividad_Examen;
import bussines.Examen;

public interface ExamenDAO {
    
	public Examen obtenerInformacionDeExamen(int id);
	
	public void eliminarExamen(int id);
	
	public Actividad_Examen crearExamen(Actividad_Examen examen);
	
	public void editarExamen(Examen examen);
}
