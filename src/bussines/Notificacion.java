package bussines;

import java.time.LocalDateTime;

import Util.Date_solver;




public class Notificacion {
	
	private int id_notificacion;
	private int id_actividad;
	private String color;
	private String titulo;
	private String descripcion;
	private int prioridad;
	private LocalDateTime fecha_notificacion;
	
	public Notificacion(int id_actividad,String titulo, String color, 
			String descripcion, int prioridad, LocalDateTime fecha){
		this.id_actividad = id_actividad;
		this.titulo = titulo;
		this.color = color;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.fecha_notificacion  = fecha;
	}

	public Notificacion(int id_notificacion, int actividad,
			String titulo, String color, String descripcion, int prioridad,
			LocalDateTime fecha_notificacion) {
		
		this.id_notificacion = id_notificacion;
		this.id_actividad = actividad;
		this.color = color;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.fecha_notificacion = fecha_notificacion;
	}

	public int getId_notificacion() {
		return id_notificacion;
	}

	public void setId_notificacion(int id_notificacion) {
		this.id_notificacion = id_notificacion;
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

	public LocalDateTime getFecha_notificacion() {
		return fecha_notificacion;
	}

	public void setFecha_notificacion(LocalDateTime fecha_notificacion) {
		this.fecha_notificacion = fecha_notificacion;
	}
	
	public int getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	//probar lo que imprime por consola 
	public String toString(){
		
		String S = getTitulo()+" "+getPrioridad()+" "+getDescripcion()+""+Date_solver.formatLocalDateTime(getFecha_notificacion())+""+getId_notificacion();
				
		
		return S;
	}
}
