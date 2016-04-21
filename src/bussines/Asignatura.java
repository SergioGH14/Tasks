package bussines;

import java.util.Map;

public class Asignatura {

	private Map<Integer, Actividad> listaactividades;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getCreditos() {
		return creditos;
	}
	public void setCreditos(Double creditos) {
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
	private String titulo;
	private Double creditos;
	private int dificultad;
	private boolean anual;
	
}
