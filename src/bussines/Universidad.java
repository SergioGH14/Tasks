package bussines;

import java.util.Map;

public class Universidad {
	
	
	private int id_universidad;
	private String logo;
	private String nombre;
	private String direccion;
	private Map<Integer, Grado> listagrados;

	public Universidad(String logo, String nombre, String direccion) {
		
		this.logo = logo;
		this.nombre = nombre;
		this.direccion = direccion;}

	
	
	public Universidad(int id_universidad, String nombre, String logo, String direccion) {
		
		this.id_universidad = id_universidad;
		this.logo = logo;
		this.nombre = nombre;
		this.direccion = direccion;
	}



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

	public int getId_universidad() {
		return id_universidad;
	}

	public void setId_universidad(int id_universidad) {
		this.id_universidad = id_universidad;
	}
	
	}
	
	

