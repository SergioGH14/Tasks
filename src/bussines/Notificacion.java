package bussines;

import java.time.LocalDateTime;

import Util.Date_solver;




public class Notificacion {
	
	private int id_notificacion;
	private Actividad actividad;
	private String titulo;
	private String descripcion;
	private int prioridad;
	private LocalDateTime fecha_notificacion;
	
	public Notificacion(Actividad d,String titulo, String descripcion, int prioridad, LocalDateTime fecha){
		actividad = d;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.fecha_notificacion  = fecha;
	}

	public Notificacion(int id_notificacion, Actividad actividad,
			String titulo, String descripcion, int prioridad,
			LocalDateTime fecha_notificacion) {
		
		this.id_notificacion = id_notificacion;
		this.actividad = actividad;
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

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
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
	//probar lo que imprime por consola 
	public String toString(){
		
		String S = getTitulo()+" "+getPrioridad()+" "+getDescripcion()+""+Date_solver.formatLocalDateTime(getFecha_notificacion())+""+getId_notificacion();
				
		
		return S;
	}
}
