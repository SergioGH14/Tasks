package bussines;
public class Examen_Practicas extends Decorador_Examen {
	
	private Integer id_examen_practicas;
	private boolean apuntes;
	
	public Examen_Practicas(Actividad_Examen examen) {
		super(examen);
		super.setPrioridadtotal(establecerPrioridadTotal());
		
	}
	
	public Examen_Practicas(Actividad_Examen examen, boolean apuntes) {
		super(examen);
		this.apuntes = apuntes;
		super.setPrioridadtotal(establecerPrioridadTotal());
	}
	
	public Examen_Practicas(Integer id_examen_practicas, Actividad_Examen examen, boolean apuntes) {
		super(examen);
		this.id_examen_practicas = id_examen_practicas;
		this.apuntes = apuntes;
		super.setPrioridadtotal(establecerPrioridadTotal());
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

	private int establecerPrioridadTotal(){
		int aux = examen.getPrioridadtotal()-5;
		if(isApuntes()) aux = aux-5;
		//System.err.println("Prioridad de Examen_Practicas: " + aux);
		return aux;
		
	}

	public Integer getId_examen_practicas() {
		return id_examen_practicas;
	}

	public void setId_examen_practicas(Integer id_examen_practicas) {
		this.id_examen_practicas = id_examen_practicas;
	}

	@Override
	public String toString() {
		return "Examen_Practicas [id_examen_practicas=" + id_examen_practicas + ", apuntes=" + apuntes + "]";
	}
	
}