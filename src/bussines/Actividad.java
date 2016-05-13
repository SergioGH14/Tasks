package bussines;

import java.time.LocalDateTime;

public abstract class Actividad {

	private int id_actividad;
	private Asignatura asignatura;
	private String titulo;
	private String descripcion;
	private LocalDateTime fechaFinalizacion;
	private int tiempoEstimado;
	private double porcentaje;
	private int prioridadUsuario;
	private int prioridadTotal;
	private boolean finalizada;
	
	public Actividad(int id_actividad, Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal, boolean finalizada) {
		this.id_actividad = id_actividad;
		this.asignatura = asignatura;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaFinalizacion = fechafinalizacion;
		this.tiempoEstimado = tiempoestimado;
		this.porcentaje = porcentaje;
		this.prioridadUsuario = prioridadusuario;
		this.prioridadTotal = prioridadtotal;
		this.finalizada = finalizada;
	}

	public Actividad(Asignatura asignatura, String titulo, String descripcion,
			LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, 
			int prioridadusuario, boolean finalizada) {
		
		this.setAsignatura(asignatura);
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaFinalizacion = fechafinalizacion;
		this.tiempoEstimado = tiempoestimado;
		this.porcentaje = porcentaje;
		this.prioridadUsuario = prioridadusuario;
		this.prioridadTotal = establecerPrioridadTotal();
		this.finalizada = finalizada;
		
	}

	private int establecerPrioridadTotal(){
		return -1;
	}

	public int getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
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

	public LocalDateTime getFechafinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechafinalizacion(LocalDateTime fechafinalizacion) {
		this.fechaFinalizacion = fechafinalizacion;
	}

	public int getTiempoestimado() {
		return tiempoEstimado;
	}

	public void setTiempoestimado(int tiempoestimado) {
		this.tiempoEstimado = tiempoestimado;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getPrioridadusuario() {
		return prioridadUsuario;
	}

	public void setPrioridadusuario(int prioridadusuario) {
		this.prioridadUsuario = prioridadusuario;
	}

	public int getPrioridadtotal() {
		return prioridadTotal;
	}

	public void setPrioridadtotal(int prioridadtotal) {
		this.prioridadTotal = prioridadtotal;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	@Override
	public String toString() {
		return "Actividad [id_actividad=" + id_actividad + ", asignatura=" + asignatura + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", fechaFinalizacion=" + fechaFinalizacion + ", tiempoEstimado="
				+ tiempoEstimado + ", porcentaje=" + porcentaje + ", prioridadUsuario=" + prioridadUsuario
				+ ", prioridadTotal=" + prioridadTotal + ", finalizada=" + finalizada + "]";
	}
	
	
}

