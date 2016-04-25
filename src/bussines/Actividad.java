package bussines;

import java.util.Date;

public abstract class Actividad {

	private Asignatura asignatura;
	private String titulo;
	private String descripcion;
	private Date fechafinalizacion;
	private int tiempoestimado;
	private Double porcentaje;
	private int prioridadusuario;
	private int prioridadtotal;
	private boolean finalizada;
	
	public Actividad(Asignatura asignatura, String titulo, String descripcion, Date fechafinalizacion,
			int tiempoestimado, Double porcentaje, int prioridadusuario, boolean finalizada) {
		super();
		this.setAsignatura(asignatura);
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechafinalizacion = fechafinalizacion;
		this.tiempoestimado = tiempoestimado;
		this.porcentaje = porcentaje;
		this.prioridadusuario = prioridadusuario;
		this.prioridadtotal = establecerPrioridadTotal();
		this.finalizada = finalizada;
		
	}

	private int establecerPrioridadTotal(){
		return -1;
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
	public Date getFechafinalizacion() {
		return fechafinalizacion;
	}
	public void setFechafinalizacion(Date fechafinalizacion) {
		this.fechafinalizacion = fechafinalizacion;
	}
	public int getTiempoestimado() {
		return tiempoestimado;
	}
	public void setTiempoestimado(int tiempoestimado) {
		this.tiempoestimado = tiempoestimado;
	}
	public Double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getPrioridadusuario() {
		return prioridadusuario;
	}
	public void setPrioridadusuario(int prioridadusuario) {
		this.prioridadusuario = prioridadusuario;
	}
	public int getPrioridadtotal() {
		return prioridadtotal;
	}
	public void setPrioridadtotal(int prioridadtotal) {
		this.prioridadtotal = prioridadtotal;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
}

