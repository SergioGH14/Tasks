package bussines;

import java.time.LocalDateTime;
import java.util.Map;

public class Grado {
	
	private int id_grado;
	private Universidad universidad;
	private String titulacion;
	private LocalDateTime anyoinicio;
	private Map<Integer,Curso> listacursos;
	
	public Grado(int id_grado, Universidad universidad, String titulacion, LocalDateTime anyoinicio) {
		super();
		this.id_grado = id_grado;
		this.universidad = universidad;
		this.titulacion = titulacion;
		this.anyoinicio = anyoinicio;
	}
	
	public Grado(Universidad universidad, String titulacion, LocalDateTime anyoinicio) {
		super();
		this.universidad = universidad;
		this.titulacion = titulacion;
		this.anyoinicio = anyoinicio;
	}


	public Grado(int id_grado){
		this.id_grado = id_grado;
	}

	public int getId_grado() {
		return id_grado;
	}

	public void setId_grado(int id_grado) {
		this.id_grado = id_grado;
	}	

	public Universidad getUniversidad() {
		return universidad;
	}


	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}


	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public LocalDateTime getAnyoinicio() {
		return anyoinicio;
	}

	public void setAnyoinicio(LocalDateTime anyoinicio) {
		this.anyoinicio = anyoinicio;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Grado))
			return false;
		Grado other = (Grado) obj;
		if (anyoinicio == null) {
			if (other.anyoinicio != null)
				return false;
		} else if (!anyoinicio.equals(other.anyoinicio))
			return false;
		if (id_grado != other.id_grado)
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		if (universidad != other.universidad)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grado [id_grado=" + id_grado + ", universidad=" + universidad + ", titulacion=" + titulacion
				+ ", anyoinicio=" + anyoinicio + "]";
	}
	
	
}
