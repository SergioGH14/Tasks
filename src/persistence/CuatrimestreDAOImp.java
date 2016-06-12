package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import bussines.Cuatrimestre;
import persistence.dao.CuatrimestreDAO;

public class CuatrimestreDAOImp implements CuatrimestreDAO{
	protected ConnectionManager connectionManager;
	
	public CuatrimestreDAOImp(){
		try{
			System.out.println("\n\t######## CuatrimestreDAOImp ########  ");
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, CautrimestreDAO: "+e.getLocalizedMessage());
		}
	}
	@Override
	public Cuatrimestre obtenerInformacionCuatrimestre(int id_cuatrimestre) {
		Cuatrimestre cuatri = null;
		try{
			connectionManager.connect();
			ResultSet cuatrimestreResultSet = connectionManager.queryDB("SELECT * from CUATRIMESTRE where id_cuatrimestre = '"+id_cuatrimestre+"'");
			connectionManager.close();

			if (cuatrimestreResultSet.next()){
				cuatri = new Cuatrimestre(cuatrimestreResultSet.getInt("ID_CUATRIMESTRE"),
						new CursoDAOImp().obtenerInformacionCurso(cuatrimestreResultSet.getInt("ID_CURSO")),
						cuatrimestreResultSet.getInt("CUATRIMESTRE"));
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar el cuatrimestre: "+e.getLocalizedMessage() );
		}
		return cuatri;
	}

	@Override
	public void eliminarCuatrimestre(int id_cuatrimestre) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM CUATRIMESTRE WHERE id_cuatrimestre="+ id_cuatrimestre ;
			connectionManager.updateDB(str);


			System.out.println("\nCuatrimestre eliminado con éxito: ");
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el cuatrimestre: "+e.getLocalizedMessage() );
		}
		
	}

	@Override
	public Cuatrimestre crearCuatrimestre(Cuatrimestre cuatrimestre) {
		Cuatrimestre cuatri = cuatrimestre;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.CUATRIMESTRE_SQ);
			if(id>0){
				String str = "INSERT INTO CUATRIMESTRE (ID_CUATRIMESTRE, ID_CURSO, CUATRIMESTRE) " +
							 "VALUES ("+
							 id+","+
							 cuatri.getCurso().getId_curso()+","+
							 cuatri.getCuatrimestre() +")";
				if(cuatri!=null)
					cuatri.setId_cuatrimestre(id);
				
				connectionManager.updateDB(str);
				System.out.println("\nCuatrimestre creado con éxito: " + cuatri);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el cuatrimestre: "+e.getLocalizedMessage() );
		}
		return cuatri;
	}

	@Override
	public void editarCuatrimestre(Cuatrimestre cuatrimestre) {
		try{
			connectionManager.connect();
			String str = "UPDATE CUATRIMESTRE "+
						 "SET id_cuatrimestre= "+cuatrimestre.getId_cuatrimestre()+", "+
						 "SET id_curso= "+cuatrimestre.getCurso().getId_curso() +", "+
						 "SET cuatrimestre= "+cuatrimestre.getCuatrimestre() +
						 " WHERE id_cuatrimestre=" + cuatrimestre.getId_cuatrimestre() +")";
			connectionManager.updateDB(str);
			System.out.println("\nCuatrimestre editado con éxito: " + cuatrimestre);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar el cuatrimestre: "+e.getLocalizedMessage() );
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
