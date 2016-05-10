package persistence;

import java.util.List;

import Util.Constantes;
import persistence.dao.AsignaturaDAO;
import persistence.dto.AsignaturaDTO;

public class AsignaturaDAOImp implements AsignaturaDAO{
	
	protected ConnectionManager connectionManager;
	
	public AsignaturaDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, AsignaturaDAO: "+e.getLocalizedMessage());
		}
	}

	@Override
	public AsignaturaDTO buscarAsignatura(String nombreAsignatura) {
		
		return null;
	}

	@Override
	public List<AsignaturaDTO> obtenerAsignaturasPorCuatrimestre(int cuatrimestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearAsignatura(AsignaturaDTO asignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarAsignatura(AsignaturaDTO asignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int crearSecuencia(String nombreSecuencia) {
		// TODO Auto-generated method stub
		return 0;
	}


}
