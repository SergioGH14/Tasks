package bussines;

import java.util.Map;

import javafx.scene.paint.Color;


public class Asignatura {
	
	private int id_asignatura;
	private Cuatrimestre cuatrimestre;
	private String titulo;
	private double creditos;
	private int dificultad;
	private boolean anual;
	private Color color; 

	private Map<Integer, Actividad> listaActividades;
	
	public Asignatura(int id_asignatura, Cuatrimestre cuatrimestre, String titulo, double creditos, int dificultad,
			boolean anual, Color color) {
		super();
		this.id_asignatura = id_asignatura;
		this.cuatrimestre = cuatrimestre;
		this.titulo = titulo;
		this.creditos = creditos;
		this.dificultad = dificultad;
		this.anual = anual;
		this.color = color;
	}

	public Asignatura(Cuatrimestre cuatrimestre, String titulo, double creditos, int dificultad, boolean anual,
			Color color) {
		super();
		this.cuatrimestre = cuatrimestre;
		this.titulo = titulo;
		this.creditos = creditos;
		this.dificultad = dificultad;
		this.anual = anual;
		this.color = color;
	}

	//constructor de prueba para lista en menu lateral
	public Asignatura(String titulo){
		this.titulo = titulo;
	}
	
	public Asignatura(String titulo, Color red){
		this.titulo = titulo;
		this.color = red;
	}
	//borrar despues de su uso


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
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Asignatura [id_asignatura=" + id_asignatura + ", cuatrimestre=" + cuatrimestre + ", titulo=" + titulo
				+ ", creditos=" + creditos + ", dificultad=" + dificultad + ", anual=" + anual + ", color=" + color
				+ "]";
	}
	
}
