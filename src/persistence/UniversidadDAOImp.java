package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import bussines.Universidad;
import persistence.dao.UniversidadDAO;

public class UniversidadDAOImp implements UniversidadDAO{
	
	protected ConnectionManager connectionManager;
	
	public UniversidadDAOImp() {
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);

		}catch(Exception e){
			System.err.println("Error en persistencia, UniversidadDAOImp: "+e.getLocalizedMessage());

		}

	}

	@Override
	public Universidad obtenerInformacionDeUniversidad(int id_universidad) {
		Universidad uni = null;
		try{
			connectionManager.connect();
			ResultSet universidad = connectionManager.queryDB("SELECT * from UNIVERSIDAD where id_universidad = "+id_universidad);
			connectionManager.close();
		
			if (universidad.next()){
				uni = new Universidad(
						universidad.getInt("ID_UNIVERSIDAD"),
						universidad.getString("NOMBRE"),
						universidad.getString("LOGO"),
						universidad.getString("DIRECCION") );
			}else
				return null;	
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar al la universidad: "+e.getLocalizedMessage() );
		}
		return uni;
	}
		
	@Override
	public Universidad crearUniversidad(Universidad universidad) {
		Universidad uniAux = universidad;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.UNIVERSIDAD_SQ);
				String str = "INSERT INTO UNIVERSIDAD (ID_UNIVERSIDAD, NOMBRE, LOGO, DIRECCION) " + 
							 "VALUES ("+
							 id+",'"+
							 universidad.getNombre()+"','"+
							 universidad.getLogo() +"','"+
							 universidad.getDireccion() +"')";
	
				if(uniAux!=null){
					uniAux.setId_universidad(id);
				}
				connectionManager.updateDB(str);
				System.out.println("\nUniversidad creada con éxito: " + universidad);
			
			connectionManager.close();
		}catch(	Exception e){
			System.err.println("Ha ocurrido un error al crear la universidad: "+e.getLocalizedMessage() );
		}
		return uniAux;
	}
	

	@Override
	public void eliminarUniversidad(int id_universidad) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM UNIVERSIDAD WHERE id_universidad="+ id_universidad ;
			connectionManager.updateDB(str);
			
		
			System.out.println("\nUniversidad eliminada con éxito: ");
			connectionManager.close();
			
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el universidad: "+e.getLocalizedMessage() );
		}
		
	}

	@Override
	public void editarUniversiad(Universidad universidad) {
		try{
			connectionManager.connect();
			String str = "UPDATE UNIVERSIDAD "+
						 "SET id_universidad= "+universidad.getId_universidad()+", "+
						 "SET nombre= '"+universidad.getNombre()+"', "+
						 "SET logo= '"+universidad.getLogo()+"', "+
						 "SET direccion= '"+ universidad.getDireccion() +"' "+
						 " WHERE id_universidad=" + universidad.getId_universidad() +")";
			connectionManager.updateDB(str);
			System.out.println("\nUniversidad editada con éxito: " + universidad);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar la universidad: "+e.getLocalizedMessage() );
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
