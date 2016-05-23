package persistence;

import java.sql.ResultSet;
import java.util.List;

import Util.Constantes;
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen_Clase;
import bussines.Examen_Practicas;
import persistence.dao.ExamenClaseDAO;

public class ExamenClaseDAOImp implements ExamenClaseDAO {
	protected ConnectionManager connectionManager;

	public ExamenClaseDAOImp(){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);
		}catch(Exception e){
			System.err.println("Error en persistencia, ExamenClaseDAOImp: "+e.getLocalizedMessage());
		}
	}
	@Override
	public Examen_Clase obtenerInformacionDeExamen_Clase(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarExamen_Clase(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Examen_Clase crearExamen_Clase(Examen_Clase examenclase) {
		Examen_Clase examenClasesAux = examenclase;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.EXAMEN_CLASE_SQ);
			if(id>0){
				int examen_id = new ExamenDAOImp().crearExamen((Actividad_Examen)examenclase.getExamen()).getId_examen();
				String str = "INSERT INTO EXAMEN_CLASE (ID_EXAMEN_CLASE, ID_EXAMEN, GRUPAL, APUNTES) " +
							 "VALUES (" 
							 +id+","
							 +examen_id+"," 
							 +examenclase.isGrupal()+","
							 +examenClasesAux.isApuntes()
							 +")";
				
					if(examenClasesAux!=null){
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
