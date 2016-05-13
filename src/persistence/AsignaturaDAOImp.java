package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.Basics;
import Util.Constantes;
import bussines.Asignatura;
import persistence.dao.AsignaturaDAO;

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
	public Asignatura obtenerInformacionAsignatura(String nombreAsignatura) {
		Asignatura asignatura = null;
		try{
			connectionManager.connect();
			ResultSet asignaturaResultSet = connectionManager.queryDB("SELECT * from ASIGNATURA where titulo = '"+nombreAsignatura+"'");
			connectionManager.close();
			
			if(asignaturaResultSet.next()){
				asignatura = new Asignatura(asignaturaResultSet.getInt("ID_ASIGNATURA"), 
											new CuatrimestreDAOImp().obtenerInformacionCuatrimestre(asignaturaResultSet.getInt("ID_CUATRIMESTRE")), 
											asignaturaResultSet.getString("TITULO"), asignaturaResultSet.getDouble("CREDITOS"),
											asignaturaResultSet.getInt("DIFICULTAD"), asignaturaResultSet.getBoolean("ANUAL"), 
											Basics.HexToColor(asignaturaResultSet.getString("COLOR")));
			}

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar la asignatura: "+e.getLocalizedMessage() );
		}
		return asignatura;
	}


	@Override
	public List<Asignatura> obtenerAsignaturasPorCuatrimestre(int cuatrimestre) {
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		try{
			connectionManager.connect();
			ResultSet asignaturaResultSet = connectionManager.queryDB("SELECT * from ASIGNATURA where id_cuatrimestre = '"+cuatrimestre+"'");
			connectionManager.close();
			
			while(asignaturaResultSet.next()){
				listaAsignaturas.add(new Asignatura(asignaturaResultSet.getInt("ID_ASIGNATURA"), 
											new CuatrimestreDAOImp().obtenerInformacionCuatrimestre(asignaturaResultSet.getInt("ID_CUATRIMESTRE")), 
											asignaturaResultSet.getString("TITULO"), asignaturaResultSet.getDouble("CREDITOS"),
											asignaturaResultSet.getInt("DIFICULTAD"), asignaturaResultSet.getBoolean("ANUAL"), 
											Basics.HexToColor(asignaturaResultSet.getString("COLOR"))) );
			}
			
		}catch (Exception e){
			System.err.println("\nError al recuperar las asignaturas del :" + cuatrimestre + " cuatrimestre: " + e.getLocalizedMessage());
		}
		return listaAsignaturas;
	}


	@Override
	public Asignatura crearAsignatura(Asignatura asignatura) {
		Asignatura asignaturaAux = asignatura;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.ASIGNATURA_SQ);
			if(id>0){
				String str = "INSERT INTO ASIGNATURA (ID_ASIGNATURA, ID_CUATRIMESTRE, TITULO, CREDITOS, DIFICULTAD, ANUAL, COLOR) " +
							 "VALUES ("+
							 id+","+
							 asignaturaAux.getCuatrimestre().getId_cuatrimestre()+",'"+
							 asignaturaAux.getTitulo().toUpperCase() +"',"+
							 asignaturaAux.getCreditos() +","+
							 asignaturaAux.getDificultad() + ","+
							 asignaturaAux.isAnual() + ",'"+
							 Basics.RGBToHex(asignaturaAux.getColor())+
							 "')";
				
				if(asignaturaAux!=null)
					asignaturaAux.setId_asignatura(id);
				
				connectionManager.updateDB(str);
				System.out.println("\nAsignatura creada con éxito: " + asignaturaAux);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear la asignatura: "+e.getLocalizedMessage() );
		}
		return asignaturaAux;
	}


	@Override
	public void editarAsignatura(Asignatura asignatura) {
		try{
			connectionManager.connect();
			String str = "UPDATE ASIGNATURA "+
						 "SET id_asignatura= "+asignatura.getId_asignatura()+", "+
						 "SET id_cuatrimestre= "+asignatura.getCuatrimestre().getId_cuatrimestre()+", "+
						 "SET titulo= '"+asignatura.getTitulo() +"', "+
						 "SET creditos= "+asignatura.getCreditos() + ", " +
						 "SET dificultad= "+asignatura.getDificultad() + ", " +
						 "SET anual= "+asignatura.isAnual() + ", " +
						 "SET color= '"+Basics.RGBToHex(asignatura.getColor()) +"'"+
						 " WHERE id_cuatrimestre=" + asignatura.getId_asignatura() +")";
			
			connectionManager.updateDB(str);
			System.out.println("\nAsignatura editada con éxito: " + asignatura);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar la asignatura: "+e.getLocalizedMessage() );
		}
	}

	
	@Override
	public boolean existeAsignatura(String nombreAsignatura) {
		boolean existe = false;
		try{
			connectionManager.connect();
			ResultSet asignaturaResultSet = connectionManager.queryDB("SELECT count(*) from ASIGNATURA WHERE titulo = '" +nombreAsignatura.toUpperCase()+ "'");
			connectionManager.close();

			if (asignaturaResultSet.next()){
				 int x= asignaturaResultSet.getInt(1);
				 if(x>0){
					 existe = true;
				 }
				 System.out.println("Existen: " + x + " asignaturas con el mismo nombre: " + nombreAsignatura);
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar la asignatura repetida: "+e.getLocalizedMessage() );
		}
		return existe;
	}
	
	@Override
	public void eliminarAsignatura(int id_asignatura){
		try{
			connectionManager.connect();
			String str = "DELETE FROM ASIGNATURA WHERE id_asignatura="+ id_asignatura ;
			connectionManager.updateDB(str);


			System.out.println("\nAsignatura eliminada con éxito: ");
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar la asignatura: "+e.getLocalizedMessage() );
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
