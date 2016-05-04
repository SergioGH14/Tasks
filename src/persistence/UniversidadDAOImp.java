package persistence;

import java.sql.ResultSet;

import bussines.Universidad;
import bussines.Usuario;
import persistence.dao.UniversidadDAO;
import util.Constantes;
import util.Date_Solver;

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
			ResultSet universidad = connectionManager.queryDB("SELECT * from UNIVERSIDAD where id_universidad = '"+id_universidad+"'");
			connectionManager.close();
		
			if (universidad.next()){
				uni = new Universidad(
						universidad.getInt("ID_UNIVERSIDAD"),
						universidad.getString("NOMBRE"),
						universidad.getString("LOGO"),
						universidad.getString("DIRECCION")
							);
				//saber cuantos caracteres tiene un atributo
				System.out.println("El usuario tiene de  nombre:" + uni.getNombre()+" y contiene: " + uni.getNombre().toCharArray().length + " caracteres");
			}else
				return null;	
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar al usuario: "+e.getLocalizedMessage() );
		}
		return uni;
	}
		
	@Override
	public void crearUniversidad(Universidad universidad) {
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.UNIVERSIDAD_SQ);
				String str = "INSERT INTO UNIVERSIDAD (ID_UNIVERSIDAD, NOMBRE, LOGO, DIRECCION) " + 
							 "VALUES ("+
							 id+","+
							 universidad.getNombre()+",'"+
							 universidad.getLogo() +"','"+
							 universidad.getDireccion() +"','"+
							 
							 ")";
	
				universidad.setId_universidad(id);
				connectionManager.updateDB(str);
				System.out.println("Usuario creado con éxito: " + universidad);
			
			connectionManager.close();
		}catch(	Exception e){
			System.err.println("Ha ocurrido un error al crear el universidad: "+e.getLocalizedMessage() );
		}
	}
	
	public int crearSecuencia(String nombreSecuencia){
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
	public void eliminarUniversidad(int id_universidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarUniversiad(Universidad universidad) {
		// TODO Auto-generated method stub
		
	}

}
