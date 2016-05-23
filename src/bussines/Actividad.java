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
	private boolean para_despues;
	
	public Actividad(int id_actividad, Asignatura asignatura, String titulo, String descripcion, LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, int prioridadtotal, boolean finalizada, boolean para_despues) {
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
		this.para_despues = para_despues;
	}

	public Actividad(Asignatura asignatura, String titulo, String descripcion,
			LocalDateTime fechafinalizacion,
			int tiempoestimado, Double porcentaje, 
			int prioridadusuario, boolean finalizada, boolean para_despues) {
		
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
	

	public LocalDateTime getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public int getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public int getPrioridadUsuario() {
		return prioridadUsuario;
	}

	public void setPrioridadUsuario(int prioridadUsuario) {
		this.prioridadUsuario = prioridadUsuario;
	}

	public int getPrioridadTotal() {
		return prioridadTotal;
	}

	public void setPrioridadTotal(int prioridadTotal) {
		this.prioridadTotal = prioridadTotal;
	}

	public boolean isPara_despues() {
		return para_despues;
	}

	public void setPara_despues(boolean para_despues) {
		this.para_despues = para_despues;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Actividad [id_actividad=" + id_actividad + ", asignatura=" + asignatura + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", fechaFinalizacion=" + fechaFinalizacion + ", tiempoEstimado="
				+ tiempoEstimado + ", porcentaje=" + porcentaje + ", prioridadUsuario=" + prioridadUsuario
				+ ", prioridadTotal=" + prioridadTotal + ", finalizada=" + finalizada + "]";
	}
	
	
}

