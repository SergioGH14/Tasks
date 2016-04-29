package persistence.dao;

import java.util.List;

import persistence.dto.AsignaturaDTO;

public interface AsignaturaDAO {
	
	public AsignaturaDTO buscarAsignatura(String nombreAsignatura);
	
	public List<AsignaturaDTO> obtenerAsignaturasPorCuatrimestre(int cuatrimestre);
	
	public void crearAsignatura(AsignaturaDTO asignatura);

}
