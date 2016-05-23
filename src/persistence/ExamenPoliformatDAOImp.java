package persistence;

import java.sql.ResultSet;
import java.util.List;

import Util.Constantes;
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
import persistence.dao.ExamenPoliformatDAO;

public class ExamenPoliformatDAOImp implements ExamenPoliformatDAO {
	protected ConnectionManager connectionManager;

	public ExamenPoliformatDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ExamenPoliformatDAOImp: "+e.getLocalizedMessage());
		}
	}
	
	@Override
	public Examen_Poliformat obtenerInformacionDeExamenPoliformat(int id_examen_concreto) {
		Examen_Poliformat examen_poli = null;		
		try{
			connectionManager.connect();
			ResultSet examen_practicas_resultset = connectionManager.queryDB("SELECT * FROM EXAMEN_POLIFORMAT WHERE id_examen='"+ id_examen_concreto+"'");
			connectionManager.close();
			Examen examenaux = new ExamenDAOImp().obtenerInformacionDeExamen(id_examen_concreto);
			if(examen_practicas_resultset.next()){
				examen_poli = new Examen_Poliformat(examen_practicas_resultset.getInt("ID_EXAMEN_POLIFORMAT"),
						examenaux,
						examen_practicas_resultset.getBoolean("REINTENTABLE"));
				
				examen_poli.setId_actividad(examenaux.getId_actividad());
				examen_poli.setId_examen(examenaux.getId_examen());
				examen_poli.setPrioridadtotal(examenaux.getPrioridadtotal());
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar el examen_poliformat: "+e.getLocalizedMessage() );
		}
		return examen_poli;
	}

	@Override
	public void eliminarExamenPoliformat(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Examen_Poliformat crearExamenPoliformat( Examen_Poliformat ExamenPoliformat) {
		Examen_Poliformat examenPoliAux = ExamenPoliformat;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.EXAMEN_POLIFORMAT_SQ);
			if(id>0){
				int examen_id = new ExamenDAOImp().crearExamen((Actividad_Examen)examenPoliAux.getExamen()).getId_examen();
				String str = "INSERT INTO EXAMEN_POLIFORMAT (ID_EXAMEN_POLIFORMAT, ID_EXAMEN, REINTENTABLE) " +
							 "VALUES (" 
							 +id+","
							 +examen_id+"," 
							 +examenPoliAux.isReintentable()
							 +")";
				
					if(examenPoliAux!=null){
						examenPoliAux.setId_examen_poliformat(id);
						examenPoliAux.setId_examen(examen_id);
					}
					connectionManager.updateDB(str);
					System.out.println("\nExamen_Poliformat creado con éxito: " + examenPoliAux + " y el id: de su examen es : " + examenPoliAux.getId_examen());
				}
				connectionManager.close();
		
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el examen_poliformat: "+e.getLocalizedMessage() );
		}
		return examenPoliAux;
		
	}

	@Override
	public void editarExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
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

	@Override
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actividad> obtenerTodasActividades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actividad> obtenerActividadesHoy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actividad> obtenerActividadesParaDespues() {
		// TODO Auto-generated method stub
		return null;
	}


}
