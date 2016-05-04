package persistence.dao;

import bussines.Universidad;


public interface UniversidadDAO {

	public Universidad obtenerInformacionDeUniversidad(int id_universidad);
	
	public void eliminarUniversidad(int id_universidad);
	
	public void crearUniversidad(Universidad universidad);
	
	public void editarUniversiad(Universidad universidad);
		

}
