package bussines;

import java.time.LocalDateTime;

public abstract class Actividad_Examen extends Actividad{

	private int id_examen;
	
	public Actividad_Examen(Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, boolean finalizada) {
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, finalizada);

	}
	
	public Actividad_Examen(int id_examen, Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, boolean finalizada) {
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, finalizada);
		this.setId_examen(id_examen);
	}
	
	
	public int getId_examen() {
		return id_examen;
	}
	
	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}
	
}
