package persistence.dao;

import bussines.Examen_Poliformat;

public interface ExamenPoliformatDAO {
    public Examen_Poliformat obtenerInformacionDeExamenPoliformat(int id);
	
	public void eliminarExamenPoliformat(int id);
	
	public Examen_Poliformat crearExamenPoliformat(Examen_Poliformat ExamenPoliformat);
	
	public void editarExamenPoliformat(Examen_Poliformat ExamenPoliformat);
}
