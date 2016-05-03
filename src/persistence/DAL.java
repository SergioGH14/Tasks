package persistence;

import persistence.dao.AsignaturaDAO;
import persistence.dao.UniversidadDAO;
import persistence.dao.UsuarioDAO;
/*
 * Capa previa a persistencia
 */
public class DAL {
	private static DAL instance;
	
	private AsignaturaDAO asignaturaDAO;
	private UsuarioDAO usuarioDAO;
	private UniversidadDAO universidadDAO;
	//aqui las demás interfaces 
	
	private DAL(){
		
	}
	
	public static DAL getInstance(){
		if(instance == null){
			instance = new DAL();
		}
		return instance;
	}

	
}
