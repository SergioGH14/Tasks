package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import bussines.Actividad_Examen;
import bussines.Examen;
import bussines.Examen_Practicas;
import persistence.dao.ExamenPracticasDAO;

public class ExamenPracticasDAOImp implements ExamenPracticasDAO {
	protected ConnectionManager connectionManager;

	public ExamenPracticasDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ExamenPracticasDAOImp: "+e.getLocalizedMessage());
		}
	}
	
	@Override
	public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarExamen_Practicas(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas) {
		Examen_Practicas examenPracticasAux = examenPracticas;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.EXAMEN_PRACTICA_SQ);
			if(id>0){
				int examen_id = new ExamenDAOImp().crearExamen((Actividad_Examen)examenPracticas.getExamen()).getId_examen();
				String str = "INSERT INTO EXAMEN_PRACTICAS (ID_EXAMEN_PRACTICAS, ID_EXAMEN, APUNTES) " +
							 "VALUES (" 
							 +id+","
							 +examen_id+"," 
							 +examenPracticas.isApuntes()
							 +")";
				
					if(examenPracticasAux!=null){
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
