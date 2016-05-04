package bussines;

import java.time.LocalDateTime;
import java.util.Map;

public class Curso {

	private int id_curso;
	private Grado grado;
	private LocalDateTime anyo;
	private double creditos;
	private Map<Integer,Cuatrimestre> listacuatrimestres;
	
	
	
	public Curso(int id_curso, Grado grado, LocalDateTime anyo, Double creditos) {
		super();
		this.id_curso = id_curso;
		this.grado = grado;
		this.anyo = anyo;
		this.creditos = creditos;
	}
	
	
	public Curso(Grado grado, LocalDateTime anyo, Double creditos) {
		super();
		this.grado = grado;
		this.anyo = anyo;
		this.creditos = creditos;
	}

	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public Grado getGrado() {
		return grado;
	}
	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	public LocalDateTime getAnyo() {
		return anyo;
	}
	public void setAnyo(LocalDateTime anyo) {
		this.anyo = anyo;
	}
	public Double getCreditos() {
		return creditos;
	}
	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Curso))
			return false;
		Curso other = (Curso) obj;
		if (anyo == null) {
			if (other.anyo != null)
				return false;
		} else if (!anyo.equals(other.anyo))
			return false;
		if (Double.doubleToLongBits(creditos) != Double.doubleToLongBits(other.creditos))
			return false;
		if (grado == null) {
			if (other.grado != null)
				return false;
		} else if (!grado.equals(other.grado))
			return false;
		if (id_curso != other.id_curso)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Curso [id_curso=" + id_curso + ", grado=" + grado + ", anyo=" + anyo + ", creditos=" + creditos +"]";
	} 
	
	
	
}
