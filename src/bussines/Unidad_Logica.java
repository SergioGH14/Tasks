
package bussines;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import persistence.ActividadDAOImp;
import persistence.AsignaturaDAOImp;
import persistence.ClaseDAOImp;
import persistence.CuatrimestreDAOImp;
import persistence.DAL;
import persistence.ExamenClaseDAOImp;
import persistence.ExamenDAOImp;
import persistence.ExamenPoliformatDAOImp;
import persistence.ExamenPracticasDAOImp;
import persistence.NotificacionDAOImp;
import persistence.PracticasDAOImp;
import persistence.UniversidadDAOImp;
import persistence.dto.ActividadDTO;

public class Unidad_Logica {
	
	private static Unidad_Logica instancia; //singleton
	private Usuario usuario;  //para el usuario en memoria
	private Universidad universidad; //universidad en memoria 
	private Grado grado; //grado en memoria
	private Curso curso; //curso en memoria
	private Map<Integer,Cuatrimestre> cuatrimestre;
	private Map<Integer, Notificacion> notificaciones;
	public List<Actividad> actividades;
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
	/*FIN GETTER Y SETTER*/

	/*ACTIVIDAD*/
	public void eliminarActividad(int id_actividad) {
	  dal.eliminarActividad(id_actividad);
		
	}

	public Actividad crearActividad(Actividad actividad) {
	  Actividad acti= dal.crearActividad(actividad);
	   Iterator<Notificacion> it = Papinoti.crearNotificaciones(acti).iterator();
	   while (it.hasNext()) {
		  dal.crearNotificacion(  it.next());
	   }
	  
	   return actividad;
	}

	public void editarActividad(Actividad actividad) {
		dal.editarActividad(actividad);
		
	}

	public ActividadDTO obtenerInformacionDeActividad(int id_actividad) {
		return dal.obtenerInformacionDeActividad(id_actividad);
	}
	/*FIN ACTIVIDAD*/
	
	/*ASIGNATURA*/
	public Asignatura obtenerInformacionAsignatura(String tituloAsignatura){
		return dal.obtenerInformacionAsignatura(tituloAsignatura);
		}
	
	public Asignatura crearAsignatura(Asignatura asignatura){
	return dal.crearAsignatura(asignatura);
	}
	
	public List<Asignatura> obtenerAsignaturasPorCuatrimestre(int cuatrimestre) {
		return dal.obtenerAsignaturasPorCuatrimestre(cuatrimestre);
	}
	
	public boolean existeAsignatura(String nombreAsignatura) {
		return dal.existeAsignatura(nombreAsignatura);
	}
	
	public void eliminarAsignatura(int id_asignatura) {
		dal.eliminarAsignatura(id_asignatura);
		
	}
	
	public void editarAsignatura(Asignatura asignatura) {
		dal.editarAsignatura(asignatura);
		
	}
	/*FIN ASIGNATURA*/
	
	/*CLASE*/
	public Clase obtenerInformacionDeClase(int id_clase) {
		return dal.obtenerInformacionDeClase(id_clase);
	}

	public void eliminarClase(int id_clase) {
		 dal.eliminarClase(id_clase);
		
	}

	public Clase crearClase(Clase clase) {
		return dal.crearClase(clase);
	}

	public void editarClase(Clase clase) {
		dal.editarClase(clase);
		
	}
	/*FIN CLASE*/
	
	/*CUATRIMESTRE*/
	public Cuatrimestre obtenerInformacionCuatrimestre(int id_cuatrimestre){
		return dal.obtenerInformacionCuatrimestre(id_cuatrimestre);
	}
	
	public Cuatrimestre crearCuatrimestre(Cuatrimestre cuatrimestre){
		return dal.crearCuatrimestre(cuatrimestre);
	}

	public void eliminarCuatrimestre(int id_cuatrimestre) {
		dal.eliminarCuatrimestre(id_cuatrimestre);
		
	}
	
	public void editarCuatrimestre(Cuatrimestre cuatrimestre) {
		dal.editarCuatrimestre(cuatrimestre);
		
	}
	/*FIN CUATRIMESTRE*/
	
	/*CURSO*/ 
	public Curso obtenerInformacionCurso(int id_curso) {
		return dal.obtenerInformacionCurso(id_curso);
	}
	
	public void eliminarCurso(int id_curso) {
		dal.eliminarCurso(id_curso);
	}
	
	public Curso crearCurso(Curso curso) {
		return dal.crearCurso(curso);
	}
	/*FIN CURSO*/
	
	/*EXAMENCLASE*/
	public Examen_Clase obtenerInformacionDeExamen_Clase(int id) {
		return dal.obtenerInformacionDeExamen_Clase(id) ;
	}

	public void eliminarExamen_Clase(int id){
		dal.eliminarExamen_Clase(id);
		
	}

	public Examen_Clase crearExamen_Clase(Examen_Clase examenclase) {
		return dal.crearExamen_Clase(examenclase) ;
	}

	public void editarExamen_Clase(Examen_Clase examenclase) {
		dal.editarExamen_Clase(examenclase);
		
	}
	/*FIN EXAMENCLASE*/
	
	/*EXAMEN */
	public Examen obtenerInformacionDeExamen(int id) {
		return dal.obtenerInformacionDeExamen(id);
	}

	public void eliminarExamen(int id) {
		dal.eliminarExamen(id);
		
	}

	public Actividad_Examen crearExamen(Examen examen) {
	return dal.crearExamen(examen);
	}

	public void editarExamen(Examen examen) {
		dal.editarExamen(examen);
		
	}
	/*FIN EXAMEN*/
	
	/*EXAMENPOLIFORMAT*/
	public Examen_Poliformat obtenerInformacionDeExamenPoliformat(int id) {
		return dal.obtenerInformacionDeExamenPoliformat(id);
	}

	public void eliminarExamenPoliformat(int id) {
		dal.eliminarExamenPoliformat(id);
		
	}

	public Examen_Poliformat crearExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
		return dal.crearExamenPoliformat(ExamenPoliformat);
	}

	public void editarExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
		dal.editarExamenPoliformat(ExamenPoliformat);
		
	}
	/*FIN EXAMENPOLIFOTMAT*/
	
	/*EXAMENPRACTICAS*/
	public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id) {
		return dal.obtenerInformacionDeExamen_Practicas(id);
	}
	
	public void eliminarExamen_Practicas(int id) {
		dal.eliminarExamen_Practicas(id);
		
	}
	
	public void editarExamen_Practicas(Examen_Practicas examenPracticas) {
		dal.editarExamen_Practicas(examenPracticas);
		
	}
	
	public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas) {
		return dal.crearExamen_Practicas(examenPracticas);
	}
	/*FIN EXAMENPRACTICAS*/
	
	/*GRADO*/
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
	/*FIN GRADO*/
	/*NOTIFICACIONES*/
	public Notificacion obtenerInformacionDeNotificacion(int id_Notificacion) {
		return dal.obtenerInformacionDeNotificacion(id_Notificacion);
	}

	public void eliminarNotificacion(int id_Notificacion) {
		dal.eliminarNotificacion(id_Notificacion);
		
	}

	public Notificacion crearNotificacion(Notificacion notificacion) {
		return dal.crearNotificacion(notificacion);
	}

	public void editarNotificacion(Notificacion notificacion) {
	  dal.editarNotificacion(notificacion);
	}
	
	public List<Notificacion> notificacionesDeHoy(){
		return dal.obtenerNotificacionesDeHoy();
	}
	/*FIN NOTIFICACIONES*/
	/*PRACTICAS*/
	public Practicas obtenerInformacionDePracticas(int id_Practicas) {
		return dal.obtenerInformacionDePracticas(id_Practicas);
	}


	public void eliminarPracticas(int id_Practicas) {
		dal.eliminarPracticas(id_Practicas);
		
	}


	public Practicas crearPracticas(Practicas Practicas) {
	 return 	dal.crearPracticas(Practicas);
	}

	
	public void editarPracticas(Practicas Practicas) {
	  dal.editarPracticas(Practicas);
		
	}
	/*FIN PRACTICAS*/
	/*UNIVERSIDAD*/
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
	/*FIN UNIVERSIDAD*/
	
	/*USUARIO*/
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
		dal.editarUsuario(usuario);
	}
	
	public Usuario asociarUniversidadUsuario(Usuario usuario, int id_universidad){
	  return	dal.asociarUniversidadUsuario(usuario, id_universidad);
		
	}
	/*FIN USUARIO*/
	
}
