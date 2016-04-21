package bussines;

import java.util.Date;
import java.util.Map;

public class Grado {

	private Map<Integer,Curso> listacursos;
	
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
	private String titulacion;
	private Date anyoinicio;
	
}
