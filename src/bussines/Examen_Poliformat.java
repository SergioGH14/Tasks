package bussines;

public class Examen_Poliformat extends Decorador_Examen {
	
	private Integer id_examen_poliformat;
	private boolean reintentable;
	
	public Examen_Poliformat(Actividad_Examen examen) {
		super(examen);
		super.setPrioridadTotal(establecerPrioridadTotal());
		
	}
	public Examen_Poliformat(Actividad_Examen examen, boolean reintentable) {
		super(examen);
		this.reintentable = reintentable;
		super.setPrioridadTotal(establecerPrioridadTotal());
		
	}
	public Examen_Poliformat(Integer id_examen_poliformat,Actividad_Examen examen, boolean reintentable) {
		super(examen);
		this.id_examen_poliformat = id_examen_poliformat;
		this.reintentable = reintentable;		
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

	public Integer getId_examen_poliformat() {
		return id_examen_poliformat;
	}
	public void setId_examen_poliformat(Integer id_examen_poliformat) {
		this.id_examen_poliformat = id_examen_poliformat;
	}
	private int establecerPrioridadTotal(){
		int aux = examen.getPrioridadtotal()-10;
		if(isReintentable()) aux = aux-5;
		//System.err.println("Prioridad de Examen_Poliformat " + aux);
		return aux;
		
	}

}
