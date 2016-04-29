package persistence;

import persistence.dao.AsignaturaDAO;
/*
 * Capa previa a persistencia
 */
public class DAL {
	private static DAL instance;
	
	private AsignaturaDAO asignaturaDAO;
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
