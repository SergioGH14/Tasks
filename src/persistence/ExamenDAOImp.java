package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import bussines.Actividad_Examen;
import bussines.Examen;
import bussines.Examen_Clase;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
import persistence.dao.ExamenDAO;

public class ExamenDAOImp implements ExamenDAO {
	protected ConnectionManager connectionManager;

	public ExamenDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ExamenDAOImp: "+e.getLocalizedMessage());
		}
	}
	
	@Override
	public Examen obtenerInformacionDeExamen(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarExamen(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Actividad_Examen crearExamen(Actividad_Examen examen) {
		Actividad_Examen act_examen = examen;
		try{
			
			if(act_examen instanceof Examen){
				connectionManager.connect();

				Examen examenAux = (Examen)act_examen;
				System.err.println("Instancia de examen");
				int id = crearSecuencia(Constantes.EXAMEN_SQ);
				if(id>0){
					String str = "INSERT INTO EXAMEN (ID_EXAMEN, ID_ACTIVIDAD, ULTIMO, RECUPERABLE) " +
								 "VALUES (" 
								 +id+","
								 +new ActividadDAOImp().crearActividad(examen).getId_actividad()+","
								 +examenAux.isUltimo()+","
								 +examenAux.isRecuperable()
								 +")";
					
					if(examenAux!=null)
						examenAux.setId_examen(id);
					
					connectionManager.updateDB(str);
					
				}
				connectionManager.close();
				System.out.println("\nExamen creado con éxito: " + examenAux +"con id: " + examenAux.getId_examen()  );
				return examenAux;
			}
			if(act_examen instanceof Examen_Poliformat){
				System.err.println("Instancia de examen poli");
				return new ExamenPoliformatDAOImp().crearExamenPoliformat((Examen_Poliformat)act_examen);
			}
			if(act_examen instanceof Examen_Practicas){
				System.err.println("Instancia de examen prac");
				return new ExamenPracticasDAOImp().crearExamen_Practicas((Examen_Practicas)act_examen);
			} 
			if(act_examen instanceof Examen_Clase){
				System.err.println("Instancia de examen clase");
				return new ExamenClaseDAOImp().crearExamen_Clase((Examen_Clase)act_examen);
			} 
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear la actividad_examen y se devuelve el mismo: "+e.getLocalizedMessage() );
		}
		System.out.println("Upps, devuelvo el objeto previo jeje.");
		return  act_examen;
	}

	@Override
	public void editarExamen(Examen examen) {
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
