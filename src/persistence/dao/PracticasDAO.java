package persistence.dao;

import java.util.List;

import bussines.Actividad;
import bussines.Asignatura;
import bussines.Practicas;

public interface PracticasDAO {
    
	public Practicas obtenerInformacionDePracticas(int id_Practicas);
	
	public void eliminarPracticas(int id_Practicas);
	
	public Practicas crearPracticas(Practicas Practicas);
	
	public void editarPracticas(Practicas Practicas);
	
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura);

	public List<Actividad> obtenerTodasActividades();
		
	public List<Actividad> obtenerActividadesHoy();
	
	public List<Actividad> obtenerActividadesParaDespues();
}
