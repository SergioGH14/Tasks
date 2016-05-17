package persistence.dao;

import bussines.Clase;

public interface ClaseDAO {
    
	public Clase obtenerInformacionDeClase(int id_clase);
	
	public void eliminarClase(int id_clase);
	
	public Clase crearClase(Clase clase);
	
	public void editarClase(Clase clase);
}
