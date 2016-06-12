package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.Constantes;
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen;
import bussines.Examen_Clase;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
import persistence.dao.ExamenClaseDAO;

public class ExamenClaseDAOImp implements ExamenClaseDAO {
	protected ConnectionManager connectionManager;

	public ExamenClaseDAOImp(){
		try{
			System.out.println("\n\t######## ExamenClaseDAOImp ########  ");
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ExamenClaseDAOImp: "+e.getLocalizedMessage());
		}
	}
	@Override
	public Examen_Clase obtenerInformacionDeExamen_Clase(int id_examen_concreto) {
		Examen_Clase examen_clase = null;		
		try{
			connectionManager.connect();
			ResultSet examen_clase_resultset = connectionManager.queryDB("SELECT * FROM EXAMEN_CLASE WHERE id_examen='"+ id_examen_concreto+"'");
			connectionManager.close();
			Actividad_Examen examenaux=  (Actividad_Examen)new ExamenDAOImp().obtenerInformacionDeExamenSinDecoracion(id_examen_concreto);
			System.err.println("Examen clase con id: " + examenaux.getId_examen() + " id_act: " + examenaux.getId_actividad());

			if(examen_clase_resultset.next() && examenaux!=null){
				examen_clase = new Examen_Clase(examen_clase_resultset.getInt("ID_EXAMEN_CLASE"),
						examenaux,
						examen_clase_resultset.getBoolean("GRUPAL"),
						examen_clase_resultset.getBoolean("APUNTES"));
				examen_clase.setId_actividad(examenaux.getId_actividad());
				examen_clase.setId_examen(examenaux.getId_examen());
				examen_clase.setPrioridadTotal(examenaux.getPrioridadTotal());
				
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar el examen_clase: "+e.getLocalizedMessage() );
		}
		System.err.println("Antes de devolver el examen decorado por clase : " + examen_clase);
		return examen_clase;
	}

	@Override
	public void eliminarExamen_Clase(int id_examen) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM EXAMEN_CLASE WHERE id_examen ='"+ id_examen+"'" ;
			connectionManager.updateDB(str);
			connectionManager.close();
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el Examen-Practicas: "+e.getLocalizedMessage() );
		}

	}

	@Override
	public Examen_Clase crearExamen_Clase(Examen_Clase examenclase) {
		System.err.println("El examen ha llegado y su id act: " + examenclase.getId_actividad());
		Examen_Clase examenClasesAux = examenclase;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.EXAMEN_CLASE_SQ);
			if(id>0){
				Actividad_Examen examenBase =   (Actividad_Examen) new ExamenDAOImp().crearExamen((Actividad_Examen)examenclase.getExamen());
				int id_actividad= examenBase.getId_actividad();
				int examen_id = examenBase.getId_examen();
				String str = "INSERT INTO EXAMEN_CLASE (ID_EXAMEN_CLASE, ID_EXAMEN, GRUPAL, APUNTES) " +
							 "VALUES (" 
							 +id+","
							 +examen_id+"," 
							 +examenclase.isGrupal()+","
							 +examenClasesAux.isApuntes()
							 +")";
				
					if(examenClasesAux!=null){
						examenClasesAux.setId_actividad(id_actividad);
						examenClasesAux.setId_examen_clase(id);
						examenClasesAux.setId_examen(examen_id);
					}
					
					connectionManager.updateDB(str);
					System.out.println("\nExamen_Clase creado con éxito: " + examenClasesAux + "id_ex: "+examenClasesAux.getId_examen());
				}
				connectionManager.close();
		
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el examen_clase: "+e.getLocalizedMessage() );
		}
		return examenClasesAux;
		
	}

	@Override
	public void editarExamen_Clase(Examen_Clase examenclase) {
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
