package bussines;

import java.util.Date;

public class Decorador extends Examen
{
	private Examen examen ;

	public Decorador(Examen examen) {
		super(examen.getAsignatura(), examen.getTitulo(), examen.getDescripcion(),examen.getFechafinalizacion(),examen.getTiempoestimado(), examen.getPorcentaje(),examen.getPrioridadusuario(), examen.isFinalizada(), examen.isRecuperable(), examen.isUltimo());
		// TODO Auto-generated constructor stub
		this.examen=examen;
	}
	
	
	
}
