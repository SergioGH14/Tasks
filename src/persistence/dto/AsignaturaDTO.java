package persistence.dto;

public class AsignaturaDTO {
	private int id_asignatura;
	private String titulo;
	private double creditos;
	private int dificultad;
	private boolean anual;
	
	public AsignaturaDTO(String titulo, double creditos, int dificultad, boolean anual) {
		super();
		this.titulo = titulo;
		this.creditos = creditos;
		this.dificultad = dificultad;
		this.anual = anual;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public boolean isAnual() {
		return anual;
	}

	public void setAnual(boolean anual) {
		this.anual = anual;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AsignaturaDTO))
			return false;
		AsignaturaDTO other = (AsignaturaDTO) obj;
		if (anual != other.anual)
			return false;
		if (Double.doubleToLongBits(creditos) != Double.doubleToLongBits(other.creditos))
			return false;
		if (dificultad != other.dificultad)
			return false;
		if (id_asignatura != other.id_asignatura)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AsignaturaDTO [id_asignatura=" + id_asignatura + ", titulo=" + titulo + ", creditos=" + creditos
				+ ", dificultad=" + dificultad + ", anual=" + anual + "]";
	}
	
	

}
