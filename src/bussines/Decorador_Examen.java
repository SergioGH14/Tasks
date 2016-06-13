package bussines;


public class Decorador_Examen extends Actividad_Examen
{
	protected Actividad_Examen examen ;

	public Decorador_Examen(Actividad_Examen examen) {
		super(examen.getAsignatura(), examen.getTitulo(), examen.getDescripcion(), examen.getFechaFinalizacion(), examen.getTiempoEstimado(), examen.getPorcentaje(), examen.getPrioridadUsuario(), examen.isFinalizada(), examen.isPara_despues());
		this.examen=examen;
	}
	
	
}
