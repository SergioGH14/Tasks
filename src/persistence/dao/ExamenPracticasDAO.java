package persistence.dao;

import bussines.Examen_Practicas;

public interface ExamenPracticasDAO {
    public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id);
	
	public void eliminarExamen_Practicas(int id);
	
	public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas);
	
	public void editarExamen_Practicas(Examen_Practicas examenPracticas);
}
