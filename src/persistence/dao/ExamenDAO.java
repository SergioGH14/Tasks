package persistence.dao;

import bussines.Examen;

public interface ExamenDAO {
    
	public Examen obtenerInformacionDeExamen(int id);
	
	public void eliminarExamen(int id);
	
	public Examen crearExamen(Examen examen);
	
	public void editarExamen(Examen examen);
}
