package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Util.Constantes;
import Util.Date_solver;
import bussines.Actividad;
import bussines.Notificacion;
import persistence.dao.NotificacionDAO;

public class NotificacionDAOImp implements NotificacionDAO {

	protected ConnectionManager connectionManager;
	
	public NotificacionDAOImp(){
		try{
			System.out.println("\n\t######## NotificacionDAOImp ########  ");
			connectionManager= new ConnectionManager(Constantes.DATABASE);

		}catch(Exception e){
			System.err.println("Error en persistencia, NOTIFICACIONDAOIMP: "+e.getLocalizedMessage());

		}

	}
	
	@Override
	public Notificacion obtenerInformacionDeNotificacion(int id_Notificacion) {
		Notificacion notificacion = null;
		try{
			connectionManager.connect();
			ResultSet notificacion_resultSet = connectionManager.queryDB("SELECT * from NOTIFICACION N, ACTIVIDAD A where A.id_actividad = N.id_actividad AND N.id_notificacion = '"+id_Notificacion+"' AND A.para_despues = FALSE AND A.finalizada = FALSE");
			connectionManager.close();
			
			if (notificacion_resultSet.next()){
				notificacion = new Notificacion(
						notificacion_resultSet.getInt("ID_NOTIFICACION"),
				        notificacion_resultSet.getInt("ID_ACTIVIDAD"),
				        notificacion_resultSet.getString("TITULO"),
				        notificacion_resultSet.getString("COLOR"),
						notificacion_resultSet.getString("DESCRIPCION"),
						notificacion_resultSet.getInt("PRIORIDAD") ,
						Date_solver.convertirDateSQLEnLocalDateTime(notificacion_resultSet.getDate("FECHA_NOTIFICAR"))
						);
			}
					
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar la notificacion: "+e.getLocalizedMessage() );
		}
		return notificacion;
	
	}

	@Override
	public void eliminarNotificacion(int id_Notificacion) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM NOTIFICACION WHERE id_usuario="+id_Notificacion ;
			connectionManager.updateDB(str);


			System.out.println("\nNotificacion eliminado con éxito: ");
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el notificacion: "+e.getLocalizedMessage() );
		}



	}

	@Override
	public Notificacion crearNotificacion(Notificacion notificacion) {
		Notificacion noti = notificacion;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.NOTIFICACION_SQ);
			if(id>0){
				String str = "INSERT INTO NOTIFICACION (ID_NOTIFICACION, ID_ACTIVIDAD,TITULO,COLOR,DESCRIPCION, FECHA_NOTIFICAR, PRIORIDAD) " +
							 "VALUES ("+id+","+
							 			noti.getId_actividad()+",'"+
							 			noti.getTitulo()+"','"+
							 			noti.getColor() + "','"+
							 			noti.getDescripcion()+"','"+
							 			Date_solver.convertirLocalDateEnSQL(noti.getFecha_notificacion())+"',"+
							 			noti.getPrioridad()+")";

				if(noti!=null){
					noti.setId_notificacion(id);
				}
				connectionManager.updateDB(str);
				System.out.println("\nNotificacion creado con éxito: " + noti);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el Notificacion: "+e.getLocalizedMessage() );
		}
		return noti;
	}

	
	public void editarNotificacion(Notificacion notificacion) {
		try{
			connectionManager.connect();
			String str = "UPDATE USUARIO "+
						 "SET id_notificacion= "+notificacion.getId_notificacion()+", "+
						 "SET id_actividad= "+notificacion.getId_actividad()+", "+
						 "SET titulo= '"+notificacion.getTitulo()+"',"+ 
						 "SET color= '"+notificacion.getColor()+"',"+ 
						 "SET descripcion= '"+notificacion.getDescripcion() +"', "+
						 "SET fecha_notificar= '"+ Date_solver.convertirLocalDateEnSQL(notificacion.getFecha_notificacion())+"', "+
						 "SET prioridad= "+notificacion.getPrioridad()+")";
			connectionManager.updateDB(str);
			System.out.println("\nnotificacion editado con éxito: " + notificacion);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar el notificacion: "+e.getLocalizedMessage() );
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

	public List<Notificacion> obtenerNotificacionesDeHoy () {
		List<Notificacion> listanotificaciones = new ArrayList<Notificacion>();
		Date a =  Date_solver.convertirLocalDateEnSQL( Date_solver.fechaDeHoy());
		try{
			connectionManager.connect();
			ResultSet notificacionResultSet = connectionManager.queryDB("select * from NOTIFICACION N, ACTIVIDAD A where A.id_actividad = N.id_actividad AND N.fecha_notificar  ='"+a+"' AND A.para_despues = FALSE AND A.finalizada = FALSE");
			connectionManager.close();
			while(notificacionResultSet.next()){
				listanotificaciones.add(new Notificacion(notificacionResultSet.getInt("ID_NOTIFICACION"),
														 notificacionResultSet.getInt("ID_ACTIVIDAD"),
														 notificacionResultSet.getString("TITULO"),
														 notificacionResultSet.getString("COLOR"),
												     	 notificacionResultSet.getString("DESCRIPCION"),
													     notificacionResultSet.getInt("PRIORIDAD"),
													     Date_solver.convertirDateSQLEnLocalDateTime(notificacionResultSet.getDate("FECHA_NOTIFICAR"))));
			}
			System.out.println("Se han cargado las notificaciones de hoy");
			
		}catch (Exception e){
			System.err.println("\nError al recuperar las notificaciones de hoy: " + e.getLocalizedMessage());
		}
		return listanotificaciones;
	}

}
