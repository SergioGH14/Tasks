package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Util.Basics;
import Util.Constantes;
import Util.Date_solver;
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Clase;
import bussines.Cuatrimestre;
import bussines.Examen;
import bussines.Examen_Clase;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
import bussines.Practicas;
import persistence.dao.ActividadDAO;
import persistence.dto.ActividadDTO;

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
	public ActividadDTO obtenerInformacionDeActividad(int id_actividad) {
		ActividadDTO actividadAux = null;
		try{
			connectionManager.connect();
			ResultSet actividadResultSet = connectionManager.queryDB("SELECT * from ACTIVIDAD where id_actividad = '"+id_actividad+"'");
			connectionManager.close();

			if (actividadResultSet.next()){
				actividadAux = new ActividadDTO(
						actividadResultSet.getInt("ID_ACTIVIDAD"),
						new AsignaturaDAOImp().obtenerInformacionAsignatura(actividadResultSet.getInt("ID_ASIGNATURA")).getTitulo(),
						actividadResultSet.getString("TITULO"),
						actividadResultSet.getString("DESCRIPCION"),
						Date_solver.convertirDateSQLEnLocalDateTime( actividadResultSet.getDate("FECHA_FINALIZACION")),
						actividadResultSet.getInt("TIEMPO_ESTIMADO"),
						actividadResultSet.getDouble("PORCENTAJE"),
						actividadResultSet.getInt("PRIORIDAD_U"),
						actividadResultSet.getInt("PRIORIDAD_T"),
						actividadResultSet.getBoolean("FINALIZADA"),
						actividadResultSet.getBoolean("PARA_DESPUES")
						);
			}
			System.out.println("Actividad recuperada con éxito, id: " + actividadAux.getId_actividad());
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar la actividad: "+e.getLocalizedMessage() );
		}
		return actividadAux;
	}
	

	@Override
	public ActividadDTO obtenerInformacionDeActividadExamen(int id_actividad_examen) {
		ActividadDTO actividadAux = null;
		try{
			connectionManager.connect();
			ResultSet actividadResultSet = connectionManager.queryDB("SELECT * from ACTIVIDAD A , EXAMEN E where A.id_actividad=E.id_actividad AND E.id_examen = '"+id_actividad_examen+"'");
			connectionManager.close();

			if (actividadResultSet.next()){
				actividadAux = new ActividadDTO(
						actividadResultSet.getInt("ID_ACTIVIDAD"),
						new AsignaturaDAOImp().obtenerInformacionAsignatura(actividadResultSet.getInt("ID_ASIGNATURA")).getTitulo(),
						actividadResultSet.getString("TITULO"),
						actividadResultSet.getString("DESCRIPCION"),
						Date_solver.convertirDateSQLEnLocalDateTime( actividadResultSet.getDate("FECHA_FINALIZACION")),
						actividadResultSet.getInt("TIEMPO_ESTIMADO"),
						actividadResultSet.getDouble("PORCENTAJE"),
						actividadResultSet.getInt("PRIORIDAD_U"),
						actividadResultSet.getInt("PRIORIDAD_T"),
						actividadResultSet.getBoolean("FINALIZADA"),
						actividadResultSet.getBoolean("PARA_DESPUES")
						);
			}
			System.out.println("Actividad_Examen recuperada con éxito, id: " + actividadAux.getId_actividad());
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar la actividad_examen: "+e.getLocalizedMessage() );
		}
		return actividadAux;
	}

	@Override
	public void eliminarActividad(int id_actividad) {
		try{
			connectionManager.connect();
			String act = "DELETE FROM ACTIVIDAD WHERE id_actividad ='"+ id_actividad+"'" ;
			String clase = "DELETE FROM CLASE WHERE id_actividad ='"+ id_actividad+"'" ;
			String pract = "DELETE FROM PRACTICAS WHERE id_actividad ='"+ id_actividad+"'" ;
			String notf = "DELETE FROM NOTIFICACION WHERE id_actividad ='"+ id_actividad+"'" ;

			connectionManager.updateDB(notf);
			connectionManager.updateDB(pract);
			connectionManager.updateDB(clase);
			
			//Capturar excepcion si es un examen para llamar a los delete del examen
			try{
				String ex = "DELETE FROM EXAMEN WHERE id_actividad = '" + id_actividad+"'";
				connectionManager.updateDB(ex);
			}catch(Exception ex){
				System.err.println("Era un examen, se borrará en cascada...");
			}
			
			
			connectionManager.updateDB(act);
			
			connectionManager.close();
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar la actividad: "+e.getLocalizedMessage() );
		}

	}

	@Override
	public Actividad crearActividad(Actividad actividad) {
		Actividad actAux = actividad;
		System.err.println("Prioridad total: " + actAux.getPrioridadTotal() + " prioridad usuario: " +actAux.getPrioridadusuario());

		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.ACTIVIDAD_SQ);
			if(id>0){
				String str = "INSERT INTO ACTIVIDAD (ID_ACTIVIDAD, ID_ASIGNATURA, TITULO,"
						+ " DESCRIPCION, FECHA_FINALIZACION, FINALIZADA, "
						+ "TIEMPO_ESTIMADO, PORCENTAJE, PRIORIDAD_U, PRIORIDAD_T, PARA_DESPUES)"
						
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
						+actividad.getPrioridadtotal()+","
						+actividad.isPara_despues()
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
	public void editarActividad(ActividadDTO actividad) {
		try{
			System.err.println("La actividad en cuestion: "+actividad);
			connectionManager.connect();
			String str = "UPDATE ACTIVIDAD SET (titulo, descripcion, fecha_finalizacion, tiempo_estimado, porcentaje, prioridad_u, prioridad_t)="
					+ "("
					+"'"+actividad.getTitulo() +"',"
					+"'"+actividad.getDescripcion() +"',"
					+"'"+Date_solver.convertirLocalDateEnSQL(actividad.getFechaFinalizacion())+"',"
					+"'"+actividad.getTiempoEstimado()+"',"
					+"'"+actividad.getPorcentaje()+"',"
					+"'"+actividad.getPrioridadUsuario()+"',"
					+"'"+actividad.getPrioridadTotal()+"'"+
					 ") WHERE id_actividad =" + actividad.getId_actividad();
			connectionManager.updateDB(str);
			
			//actualizar notifiaciones asociadas
			String strnotiManana = "UPDATE NOTIFICACION SET (FECHA_NOTIFICAR, TITULO)=('"
			+Date_solver.convertirLocalDateEnSQL(Date_solver.restar(1,actividad.getFechaFinalizacion()))+"', '"+actividad.getTitulo()+ " mañana"+ "') "
			+ "WHERE id_actividad = "+actividad.getId_actividad()
			+ " AND TITULO LIKE '%mañana%' ";
			connectionManager.updateDB(strnotiManana);
			
			String str7dias = "UPDATE NOTIFICACION SET (FECHA_NOTIFICAR, TITULO)=('"
					+Date_solver.convertirLocalDateEnSQL(Date_solver.restar(7,actividad.getFechaFinalizacion()))+"', '"+actividad.getTitulo()+ " en 7 días"+ "') "
					+ "WHERE id_actividad = "+actividad.getId_actividad()
					+ " AND TITULO LIKE '%en 7%' ";
			connectionManager.updateDB(str7dias);
					
			String str14dias = "UPDATE NOTIFICACION SET (FECHA_NOTIFICAR, TITULO)=('"
					+Date_solver.convertirLocalDateEnSQL(Date_solver.restar(14,actividad.getFechaFinalizacion()))+"', '"+actividad.getTitulo()+ " en 14 días"+ "') "
					+ "WHERE id_actividad = "+actividad.getId_actividad()
					+ " AND TITULO LIKE '%en 14%' ";
			connectionManager.updateDB(str14dias);
			
			System.err.println("\nActividad editada con éxito: " + actividad.getId_actividad());
			connectionManager.close();
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar la actividad: "+e.getLocalizedMessage() );
		}
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
	@Override
	public void marcarComoHecha(int id_actividad) {
		try{
			connectionManager.connect();
			String str = "UPDATE ACTIVIDAD SET (finalizada)="
					+ "("+true+
					 ") WHERE id_actividad = '" + id_actividad +"'";
			connectionManager.updateDB(str);
			System.out.println("\nActividad finalizada con éxito: " + id_actividad);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al finalizar la actividad: "+e.getLocalizedMessage() );
		}
	}

	@Override
	public void marcarParaDespues(int id_actividad) {
		try{
			connectionManager.connect();
			String str = "UPDATE ACTIVIDAD SET (para_despues)="
					+ "("+true+
					 ") WHERE id_actividad = '" + id_actividad +"'";
			connectionManager.updateDB(str);
			System.out.println("\nActividad marcada para despues con éxito: " + id_actividad);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al marcar para despues la actividad: "+e.getLocalizedMessage() );
		}
	}

}
