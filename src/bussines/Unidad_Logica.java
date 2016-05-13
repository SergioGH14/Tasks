package bussines;

import java.util.List;
import java.util.Map;

import persistence.DAL;
import persistence.UniversidadDAOImp;

public class Unidad_Logica {
	
	private static Unidad_Logica instancia; //singleton
	private Usuario usuario;  //para el usuario en memoria
	private Universidad universidad; //universidad en memoria 
	private Grado grado; //grado en memoria
	private Curso curso; //curso en memoria
	private Map<Integer,Cuatrimestre> cuatrimestre;
	private Map<Integer, Notificacion> notificaciones;
	//public List<Actividad> actividades;
	private Map<Integer, Asignatura> asignatura;
	private DAL dal = DAL.getInstance();
	
	//singleton
	public static Unidad_Logica getInstance(){
		if(instancia == null){
			instancia = new Unidad_Logica();
		}
		return instancia;
	}
	//GETTERS Y SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Map<Integer, Cuatrimestre> getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Map<Integer, Cuatrimestre> cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Map<Integer, Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Map<Integer, Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public Map<Integer, Asignatura> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Map<Integer, Asignatura> asignatura) {
		this.asignatura = asignatura;
	}

	public DAL getDal() {
		return dal;
	}

	

	//USUARIO
	public Usuario crearUsuario(Usuario usuario){
		this.usuario = usuario;
		return dal.crearUsuario(usuario);
	}
	
	public boolean hayUsuario(){
		return dal.existeUsuario();
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

	//UNIVERSIDAD
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
	//ASIGNATURA
	public Asignatura informacionAsignatura(int id){
		return null;
	}
	
}

