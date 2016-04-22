package bussines;

import java.util.Map;

public class Usuario {

	private Map<Integer,Universidad> listauniversidades;
	
	private String nombre;
	private String apellidos;
	private String avatar;
	private String fechanacimiento;
	
	public Usuario(String nombre, String apellidos, String avatar,String fechanacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.avatar = avatar;
		this.fechanacimiento = fechanacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	 
	
}
