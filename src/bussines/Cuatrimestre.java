package bussines;

import java.util.Map;

public class Cuatrimestre {

	private int id_cuatrimestre;
	private Curso curso;
	private int cuatrimestre;
	private Map<Integer, Asignatura> listaAsignaturas;
	
	public Cuatrimestre(int id_cuatrimestre, Curso curso, int cuatrimestre) {
		super();
		this.id_cuatrimestre = id_cuatrimestre;
		this.curso = curso;
		this.cuatrimestre = cuatrimestre;
	}

	public Cuatrimestre(Curso curso, int cuatrimestre) {
		super();
		this.curso = curso;
		this.cuatrimestre = cuatrimestre;
	}
	
	public int getId_cuatrimestre() {
		return id_cuatrimestre;
	}
	public void setId_cuatrimestre(int id_cuatrimestre) {
		this.id_cuatrimestre = id_cuatrimestre;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public int getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	
	@Override
	public String toString() {
		return "Cuatrimestre [id_cuatrimestre=" + id_cuatrimestre + ", curso=" + curso + ", cuatrimestre="
				+ cuatrimestre + "]";
	}
	
}
