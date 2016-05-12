package bussines;

import java.util.List;
import java.util.Map;

import persistence.DAL;
import persistence.UniversidadDAOImp;

public class Unidad_Logica {
	
	public static Unidad_Logica instancia; //singleton
	public Usuario usuario;  //para el usuario en memoria
	public Universidad universidad; //universidad en memoria 
	public Grado grado; //grado en memoria
	public Curso curso; //curso en memoria
	public Map<Integer,Cuatrimestre> cuatrimestre;
	public Map<Integer, Notificacion> notificaciones;
	//public List<Actividad> actividades;
	public Map<Integer, Asignatura> asignatura;
	public DAL dal = DAL.getInstance();
	
	//singleton
	public static Unidad_Logica getInstance(){
		if(instancia == null){
			instancia = new Unidad_Logica();
		}
		return instancia;
	}
	
	//Usuario
	public Usuario crearUsuario(Usuario usuario){
		this.usuario = usuario;
		return dal.crearUsuario(usuario);
	}
	//metodo que comprueba si existe un usuario en la base de datos 
	public boolean hayUsuario(){
		if( dal.obtenerInformacionDeUsuario(1) == null){return false;}
		else return true;
	}
	
	public Usuario informacionUsuario(int id_usuario){
		return dal.obtenerInformacionDeUsuario(id_usuario);
	}
	
	public void eliminarUsuario(int id_usuario){
		dal.eliminarUsuario(id_usuario);
	}
	
	public void editarUsuario(Usuario usuario){
		//dal.editarUsuario(usuario);
	}
	
	public Usuario asociarUniversidadUsuario(Usuario usuario, int id_universidad){
	  return	dal.asociarUniversidadUsuario(usuario, id_universidad);
		
	}

	//Universiadad
	public Universidad obtenerInformacionUniversidad(int id_universidad) {
		return dal.obtenerInformacionDeUniversidad(id_universidad);
	}
	
	public void eliminarUniversidad(int id_universidad) {
		dal.eliminarUniversidad(id_universidad);
	}

	public void editarUniversiad(Universidad universidad) {
		dal.editarUniversidad(universidad);
	}
	
	public Universidad crearUniversidad(Universidad universidad) {
		return dal.crearUniversidad(universidad);
		
	}

	//CURSO 
	public Curso obtenerInformacionCurso(int id_curso) {
		return dal.obtenerInformacionCurso(id_curso);
	}
	
	public void eliminarCurso(int id_curso) {
		dal.eliminarCurso(id_curso);
	}
	
	public Curso crearCurso(Curso curso) {
		return dal.crearCurso(curso);
	}

	//GRADO
	public Grado obtenerInformacionGrado(int id_grado){
		return dal.obtenerInformacionGrado(id_grado);
	}
	
	public void eliminarGrado(int id_grado) {
		dal.eliminarGrado(id_grado);
	}
	
	public void editarGrado(Grado grado) {
		dal.editarGrado(grado);
	}
	
	public Grado crearGrado(Grado grado) {
		return dal.crearGrado(grado);
	}
	
}

