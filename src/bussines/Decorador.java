package bussines;

import java.util.Date;

public class Decorador extends Examen{

	
	public Decorador(Asignatura asignatura, String titulo, String descripcion, Date fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal, boolean grupal,
			boolean recuperable, boolean ultimo, boolean finalizada) {
		super(asignatura, titulo, descripcion, fechafinalizacion, tiempoestimado, porcentaje, prioridadusuario, prioridadtotal,
				grupal, recuperable, ultimo, finalizada);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
