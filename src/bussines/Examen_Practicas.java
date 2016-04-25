package bussines;
public class Examen_Practicas extends Decorador {
	
	private Examen examen ;
	private boolean apuntes;
	
	public Examen_Practicas(Examen examen, boolean apuntes) {
		super(examen);
		// TODO Auto-generated constructor stub
		this.examen=examen;
		this.apuntes = apuntes;
		super.setPrioridadtotal(establecerPrioridadTotal());
		
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public boolean isApuntes() {
		return apuntes;
	}

	public void setApuntes(boolean apuntes) {
		this.apuntes = apuntes;
	}

	private int establecerPrioridadTotal(){
		int aux = examen.getPrioridadtotal()-5;
		if(isApuntes()) aux = aux-5;
		return aux;
		
	}
}