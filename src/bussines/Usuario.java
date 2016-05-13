package bussines;

import java.time.LocalDateTime;
import java.util.Map;

public class Usuario {

	private Map<Integer,Universidad> listauniversidades;
	private int id_usuario;
	private Universidad universidad;
	private String nombre;
	private String apellidos;
	private String avatar;
	private LocalDateTime fechanacimiento;
	private String email;
	

	public Usuario(int id_usuario, Universidad universidad, String nombre, String apellidos, String avatar,
			LocalDateTime fechanacimiento, String email) {
		super();
		this.id_usuario = id_usuario;
		this.universidad = universidad;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.avatar = avatar;
		this.fechanacimiento = fechanacimiento;
		this.email = email;
	}

	public Usuario(Universidad universidad, String nombre, String apellidos, String avatar,
			LocalDateTime fechanacimiento, String email) {
		super();
		this.universidad = universidad;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.avatar = avatar;
		this.fechanacimiento = fechanacimiento;
		this.email = email;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
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
	public LocalDateTime getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(LocalDateTime fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreCompleto(){
		return getNombre() + " " + getApellidos();
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", universidad=" + universidad + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", avatar=" + avatar + ", fechanacimiento=" + fechanacimiento
				+ ", email=" + email + "]";
	}

	 
	
}
