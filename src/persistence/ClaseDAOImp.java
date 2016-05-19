package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import bussines.Actividad;
import bussines.Clase;
import bussines.Practicas;
import persistence.dao.ClaseDAO;

public class ClaseDAOImp implements ClaseDAO {
	
	protected ConnectionManager connectionManager;
	
	public ClaseDAOImp(){
		try{
			connectionManager = new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ClaseDAOImp: "+e.getLocalizedMessage());
		}
	}

	@Override
	public Clase obtenerInformacionDeClase(int id_clase) {
		Clase clas = null;
		try{
			connectionManager.connect();
			ResultSet claseResultSet = connectionManager.queryDB("SELECT * from CLASE where id_practicas = '"+id_clase+"'");
			connectionManager.close();

		
			if (claseResultSet.next()){
				Actividad acti = new ActividadDAOImp().obtenerInformacionDeActividad(claseResultSet.getInt("id_actividad"));
				
				clas = new Clase(claseResultSet.getInt("id_clase"),
						         new AsignaturaDAOImp().obtenerInformacionAsignatura(acti.getAsignatura().getTitulo()),
								 acti.getTitulo(),
								 acti.getDescripcion(),
								 acti.getFechafinalizacion(), 
								 acti.getTiempoestimado(),
								 acti.getPorcentaje(),
								 acti.getPrioridadusuario(),
								 acti.isFinalizada(), 
								 claseResultSet.getBoolean("puntuable"));
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar el practicas: "+e.getLocalizedMessage() );
		}
		
		return clas;

		
	}

	@Override
	public void eliminarClase(int id_clase) {
		Clase clas = obtenerInformacionDeClase(id_clase);
		try{
			connectionManager.connect();
			String str = "DELETE FROM PRACTICAS WHERE id_clase ="+ id_clase ;
			connectionManager.updateDB(str);
			

			
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el Practicas: "+e.getLocalizedMessage() );
		}
		new ActividadDAOImp().eliminarActividad(clas.getId_actividad());
	}

	

	@Override
	public Clase crearClase(Clase clase) {
	
		return null;
	}

	@Override
	public void editarClase(Clase clase) {
		// TODO Auto-generated method stub

	}

}
