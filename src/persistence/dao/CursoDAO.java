package persistence.dao;

import bussines.Curso;

public interface CursoDAO {

	public Curso obtenerInformacionCurso(int id_curso);

	public Curso crearCurso(Curso curso);
		
	public void eliminarCurso(int id_curso);

}
