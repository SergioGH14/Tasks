package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import Util.Date_solver;
import bussines.Grado;
import persistence.dao.GradoDAO;

public class GradoDAOImp implements GradoDAO{
	protected ConnectionManager connectionManager;
	
	public GradoDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, GradoDAOImp: "+e.getLocalizedMessage());

		}
	}

	@Override
	public Grado obtenerInformacionGrado(int id_grado) {
		Grado grado = null;
		try{
			connectionManager.connect();
			ResultSet grado_resultset = connectionManager.queryDB("SELECT * from GRADO where id_grado ="+id_grado);
			connectionManager.close();

			if (grado_resultset.next()){
				grado = new Grado(
						grado_resultset.getInt("ID_GRADO"),
						new UniversidadDAOImp().obtenerInformacionDeUniversidad(grado_resultset.getInt("ID_UNIVERSIDAD")),
						grado_resultset.getString("TITULACION"),
						Date_solver.convertirDateSQLEnLocalDateTime( grado_resultset.getDate("ANYO_INICIO")));
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar el grado: "+e.getLocalizedMessage() );
		}
		return grado;
	}
	
	@Override
	public Grado crearGrado(Grado grado) {
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.GRADO_SQ);
			if(id>0){
				String str = "INSERT INTO GRADO (ID_GRADO, ID_UNIVERSIDAD, TITULACION, ANYO_INICIO) " +
							 "VALUES ("+
							 id+","+
							 grado.getUniversidad().getId_universidad()+",'"+
							 grado.getTitulacion() +"','"+
							 Date_solver.convertirLocalDateEnSQL(grado.getAnyoinicio())+"')";

				grado.setId_grado(id);
				connectionManager.updateDB(str);
				System.out.println("\nGrado creado con éxito: " + grado);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el grado: "+e.getLocalizedMessage() );
		}
		return grado;

	}

	@Override
	public void eliminarGrado(int id_grado) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM GRADO WHERE id_grado="+ id_grado ;
			connectionManager.updateDB(str);


			System.out.println("\nGrado eliminado con éxito: ");
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el grado: "+e.getLocalizedMessage() );
		}
		
	}

	@Override
	public void editarGrado(Grado grado) {
		try{
			connectionManager.connect();
			String str = "UPDATE GRADO "+
						 "SET id_universidad= "+grado.getUniversidad().getId_universidad()+", "+
						 "SET id_grado= '"+grado.getId_grado() +"', "+
						 "SET titulacion= '"+grado.getTitulacion() +"', "+
						 "SET anyo_inicio= '"+Date_solver.convertirLocalDateEnSQL(grado.getAnyoinicio())+"' "+
						 " WHERE id_grado=" + grado.getId_grado() +")";
			connectionManager.updateDB(str);
			System.out.println("\nGrado editado con éxito: " + grado);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar el grado: "+e.getLocalizedMessage() );
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


}
