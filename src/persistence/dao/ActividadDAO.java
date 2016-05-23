package persistence.dao;

import bussines.Actividad;
import persistence.dto.ActividadDTO;

public interface ActividadDAO {
	public ActividadDTO obtenerInformacionDeActividad(int id_actividad);
	
	public ActividadDTO obtenerInformacionDeActividadExamen(int id_actividad_examen);
	
	public void eliminarActividad(int id_actividad);
	
	public Actividad crearActividad(Actividad actividad);
	
	public void editarActividad(Actividad actividad);
	
}
