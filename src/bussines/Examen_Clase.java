package bussines;

public class Examen_Clase extends Decorador_Examen {

	private int id_examen_clase;
	private boolean apuntes;
	private boolean grupal;
	
	public Examen_Clase(Actividad_Examen examen,boolean apuntes,boolean grupal) {
		super(examen);
		// TODO Auto-generated constructor stub
		this.apuntes = apuntes;
		this.grupal=grupal;
		super.setPrioridadtotal(establecerPrioridadTotal());
		
	}

	public boolean isApuntes() {
		return apuntes;
	}

	public void setApuntes(boolean apuntes) {
		this.apuntes = apuntes;
	}

	public boolean isGrupal() {
		return grupal;
	}

	public void setGrupal(boolean grupal) {
		this.grupal = grupal;
	}

	private int establecerPrioridadTotal(){
		int aux = examen.getPrioridadtotal()-10;
		if(isApuntes()) aux = aux-5;
		if(isGrupal()) aux = aux-10;
		return aux;
		
	}
}