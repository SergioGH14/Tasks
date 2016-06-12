package bussines;

import java.time.LocalDateTime;

public abstract class Actividad_Examen extends Actividad{

	private Integer id_examen;
	
	public Actividad_Examen(Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, boolean finalizada, boolean para_despues ) {
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, finalizada, para_despues);

	}
	
	public Actividad_Examen(Integer id_examen, int id_actividad, Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal,boolean finalizada, boolean para_despues) {
		super(id_actividad,asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje,prioridadusuario, prioridadtotal, finalizada, para_despues);
		this.setId_examen(id_examen);
	}
	
	
	public Integer getId_examen() {
		return id_examen;
	}
	
	public void setId_examen(Integer id_examen) {
		this.id_examen = id_examen;
	}
	
}
