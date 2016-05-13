package persistence.dao;

import java.util.List;

import bussines.Asignatura;
import persistence.dto.AsignaturaDTO;

public interface AsignaturaDAO {
	
	public Asignatura obtenerInformacionAsignatura(String nombreAsignatura);
	
	public List<Asignatura> obtenerAsignaturasPorCuatrimestre(int cuatrimestre);
	
	public Asignatura crearAsignatura(Asignatura asignatura);

	public void editarAsignatura(Asignatura asignatura);
	
	public void eliminarAsignatura(int id_asignatura);
	
	public boolean existeAsignatura(String nombreAsignatura);
	
}
