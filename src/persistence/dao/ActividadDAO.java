package persistence.dao;

import bussines.Actividad;

public interface ActividadDAO {
	public Actividad obtenerInformacionDeActividad(int id_actividad);
	
	public void eliminarActividad(int id_actividad);
	
	public Actividad crearActividad(Actividad actividad);
	
	public void editarActividad(Actividad actividad);
}
