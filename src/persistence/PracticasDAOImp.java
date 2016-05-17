package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import bussines.Practicas;
import persistence.dao.PracticasDAO;

public class PracticasDAOImp implements PracticasDAO {
	protected ConnectionManager connectionManager;

	public PracticasDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, PracticasDAOImp: "+e.getLocalizedMessage());
		}
	}
	
	@Override
	public Practicas obtenerInformacionDePracticas(int id_Practicas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPracticas(int id_Practicas) {
		// TODO Auto-generated method stub

	}

	@Override
	public Practicas crearPracticas(Practicas practicas) {
		Practicas practicasAux = practicas;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.PRACTICAS_SQ);
			if(id>0){
				String str = "INSERT INTO PRACTICAS (ID_PRACTICAS, ID_ACTIVIDAD, GRUPAL, RECUPERABLE) " +
							 "VALUES ("
							 +id+","
							 +new ActividadDAOImp().crearActividad(practicas).getId_actividad()+","
							 +practicas.isGrupal()+","
							 +practicas.isRecuperable()
							 +")";
				
				if(practicasAux!=null)
					practicasAux.setId_practicas(id);
				
				connectionManager.updateDB(str);
				System.out.println("\nPracticas creadas con éxito: " + practicasAux);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear la práctica: "+e.getLocalizedMessage() );
		}
		
		return practicasAux;
	}

	@Override
	public void editarPracticas(Practicas Practicas) {
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
