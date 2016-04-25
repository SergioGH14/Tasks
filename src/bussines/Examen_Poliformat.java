package bussines;

public class Examen_Poliformat extends Decorador {
	
	private Examen examen ;
	private boolean reintentable;
	

	public Examen_Poliformat(Examen examen, boolean reintentable) {
		super(examen);
		// TODO Auto-generated constructor stub
		this.examen=examen;
		this.reintentable = reintentable;
		super.setPrioridadtotal(establecerPrioridadTotal());
		
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
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
