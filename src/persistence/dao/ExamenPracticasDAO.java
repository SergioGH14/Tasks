package persistence.dao;

import java.util.List;

import bussines.Actividad;
import bussines.Asignatura;
import bussines.Examen_Practicas;

public interface ExamenPracticasDAO {
    public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id);
	
	public void eliminarExamen_Practicas(int id);
	
	public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas);
	
	public void editarExamen_Practicas(Examen_Practicas examenPracticas);
	
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura);

	public List<Actividad> obtenerTodasActividades();
		
	public List<Actividad> obtenerActividadesHoy();
	
	public List<Actividad> obtenerActividadesParaDespues();
}
