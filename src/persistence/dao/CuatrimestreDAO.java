package persistence.dao;

import bussines.Cuatrimestre;

public interface CuatrimestreDAO {
	
	public Cuatrimestre obtenerInformacionCuatrimestre(int id_cuatrimestre);
	
	public void eliminarCuatrimestre(int id_cuatrimestre);
	
	public Cuatrimestre crearCuatrimestre(Cuatrimestre cuatrimestre);
	
	public void editarCuatrimestre(Cuatrimestre cuatrimestre);

}
