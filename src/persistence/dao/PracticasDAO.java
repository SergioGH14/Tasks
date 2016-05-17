package persistence.dao;

import bussines.Practicas;

public interface PracticasDAO {
    
	public Practicas obtenerInformacionDePracticas(int id_Practicas);
	
	public void eliminarPracticas(int id_Practicas);
	
	public Practicas crearPracticas(Practicas Practicas);
	
	public void editarPracticas(Practicas Practicas);

}
