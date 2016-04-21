package bussines;

import java.util.Date;
import java.util.Map;

public class Curso {

	private Map<Integer,Cuatrimestre> listacuatrimestres; 
	
	public Date getAnyo() {
		return anyo;
	}
	public void setAnyo(Date anyo) {
		this.anyo = anyo;
	}
	public Double getCreditos() {
		return creditos;
	}
	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}
	private Date anyo;
	private Double creditos;
	
	
}
