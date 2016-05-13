package persistence.dto;

import java.time.LocalDateTime;

public class ActividadDTO {

	private int id_actividad;
	private int id_asignatura;
	private String titulo;
	private String descripcion;
	private LocalDateTime fechaFinalizacion;
	private int tiempoEstimado;
	private double porcentaje;
	private int prioridadUsuario;
	private int prioridadTotal;
	private boolean finalizada;
	
	public ActividadDTO(int id_asignatura, String titulo, String descripcion, LocalDateTime fechaFinalizacion,
			int tiempoEstimado, double porcentaje, int prioridadUsuario, boolean finalizada) {
		super();
		this.id_asignatura = id_asignatura;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaFinalizacion = fechaFinalizacion;
		this.tiempoEstimado = tiempoEstimado;
		this.porcentaje = porcentaje;
		this.prioridadUsuario = prioridadUsuario;
		this.finalizada = finalizada;
	}

	public ActividadDTO(int id_actividad, int id_asignatura, String titulo, String descripcion,
			LocalDateTime fechaFinalizacion, int tiempoEstimado, double porcentaje, int prioridadUsuario,
			boolean finalizada) {
		super();
		this.id_actividad = id_actividad;
		this.id_asignatura = id_asignatura;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaFinalizacion = fechaFinalizacion;
		this.tiempoEstimado = tiempoEstimado;
		this.porcentaje = porcentaje;
		this.prioridadUsuario = prioridadUsuario;
		this.finalizada = finalizada;
	}

	public int getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
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

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
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

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ActividadDTO))
			return false;
		ActividadDTO other = (ActividadDTO) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (finalizada != other.finalizada)
			return false;
		if (id_actividad != other.id_actividad)
			return false;
		if (id_asignatura != other.id_asignatura)
			return false;
		if (Double.doubleToLongBits(porcentaje) != Double.doubleToLongBits(other.porcentaje))
			return false;
		if (prioridadTotal != other.prioridadTotal)
			return false;
		if (prioridadUsuario != other.prioridadUsuario)
			return false;
		if (tiempoEstimado != other.tiempoEstimado)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActividadDTO [id_actividad=" + id_actividad + ", id_asignatura=" + id_asignatura + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + ", fechaFinalizacion=" + fechaFinalizacion + ", tiempoEstimado="
				+ tiempoEstimado + ", porcentaje=" + porcentaje + ", prioridadUsuario=" + prioridadUsuario
				+ ", prioridadTotal=" + prioridadTotal + ", finalizada=" + finalizada + "]";
	}
	
	
}
