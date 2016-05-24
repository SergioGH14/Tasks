package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.Constantes;
import Util.Date_solver;
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen;
import bussines.Examen_Clase;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
import bussines.Practicas;
import persistence.dao.ExamenDAO;
import persistence.dto.ActividadDTO;

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
	public Actividad_Examen obtenerInformacionDeExamen(int id_examen_concreto) {
		Examen examen = null;
		try{
			connectionManager.connect();
			ResultSet examen_resultset = connectionManager.queryDB("SELECT * FROM EXAMEN WHERE id_examen='"+ id_examen_concreto+"'");
			connectionManager.close();
			
			if(examen_resultset.next()){
				ActividadDTO actividad = new ActividadDAOImp().obtenerInformacionDeActividadExamen(id_examen_concreto);
				if(actividad!=null){
					examen = new Examen(examen_resultset.getInt("ID_EXAMEN"),
							actividad.getId_actividad(),
							new AsignaturaDAOImp().obtenerInformacionAsignatura(actividad.getId_asignatura()),
							actividad.getTitulo(),
							actividad.getDescripcion(),
							actividad.getFechaFinalizacion(), 
							actividad.getTiempoEstimado(),
							actividad.getPorcentaje(), 
							actividad.getPrioridadUsuario(),
							actividad.getPrioridadTotal(),
							actividad.isFinalizada(),
							actividad.isPara_despues(),
							examen_resultset.getBoolean("ULTIMO"),
							examen_resultset.getBoolean("RECUPERABLE"));
					
					Examen_Practicas epractica = new ExamenPracticasDAOImp().obtenerInformacionDeExamen_Practicas(id_examen_concreto);
					Examen_Clase eclase = new ExamenClaseDAOImp().obtenerInformacionDeExamen_Clase(id_examen_concreto);
					Examen_Poliformat epoliformat = new ExamenPoliformatDAOImp().obtenerInformacionDeExamenPoliformat(id_examen_concreto);
					
					if(epractica!=null){
						System.out.println("\nEl examen tenia examen practico: "+epractica+"-");
						epractica.setExamen(examen);
						if(epoliformat!=null){
							System.out.println("- ademas lo tenia en un examen poliformat: "+epoliformat+"\n");
							epoliformat.setExamen(epractica);
							return epoliformat;
						}
						return epractica;
					}
					if(eclase!=null){
						System.out.println("\nEl examen es de clase: "+eclase+"\n");
						eclase.setExamen(examen);
						if(epoliformat!=null){
							System.out.println("- ademas lo tenia en un examen poliformat: "+epoliformat+"\n");
							epoliformat.setExamen(eclase);
							return epoliformat;
						}

						return eclase;
					}
					if(epoliformat!=null){
						System.out.println("\nEl examen es de poliformat: "+epoliformat+"\n");
						epoliformat.setExamen(examen);
						return epoliformat;
					}
				}else
					System.err.println("ActividadDTO en obtenerExamen ha dado null");
			}
			System.out.println("Examen recuperado de bbdd id_act: " + examen.getId_actividad() + " id_exa: "+examen.getId_examen()) ;
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al recuperar el examen de base de datos: "+e.getLocalizedMessage() );
		}		
		return examen;
	}
	
	@Override
	public Actividad_Examen obtenerInformacionDeExamenSinDecoracion(int id_examen_concreto) {
		Examen examen = null;
		try{
			connectionManager.connect();
			ResultSet examen_resultset = connectionManager.queryDB("SELECT * FROM EXAMEN WHERE id_examen='"+ id_examen_concreto+"'");
			connectionManager.close();
			
			if(examen_resultset.next()){
				ActividadDTO actividad = new ActividadDAOImp().obtenerInformacionDeActividadExamen(id_examen_concreto);
				if(actividad!=null){
					examen = new Examen(examen_resultset.getInt("ID_EXAMEN"),
							actividad.getId_actividad(),
							new AsignaturaDAOImp().obtenerInformacionAsignatura(actividad.getId_asignatura()),
							actividad.getTitulo(),
							actividad.getDescripcion(),
							actividad.getFechaFinalizacion(), 
							actividad.getTiempoEstimado(),
							actividad.getPorcentaje(), 
							actividad.getPrioridadUsuario(),
							actividad.getPrioridadTotal(),
							actividad.isFinalizada(),
							actividad.isPara_despues(),
							examen_resultset.getBoolean("ULTIMO"),
							examen_resultset.getBoolean("RECUPERABLE"));
				}
			}
			System.out.println("Examen sin decoraciones recuperado de bbdd id_act: " + examen.getId_actividad() + " id_exa: "+examen.getId_examen()) ;
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al recuperar el examen sin decorar de base de datos: "+e.getLocalizedMessage() );
		}		
		return examen;
	}

	@Override
	public void eliminarExamen(int id_examen) {
		
		try{
			connectionManager.connect();
			String str = "DELETE FROM EXAMEN WHERE id_examen ='"+ id_examen+"'" ;
			new ExamenPoliformatDAOImp().eliminarExamenPoliformat(id_examen);
			new ExamenPracticasDAOImp().eliminarExamen_Practicas(id_examen);
			new ExamenClaseDAOImp().eliminarExamen_Clase(id_examen);
			connectionManager.updateDB(str);
			connectionManager.close();
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el Examen: "+e.getLocalizedMessage() );
		}
		new ActividadDAOImp().eliminarActividad(id_examen);

	}

	@Override
	public Actividad_Examen crearExamen(Actividad_Examen examen) {
		Actividad_Examen act_examen = examen;
		try{
			
			if(act_examen instanceof Examen){
				connectionManager.connect();

				Examen examenAux = (Examen)act_examen;
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

	@Override
	public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura) {
		List<Actividad> listaActividades = new ArrayList<Actividad>();
		try{
			connectionManager.connect();
			ResultSet examenResultset = connectionManager.queryDB("SELECT * from ACTIVIDAD A, EXAMEN E where A.id_asignatura = '"+asignatura.getId_asignatura()+"' AND A.id_actividad = E.id_actividad AND A.finalizada = FALSE  AND A.para_despues = FALSE");
			connectionManager.close();
			
			//examenes decorados
			while(examenResultset.next()){
				Actividad_Examen examen = obtenerInformacionDeExamen(examenResultset.getInt("id_examen"));
				listaActividades.add( examen );
			}
			

		}catch (Exception e){
			System.err.println("\nError al recuperar los examenes de la asignatura :" + asignatura + " -> "  + e.getLocalizedMessage());
		}

		return listaActividades;
	}

	@Override
	public List<Actividad> obtenerTodasActividades() {
		List<Actividad> listaActividades = new ArrayList<Actividad>();
		try{
			connectionManager.connect();
			ResultSet listExamenesResultSet = connectionManager.queryDB("SELECT * from ACTIVIDAD A, EXAMEN E WHERE A.id_actividad = E.id_actividad AND A.finalizada = FALSE  AND A.para_despues = FALSE");
			connectionManager.close();

			while(listExamenesResultSet.next()){
				Actividad_Examen examen = obtenerInformacionDeExamen(listExamenesResultSet.getInt("id_examen"));
				listaActividades.add( examen );
			}
			
			}catch (Exception e){
			System.err.println("\nError al recuperar las todas activdades-examen -> "  + e.getLocalizedMessage());
		}

		return listaActividades;
	}

	@Override
	public List<Actividad> obtenerActividadesHoy() {
		List<Actividad> listaActividades = new ArrayList<Actividad>();
		try{
			connectionManager.connect();
			ResultSet listExamenesResultSet = connectionManager.queryDB("SELECT * from ACTIVIDAD A, EXAMEN E WHERE A.id_actividad = E.id_actividad AND A.fecha_finalizacion = '" + Date_solver.convertirLocalDateEnSQL(Date_solver.fechaDeHoy())+ "' AND A.finalizada = FALSE  AND A.para_despues = FALSE");
			connectionManager.close();

			while(listExamenesResultSet.next()){
				Actividad_Examen examen = obtenerInformacionDeExamen(listExamenesResultSet.getInt("id_examen"));
				listaActividades.add( examen );
			}

		}catch (Exception e){
			System.err.println("\nError al recuperar las todas activdades-examen -> "  + e.getLocalizedMessage());
		}
		return listaActividades;
	}

	@Override
	public List<Actividad> obtenerActividadesParaDespues() {
		List<Actividad> listaActividades = new ArrayList<Actividad>();
		try{
			connectionManager.connect();
			ResultSet listExamenesResultSet = connectionManager.queryDB("SELECT * from ACTIVIDAD A, EXAMEN E WHERE A.id_actividad = E.id_actividad AND A.para_despues = TRUE AND A.finalizada = FALSE  ");
			connectionManager.close();

			while(listExamenesResultSet.next()){
				Actividad_Examen examen = obtenerInformacionDeExamen(listExamenesResultSet.getInt("id_examen"));
				listaActividades.add( examen );
			}

		}catch (Exception e){
			System.err.println("\nError al recuperar las todas activdades-examen -> "  + e.getLocalizedMessage());
		}
		return listaActividades;	
	}

}
