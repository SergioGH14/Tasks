package bussines;


public class Decorador_Examen extends Actividad_Examen
{
	protected Actividad_Examen examen ;

	public Decorador_Examen(Actividad_Examen examen) {
		super(examen.getAsignatura(), examen.getTitulo(), examen.getDescripcion(),examen.getFechafinalizacion(),examen.getTiempoestimado(), examen.getPorcentaje(),examen.getPrioridadusuario(), examen.isFinalizada());
		this.examen=examen;
	}
	
	
}
