package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import Util.Date_solver;
import bussines.Actividad;
import persistence.dao.ActividadDAO;

public class ActividadDAOImp implements ActividadDAO {

protected ConnectionManager connectionManager;
	
	public ActividadDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ActividadDAOImp: "+e.getLocalizedMessage());
		}
	}
	
	@Override
	public Actividad obtenerInformacionDeActividad(int id_actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarActividad(int id_actividad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actividad crearActividad(Actividad actividad) {
		Actividad actAux = actividad;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.ACTIVIDAD_SQ);
			if(id>0){
				String str = "INSERT INTO ACTIVIDAD (ID_ACTIVIDAD, ID_ASIGNATURA, TITULO,"
						+ " DESCRIPCION, FECHA_FINALIZACION, FINALIZADA, "
						+ "TIEMPO_ESTIMADO, PORCENTAJE, PRIORIDAD_U, PRIORIDAD_T)"
						
						+" VALUES ("
						+id+","
						+actividad.getAsignatura().getId_asignatura()+",'"
					    +actividad.getTitulo()+"','"
					    +actividad.getDescripcion()+"','"
						+Date_solver.convertirLocalDateEnSQL(actividad.getFechafinalizacion())+"',"
						+actividad.isFinalizada()+","
						+actividad.getTiempoestimado()+","
						+actividad.getPorcentaje()+","
						+actividad.getPrioridadusuario()+","
						+actividad.getPrioridadtotal()
						+")";
						
				if(actAux!=null)
					actAux.setId_actividad(id);
				
				connectionManager.updateDB(str);
				System.out.println("\nActividad  creado con éxito: " + actAux);
			}
			connectionManager.close();
		}catch(Exception e){
			System.err.println("No se ha podido crear la actividad: " + e.getLocalizedMessage());
		}
		return actAux;
	}

	@Override
	public void editarActividad(Actividad actividad) {
		// TODO Auto-generated method stub
		
	}
	
	private int crearSecuencia(String nombreSecuencia){
		try{
		ResultSet sq = connectionManager.queryDB("CALL NEXT VALUE FOR " + nombreSecuencia);

		if (sq.next())
			return sq.getInt(1);

		}catch(Exception e){
		   System.err.println("Ha ocurrido un error al generar la secuencia de id "+e.getLocalizedMessage());
		}
		return -1;

	}

}
