package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.Constantes;
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
import persistence.dao.ExamenPracticasDAO;

public class ExamenPracticasDAOImp implements ExamenPracticasDAO {
	protected ConnectionManager connectionManager;

	public ExamenPracticasDAOImp(){
		try{
			System.out.println("\n\t######## ExamenPracticasDAOImp ########  ");
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ExamenPracticasDAOImp: "+e.getLocalizedMessage());
		}
	}
	
	@Override
	public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id_examen_concreto) {
		Examen_Practicas examen_practicas = null;
		
		try{
			connectionManager.connect();
			ResultSet examen_practicas_resultset = connectionManager.queryDB("SELECT * FROM EXAMEN_PRACTICAS WHERE id_examen='"+ id_examen_concreto+"'");
			connectionManager.close();
			Actividad_Examen examenaux = (Actividad_Examen)new ExamenDAOImp().obtenerInformacionDeExamenSinDecoracion(id_examen_concreto);
			if(examen_practicas_resultset.next()){
				examen_practicas = new Examen_Practicas(examen_practicas_resultset.getInt("ID_EXAMEN_PRACTICAS"),
						examenaux,
						examen_practicas_resultset.getBoolean("APUNTES"));
				
				examen_practicas.setId_actividad(examenaux.getId_actividad());
				examen_practicas.setId_examen(examenaux.getId_examen());
				examen_practicas.setPrioridadTotal(examenaux.getPrioridadtotal());

			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar el examen_practicas: "+e.getLocalizedMessage() );
		}
				
		return examen_practicas;
	}

	@Override
	public void eliminarExamen_Practicas(int id_examen) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM EXAMEN_PRACTICAS WHERE id_examen ='"+ id_examen+"'" ;
			connectionManager.updateDB(str);
			connectionManager.close();
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el Examen-Practicas: "+e.getLocalizedMessage() );
		}

	}

	@Override
	public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas) {
		Examen_Practicas examenPracticasAux = examenPracticas;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.EXAMEN_PRACTICA_SQ);
			if(id>0){
				Actividad_Examen examenBase =  (Actividad_Examen) new ExamenDAOImp().crearExamen((Actividad_Examen)examenPracticasAux.getExamen());
				int id_actividad = examenBase.getId_actividad();
				int examen_id = examenBase.getId_examen();
				String str = "INSERT INTO EXAMEN_PRACTICAS (ID_EXAMEN_PRACTICAS, ID_EXAMEN, APUNTES) " +
							 "VALUES (" 
							 +id+","
							 +examen_id+"," 
							 +examenPracticas.isApuntes()
							 +")";
				
					if(examenPracticasAux!=null){
						examenPracticasAux.setId_actividad(id_actividad);
						examenPracticasAux.setId_examen_practicas(id);
						examenPracticasAux.setId_examen(examen_id);
					}
					
					connectionManager.updateDB(str);
					System.out.println("\nExamen_Practicas creado con éxito: " + examenPracticasAux + "id_ex: "+examenPracticasAux.getId_examen());
				}
				connectionManager.close();
		
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el examen_practicas: "+e.getLocalizedMessage() );
		}
		return examenPracticasAux;
		
	}

	@Override
	public void editarExamen_Practicas(Examen_Practicas examenPracticas) {
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
