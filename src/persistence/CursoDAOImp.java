package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import Util.Date_solver;
import bussines.Curso;
import bussines.Grado;
import persistence.dao.CursoDAO;

public class CursoDAOImp implements CursoDAO{

	protected ConnectionManager connectionManager;
	
	public CursoDAOImp() {
		try{			
			connectionManager= new ConnectionManager(Constantes.DATABASE);

		}catch(Exception e){
			System.err.println("Error en persistencia, CursoDAOImp: "+e.getLocalizedMessage());

		}

	}

	@Override
	public Curso obtenerInformacionCurso(int id_curso) {
		Curso curso = null;
		try{
			connectionManager.connect();
			ResultSet curso_resultSet = connectionManager.queryDB("SELECT * from CURSO where id_curso = '"+id_curso+"'");
			connectionManager.close();
		
			if (curso_resultSet.next()){
				curso = new Curso(
						curso_resultSet.getInt("ID_CURSO"),
						new GradoDAOImp().obtenerInformacionGrado(curso_resultSet.getInt("ID_GRADO")),
						Date_solver.convertirDateSQLEnLocalDateTime(curso_resultSet.getDate("ANYO")),
						curso_resultSet.getDouble("CREDITOS") );
			}else
				return curso;	
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar al la universidad: "+e.getLocalizedMessage() );
		}
		return curso;
	}
	
	@Override
	public Curso crearCurso(Curso curso) {
		Curso cursoAux = curso;
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.CURSO_SQ);
			if(id>0){
				String str = "INSERT INTO CURSO (ID_CURSO, ID_GRADO, ANYO, CREDITOS) " +
							 "VALUES ("+
							 id+",'"+
							 curso.getGrado().getId_grado() +"','"+ 
							 Date_solver.convertirLocalDateEnSQL(curso.getAnyo())+"',"+
							 curso.getCreditos()+""+
							 ")";

				if(cursoAux!=null){
					cursoAux.setId_curso(id);
				}
				connectionManager.updateDB(str);
				System.out.println("\nCurso creado con éxito: " + curso);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el curso: "+e.getLocalizedMessage() );
		}
		return cursoAux;
	}


	@Override
	public void eliminarCurso(int id_curso) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM CURSO WHERE id_curso="+ id_curso ;
			connectionManager.updateDB(str);


			System.out.println("\nCurso eliminado con éxito: ");
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el curso: "+e.getLocalizedMessage() );
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
