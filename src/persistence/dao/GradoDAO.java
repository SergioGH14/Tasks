package persistence.dao;

import bussines.Grado;

public interface GradoDAO {

	public Grado obtenerInformacionGrado(int id_grado);

	public Grado crearGrado(Grado grado);
	
	public void eliminarGrado(int id_grado);
	
	public void editarGrado(Grado grado);
	
}
