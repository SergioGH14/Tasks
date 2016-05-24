package persistence.dao;

import java.util.List;

import bussines.Actividad;
import bussines.Asignatura;
import bussines.Examen_Clase;

public interface ExamenClaseDAO {
    
	public Examen_Clase obtenerInformacionDeExamen_Clase(int id);
	
	public void eliminarExamen_Clase(int id);
	
	public Examen_Clase crearExamen_Clase(Examen_Clase examenclase);
	
	public void editarExamen_Clase(Examen_Clase examenclase);
}
