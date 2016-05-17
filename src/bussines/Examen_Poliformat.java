package bussines;

public class Examen_Poliformat extends Decorador_Examen {
	
	private int id_examen_poliformat;
	private boolean reintentable;
	

	public Examen_Poliformat(Actividad_Examen examen, boolean reintentable) {
		super(examen);
		// TODO Auto-generated constructor stub
		this.examen=examen;
		this.reintentable = reintentable;
		super.setPrioridadtotal(establecerPrioridadTotal());
		
	}

	public Actividad_Examen getExamen() {
		return examen;
	}

	public void setExamen(Actividad_Examen examen) {
		this.examen = examen;
	}

	public boolean isReintentable() {
		return reintentable;
	}

	public void setReintentable(boolean reintentable) {
		this.reintentable = reintentable;
	}

	private int establecerPrioridadTotal(){
		int aux = examen.getPrioridadtotal()-10;
		if(isReintentable()) aux = aux-5;
		return aux;
		
	}
}
