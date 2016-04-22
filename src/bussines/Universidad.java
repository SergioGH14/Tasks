package bussines;

import java.util.Map;

public class Universidad {
	
	private String logo;
	private String nombre;
	private String direccion;
	private Map<Integer, Grado> listagrados;

	public Universidad(String logo, String nombre, String direccion) {
		super();
		this.logo = logo;
		this.nombre = nombre;
		this.direccion = direccion;}

	
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	}
	
	

