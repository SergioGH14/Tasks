package bussines;

import java.util.Date;
import java.util.Map;

public class Grado {
	
	private String titulacion;
	private Date anyoinicio;
	private Map<Integer,Curso> listacursos;
	
	public Grado(String titulacion, Date anyoinicio) {
		super();
		this.titulacion = titulacion;
		this.anyoinicio = anyoinicio;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public Date getAnyoinicio() {
		return anyoinicio;
	}
	public void setAnyoinicio(Date anyoinicio) {
		this.anyoinicio = anyoinicio;
	}
	
	
}
