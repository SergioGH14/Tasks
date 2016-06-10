package bussines;

public class Examen_Clase extends Decorador_Examen {

	private Integer id_examen_clase;
	private boolean apuntes;
	private boolean grupal;
	
	public Examen_Clase(Actividad_Examen examen) {
		super(examen);
		super.setPrioridadTotal(establecerPrioridadTotal());
		
	}
	
	public Examen_Clase(Actividad_Examen examen,boolean apuntes,boolean grupal) {
		super(examen);
		this.apuntes = apuntes;
		this.grupal=grupal;
		super.setPrioridadTotal(establecerPrioridadTotal());
		
	}
	
	public Examen_Clase(Integer id_examen_clase,Actividad_Examen examen,boolean apuntes,boolean grupal) {
		super(examen);
		this.id_examen_clase = id_examen_clase;
		this.apuntes = apuntes;
		this.grupal=grupal;
		super.setPrioridadTotal(establecerPrioridadTotal());
		
	}
	
	public Actividad_Examen getExamen() {
		return examen;
	}

	public void setExamen(Actividad_Examen examen) {
		this.examen = examen;
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

	public Integer getId_examen_clase() {
		return id_examen_clase;
	}

	public void setId_examen_clase(Integer id_examen_clase) {
		this.id_examen_clase = id_examen_clase;
	}

	private int establecerPrioridadTotal(){
		int aux = examen.getPrioridadtotal()-10;
		if(isApuntes()) aux = aux-5;
		if(isGrupal()) aux = aux-10;
		System.err.println("Prioridad de Examen_Clase: " + aux);
		return aux;
		
	}
}