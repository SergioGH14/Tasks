package bussines;

import java.util.Date;

import Util.Date_solver;

public class Notificacion {
	//En las clases constantes se puede añadir imagenes para examen clases practicas
	private String titulo;
	private String descripcion;
	private int prioridad;
	private Date fecha_notificacion;
	
	public Notificacion(String titulo, String descripcion, int prioridad, Date fecha){
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.fecha_notificacion  = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public Date getFecha_notificacion() {
		return fecha_notificacion;
	}

	public void setFecha_notificacion(Date fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}
	//probar lo que imprime por consola 
	public String toString(){
		
		String S = getTitulo()+" "+getPrioridad()+" "+getDescripcion()+""+Date_solver.dateastring(getFecha_notificacion());
		
		return S;
	}
}
