package persistence.dao;

import java.util.List;

import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen;

public interface ExamenDAO {
    
	public Actividad_Examen obtenerInformacionDeExamen(int id_examen_concreto);
	
	public Actividad_Examen obtenerInformacionDeExamenSinDecoracion(int id_examen_concreto);
	
	public void eliminarExamen(int id);
	
	public Actividad_Examen crearExamen(Actividad_Examen examen);
	
	public void editarExamen(Examen examen);
	
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura);

	public List<Actividad> obtenerTodasActividades();
		
	public List<Actividad> obtenerActividadesHoy();
	
	public List<Actividad> obtenerActividadesParaDespues();
}
