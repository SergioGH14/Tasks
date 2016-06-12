
package persistence;

import java.util.List;

import bussines.*;
import persistence.dao.*;
import persistence.dto.ActividadDTO;
/*
 * Capa previa a persistencia,intermedia entre la fachada y la persistencia
 */
public class DAL {
	private static DAL instance;
	
	private ActividadDAO actividadDAO;
	private AsignaturaDAO asignaturaDAO;
	private ClaseDAO claseDAO;
	private CuatrimestreDAO cuatrimestreDAO;
	private CursoDAO cursoDAO;
	private ExamenClaseDAO examenClaseDAO;
	private ExamenDAO examenDAO;
	private ExamenPoliformatDAO examenPoliformatDAO;
	private ExamenPracticasDAO examenPracticasDAO;
	private GradoDAO gradoDAO;
	private NotificacionDAO notificacionDAO;
	private PracticasDAO practicasDAO;
	private UsuarioDAO usuarioDAO;
	private UniversidadDAO universidadDAO;
		
	private DAL(){
		
		actividadDAO = new ActividadDAO(){

			@Override
			public void eliminarActividad(int id_actividad) {
				new ActividadDAOImp().eliminarActividad(id_actividad);
				
			}

			@Override
			public Actividad crearActividad(Actividad actividad) {
			
				return new ActividadDAOImp().crearActividad(actividad);
			}

			@Override
			public void editarActividad(ActividadDTO actividad) {
				new ActividadDAOImp().editarActividad(actividad);
				
			}

			@Override
			public ActividadDTO obtenerInformacionDeActividad(int id_actividad) {
				return new ActividadDAOImp().obtenerInformacionDeActividad(id_actividad);
			}

			@Override
			public ActividadDTO obtenerInformacionDeActividadExamen(int id_actividad_examen) {
				return new ActividadDAOImp().obtenerInformacionDeActividadExamen(id_actividad_examen);
			}

			@Override
			public void marcarComoHecha(int id_actividad) {
				new ActividadDAOImp().marcarComoHecha(id_actividad);
			}

			@Override
			public void marcarParaDespues(int id_actividad) {
				new ActividadDAOImp().marcarParaDespues(id_actividad);
			}
			
		};
		
	    asignaturaDAO = new AsignaturaDAO() {
			
			@Override
			public Asignatura obtenerInformacionAsignatura(String nombreAsignatura) {
				return new AsignaturaDAOImp().obtenerInformacionAsignatura(nombreAsignatura);
			}
			
			@Override
			public List<Asignatura> obtenerAsignaturasPorCuatrimestre(int cuatrimestre) {
				return new AsignaturaDAOImp().obtenerAsignaturasPorCuatrimestre(cuatrimestre);
			}
			
			@Override
			public boolean existeAsignatura(String nombreAsignatura) {
				return new AsignaturaDAOImp().existeAsignatura(nombreAsignatura);
			}
			
			@Override
			public void eliminarAsignatura(int id_asignatura) {
				new AsignaturaDAOImp().eliminarAsignatura(id_asignatura);
				
			}
			
			@Override
			public void editarAsignatura(Asignatura asignatura) {
				new AsignaturaDAOImp().editarAsignatura(asignatura);
				
			}
			
			@Override
			public Asignatura crearAsignatura(Asignatura asignatura) {
				return new AsignaturaDAOImp().crearAsignatura(asignatura);
			}

			@Override
			public Asignatura obtenerInformacionAsignatura(int id_asignatura) {
				return new AsignaturaDAOImp().obtenerInformacionAsignatura(id_asignatura);
			}
		};
		
		claseDAO = new ClaseDAO(){

			@Override
			public Clase obtenerInformacionDeClase(int id_clase) {
				return new ClaseDAOImp().obtenerInformacionDeClase(id_clase);
			}

			@Override
			public void eliminarClase(int id_clase) {
				new ClaseDAOImp().eliminarClase(id_clase);
				
			}

			@Override
			public Clase crearClase(Clase clase) {
				return new ClaseDAOImp().crearClase(clase);
			}

			@Override
			public void editarClase(Clase clase) {
				new ClaseDAOImp().editarClase(clase);
				
			}

			@Override
			public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura) {
				return new ClaseDAOImp().obtenerActividadesDeAsignatura(asignatura);
			}

			@Override
			public List<Actividad> obtenerTodasActividades() {
				return new ClaseDAOImp().obtenerTodasActividades();
			}

			@Override
			public List<Actividad> obtenerActividadesHoy() {
				return new ClaseDAOImp().obtenerActividadesHoy();
			}

			@Override
			public List<Actividad> obtenerActividadesParaDespues() {
				return new ClaseDAOImp().obtenerActividadesParaDespues();
			}
			
		};
		
        cuatrimestreDAO = new CuatrimestreDAO() {
			
			@Override
			public Cuatrimestre obtenerInformacionCuatrimestre(int id_cuatrimestre) {
				return new CuatrimestreDAOImp().obtenerInformacionCuatrimestre(id_cuatrimestre);
			}
			
			@Override
			public void eliminarCuatrimestre(int id_cuatrimestre) {
				new CuatrimestreDAOImp().eliminarCuatrimestre(id_cuatrimestre);
				
			}
			
			@Override
			public void editarCuatrimestre(Cuatrimestre cuatrimestre) {
				new CuatrimestreDAOImp().editarCuatrimestre(cuatrimestre);
				
			}
			
			@Override
			public Cuatrimestre crearCuatrimestre(Cuatrimestre cuatrimestre) {
				return new CuatrimestreDAOImp().crearCuatrimestre(cuatrimestre);
			}
		};
		
      	cursoDAO = new CursoDAO() {
			
			@Override
			public Curso obtenerInformacionCurso(int id_curso) {
				return new CursoDAOImp().obtenerInformacionCurso(id_curso);
			}
			
			@Override
			public void eliminarCurso(int id_curso) {
				new CursoDAOImp().eliminarCurso(id_curso);
			}
			
			@Override
			public Curso crearCurso(Curso curso) {
				return new CursoDAOImp().crearCurso(curso);
			}
		};
		
		examenClaseDAO = new ExamenClaseDAO(){

			@Override
			public Examen_Clase obtenerInformacionDeExamen_Clase(int id) {
				return new ExamenClaseDAOImp().obtenerInformacionDeExamen_Clase(id) ;
			}

			@Override
			public void eliminarExamen_Clase(int id){
				new ExamenClaseDAOImp().eliminarExamen_Clase(id);
				
			}

			@Override
			public Examen_Clase crearExamen_Clase(Examen_Clase examenclase) {
				return new ExamenClaseDAOImp().crearExamen_Clase(examenclase) ;
			}

			@Override
			public void editarExamen_Clase(Examen_Clase examenclase) {
				new ExamenClaseDAOImp().editarExamen_Clase(examenclase);
				
			}
		};
		
		examenDAO = new ExamenDAO(){

			@Override
			public Actividad_Examen obtenerInformacionDeExamen(int id) {
				return new ExamenDAOImp().obtenerInformacionDeExamen(id);
			}

			@Override
			public void eliminarExamen(int id) {
				new ExamenDAOImp().eliminarExamen(id);
				
			}

			@Override
			public Actividad_Examen crearExamen(Actividad_Examen examen) {
			return new ExamenDAOImp().crearExamen(examen);
			}

			@Override
			public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura) {
				return new ExamenDAOImp().obtenerActividadesDeAsignatura(asignatura);
			}

			@Override
			public List<Actividad> obtenerTodasActividades() {
				return new ExamenDAOImp().obtenerTodasActividades();
			}

			@Override
			public List<Actividad> obtenerActividadesHoy() {
				return new ExamenDAOImp().obtenerActividadesHoy();
			}

			@Override
			public List<Actividad> obtenerActividadesParaDespues() {
				return new ExamenDAOImp().obtenerActividadesParaDespues();
			}

			@Override
			public Actividad_Examen obtenerInformacionDeExamenSinDecoracion(int id_examen_concreto) {
				return new ExamenDAOImp().obtenerInformacionDeExamen(id_examen_concreto);
			}
			
		};

		examenPoliformatDAO = new ExamenPoliformatDAO(){

			@Override
			public Examen_Poliformat obtenerInformacionDeExamenPoliformat(int id) {
				return new ExamenPoliformatDAOImp().obtenerInformacionDeExamenPoliformat(id);
			}

			@Override
			public void eliminarExamenPoliformat(int id) {
				new ExamenPoliformatDAOImp().eliminarExamenPoliformat(id);
				
			}

			@Override
			public Examen_Poliformat crearExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
				return new ExamenPoliformatDAOImp().crearExamenPoliformat(ExamenPoliformat);
			}

			@Override
			public void editarExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
				new ExamenPoliformatDAOImp().editarExamenPoliformat(ExamenPoliformat);
				
			}

		};

		examenPracticasDAO = new ExamenPracticasDAO() {
			
			@Override
			public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id) {
				return new ExamenPracticasDAOImp().obtenerInformacionDeExamen_Practicas(id);
			}
			
			@Override
			public void eliminarExamen_Practicas(int id) {
				new ExamenPracticasDAOImp().eliminarExamen_Practicas(id);
				
			}
			
			@Override
			public void editarExamen_Practicas(Examen_Practicas examenPracticas) {
				new ExamenPracticasDAOImp().editarExamen_Practicas(examenPracticas);
				
			}
			
			@Override
			public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas) {
				return new ExamenPracticasDAOImp().crearExamen_Practicas(examenPracticas);
			}

		};
		
	    gradoDAO = new GradoDAO() {
			
			@Override
			public Grado obtenerInformacionGrado(int id_grado) {
				return new GradoDAOImp().obtenerInformacionGrado(id_grado);
			}
			
			@Override
			public void eliminarGrado(int id_grado) {
				new GradoDAOImp().eliminarGrado(id_grado);
			}
			
			@Override
			public void editarGrado(Grado grado) {
				new GradoDAOImp().editarGrado(grado);
			}
			
			@Override
			public Grado crearGrado(Grado grado) {
				return new GradoDAOImp().crearGrado(grado);
			}
		};

		notificacionDAO = new NotificacionDAO(){

			@Override
			public Notificacion obtenerInformacionDeNotificacion(int id_Notificacion) {
				return new NotificacionDAOImp().obtenerInformacionDeNotificacion(id_Notificacion);
			}

			@Override
			public void eliminarNotificacion(int id_Notificacion) {
				new NotificacionDAOImp().eliminarNotificacion(id_Notificacion);
				
			}

			@Override
			public Notificacion crearNotificacion(Notificacion notificacion) {
				return new NotificacionDAOImp().crearNotificacion(notificacion);
			}

			@Override
			public void editarNotificacion(Notificacion notificacion) {
			  new NotificacionDAOImp().editarNotificacion(notificacion);
			}
			
			@Override
			public List<Notificacion> obtenerNotificacionesDeHoy (){
				return new NotificacionDAOImp().obtenerNotificacionesDeHoy();
			}
		};
		
		practicasDAO = new PracticasDAO(){

			@Override
			public Practicas obtenerInformacionDePracticas(int id_Practicas) {
				return new PracticasDAOImp().obtenerInformacionDePracticas(id_Practicas);
			}

			@Override
			public void eliminarPracticas(int id_Practicas) {
				new PracticasDAOImp().eliminarPracticas(id_Practicas);
				
			}

			@Override
			public Practicas crearPracticas(Practicas Practicas) {
				return new PracticasDAOImp().crearPracticas(Practicas);
			}

			@Override
			public void editarPracticas(Practicas Practicas) {
			   new PracticasDAOImp().editarPracticas(Practicas);
				
			}

			@Override
			public List<Actividad> obtenerActividadesDeAsignatura(Asignatura asignatura){
				return new PracticasDAOImp().obtenerActividadesDeAsignatura(asignatura);
			}
			
			@Override
			public List<Actividad> obtenerTodasActividades(){
				return new PracticasDAOImp().obtenerTodasActividades();
			}
			
			@Override
			public List<Actividad> obtenerActividadesHoy(){
				return new PracticasDAOImp().obtenerActividadesHoy();
			}
			
			@Override
			public List<Actividad> obtenerActividadesParaDespues(){
				return new PracticasDAOImp().obtenerActividadesParaDespues();
			}
			
		};
		
		universidadDAO = new UniversidadDAO() {
			
			@Override
			public Universidad obtenerInformacionDeUniversidad(int id_universidad) {
				return new UniversidadDAOImp().obtenerInformacionDeUniversidad(id_universidad);
			}
			
			@Override
			public void eliminarUniversidad(int id_universidad) {
				new UniversidadDAOImp().eliminarUniversidad(id_universidad);
				
			}
			
			@Override
			public void editarUniversiad(Universidad universidad) {
				new UniversidadDAOImp().editarUniversiad(universidad);
			}
			
			@Override
			public Universidad crearUniversidad(Universidad universidad) {
				return new UniversidadDAOImp().crearUniversidad(universidad);
				
			}
		};
		
	    usuarioDAO = new UsuarioDAO() {
				
				@Override
				public Usuario obtenerInformacionDeUsuario(int id_usuario) {
					return new UsuarioDAOImp().obtenerInformacionDeUsuario(id_usuario);
				}
				
				@Override
				public void eliminarUsuario(int id_usuario) {
					new UsuarioDAOImp().eliminarUsuario(id_usuario);
				}
				
				@Override
				public void editarUsuario(Usuario usuario) {
					new UsuarioDAOImp().editarUsuario(usuario);
				}
				
				@Override
				public Usuario crearUsuario(Usuario usuario) {
					 return new UsuarioDAOImp().crearUsuario(usuario);		
				}

				@Override
				public Usuario asociarUniversidadUsuario(Usuario usuario, int id_univerisdad) {
					return new UsuarioDAOImp().asociarUniversidadUsuario(usuario, id_univerisdad);
				}

				@Override
				public boolean existeUsuario() {
					return new UsuarioDAOImp().existeUsuario();
				}
				
				
			};
	
		
	}
	
	public static DAL getInstance(){
		if(instance == null){
			instance = new DAL();
		}
		return instance;
	}
	
	/*ACTIVIDAD*/
	public ActividadDTO obtenerInformacionDeActividad(int id_actividad){
		return actividadDAO.obtenerInformacionDeActividad(id_actividad);
	}

	public void eliminarActividad(int id_actividad) {
		actividadDAO.eliminarActividad(id_actividad);
		
	}

	public Actividad crearActividad(Actividad actividad) {
	
		return  actividadDAO.crearActividad(actividad);
	}

	public void editarActividad(ActividadDTO actividad) {
		actividadDAO.editarActividad(actividad);
		
	}

	public void marcarComoHecha(int id_actividad) {
		actividadDAO.marcarComoHecha(id_actividad);
	}

	public void marcarParaDespues(int id_actividad) {
		actividadDAO.marcarParaDespues(id_actividad);
	}

	 /*FIN ACTIVIDAD*/
	
	/* ASIGNATURA */ 
	public Asignatura obtenerInformacionAsignatura(String nombreAsignatura){
		return asignaturaDAO.obtenerInformacionAsignatura(nombreAsignatura);
	}
	
	public List<Asignatura> obtenerAsignaturasPorCuatrimestre(int cuatrimestre){
		return asignaturaDAO.obtenerAsignaturasPorCuatrimestre(cuatrimestre);
	}
	
	public Asignatura crearAsignatura(Asignatura asignatura){
		return asignaturaDAO.crearAsignatura(asignatura);
	}

	public void editarAsignatura(Asignatura asignatura){
		asignaturaDAO.editarAsignatura(asignatura);
	}
	
	public void eliminarAsignatura(int id_asignatura){
		asignaturaDAO.eliminarAsignatura(id_asignatura);
	}
	
	public boolean existeAsignatura(String nombreAsignatura){
		return asignaturaDAO.existeAsignatura(nombreAsignatura);
	}
	
	public Asignatura obtenerInformacionAsignatura(int id_asignatura) {
		return asignaturaDAO.obtenerInformacionAsignatura(id_asignatura);
	}
	/*FIN ASIGNATURA*/
	
	/*CLASE*/
	public Clase obtenerInformacionDeClase(int id_clase) {
		return claseDAO.obtenerInformacionDeClase(id_clase);
	}

	public void eliminarClase(int id_clase) {
		claseDAO.eliminarClase(id_clase);
		
	}

	public Clase crearClase(Clase clase) {
		return claseDAO.crearClase(clase);
	}
	
	public void editarClase(Clase clase) {
		claseDAO.editarClase(clase);
		
	}
	
	public List<Actividad> obtenerClasesDeAsignatura(Asignatura asignatura) {
		return claseDAO.obtenerActividadesDeAsignatura(asignatura);
	}

	public List<Actividad> obtenerTodasClases() {
		return claseDAO.obtenerTodasActividades();
	}

	public List<Actividad> obtenerClasesHoy() {
		return claseDAO.obtenerActividadesHoy();
	}

	public List<Actividad> obtenerClasesParaDespues() {
		return claseDAO.obtenerActividadesParaDespues();
	}
	
	/*FIN CLASE*/
	
	/* CUATRIMESTRE */
	public Cuatrimestre obtenerInformacionCuatrimestre(int id_cuatrimestre){
		return cuatrimestreDAO.obtenerInformacionCuatrimestre(id_cuatrimestre);
	}
	
	public void eliminarCuatrimestre(int id_cuatrimestre){
		cuatrimestreDAO.eliminarCuatrimestre(id_cuatrimestre);
	}
	
	public Cuatrimestre crearCuatrimestre(Cuatrimestre cuatrimestre){
		return cuatrimestreDAO.crearCuatrimestre(cuatrimestre);
	}
	
	public void editarCuatrimestre(Cuatrimestre cuatrimestre){
		cuatrimestreDAO.editarCuatrimestre(cuatrimestre);
	}
	/*FIN CUATRIMESTRE*/
	
	/* CURSO */
	public Curso obtenerInformacionCurso(int id_curso) {
		return cursoDAO.obtenerInformacionCurso(id_curso);
	}
	
	public void eliminarCurso(int id_curso) {
		cursoDAO.eliminarCurso(id_curso);
	}
	
	public Curso crearCurso(Curso curso) {
		return cursoDAO.crearCurso(curso);
	}
	/*FIN CURSO*/
	
	/*EXAMEN_CLASE*/
	public Examen_Clase obtenerInformacionDeExamen_Clase(int id) {
		return examenClaseDAO.obtenerInformacionDeExamen_Clase(id) ;
	}

	public void eliminarExamen_Clase(int id){
		examenClaseDAO.eliminarExamen_Clase(id);
		
	}

	public Examen_Clase crearExamen_Clase(Examen_Clase examenclase) {
		return examenClaseDAO.crearExamen_Clase(examenclase) ;
	}

	public void editarExamen_Clase(Examen_Clase examenclase) {
		examenClaseDAO.editarExamen_Clase(examenclase);
		
	}
	/*FIN EXAMEN_CLASE*/
	
	/*EXAMEN*/
	public Actividad_Examen obtenerInformacionDeExamen(int id) {
		return examenDAO.obtenerInformacionDeExamen(id);
	}

	public void eliminarExamen(int id) {
		examenDAO.eliminarExamen(id);
		
	}

	public Actividad_Examen crearExamen(Actividad_Examen examen) {
	return examenDAO.crearExamen(examen);
	}
	
	public List<Actividad> obtenerExamenesDeAsignatura(Asignatura asignatura) {
		return examenDAO.obtenerActividadesDeAsignatura(asignatura);
	}

	public List<Actividad> obtenerTodosExamenes() {
		return examenDAO.obtenerTodasActividades();
	}

	public List<Actividad> obtenerExamenesHoy() {
		return examenDAO.obtenerActividadesHoy();
	}

	public List<Actividad> obtenerExamenesParaDespues() {
		return examenDAO.obtenerActividadesParaDespues();
	}
	/*FIN EXAMEN*/
	
	/*EXAMEN_POLIFORMAT*/
	public Examen_Poliformat obtenerInformacionDeExamenPoliformat(int id) {
		return examenPoliformatDAO.obtenerInformacionDeExamenPoliformat(id);
	}

	public void eliminarExamenPoliformat(int id) {
	  examenPoliformatDAO.eliminarExamenPoliformat(id);
		
	}

	public Examen_Poliformat crearExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
		return examenPoliformatDAO.crearExamenPoliformat(ExamenPoliformat);
	}

	public void editarExamenPoliformat(Examen_Poliformat ExamenPoliformat) {
		examenPoliformatDAO.editarExamenPoliformat(ExamenPoliformat);
		
	}
	/*FIN EXAMEN_POLIFORMAT*/
	
	/*EXAMEN_PRACTICAS*/
	public Examen_Practicas obtenerInformacionDeExamen_Practicas(int id) {
		return examenPracticasDAO.obtenerInformacionDeExamen_Practicas(id);
	}
	
	public void eliminarExamen_Practicas(int id) {
		 examenPracticasDAO.eliminarExamen_Practicas(id);
		
	}

	public void editarExamen_Practicas(Examen_Practicas examenPracticas) {
		examenPracticasDAO.editarExamen_Practicas(examenPracticas);
		
	}
	
	public Examen_Practicas crearExamen_Practicas(Examen_Practicas examenPracticas) {
		return examenPracticasDAO.crearExamen_Practicas(examenPracticas);
	}
	/*FIN EXAMEN_PRACTICAS*/
	
	/* GRADO */
	public Grado obtenerInformacionGrado(int id_grado){
		return gradoDAO.obtenerInformacionGrado(id_grado);
	}
	
	public void eliminarGrado(int id_grado) {
		gradoDAO.eliminarGrado(id_grado);
	}
	
	public void editarGrado(Grado grado) {
		gradoDAO.editarGrado(grado);
	}
	
	public Grado crearGrado(Grado grado) {
		return gradoDAO.crearGrado(grado);
	}
	/* FIN GRADO */
	
	/*NOTIFICACION*/
	public Notificacion obtenerInformacionDeNotificacion(int id_Notificacion) {
		return notificacionDAO.obtenerInformacionDeNotificacion(id_Notificacion);
	}

	public void eliminarNotificacion(int id_Notificacion) {
		notificacionDAO.eliminarNotificacion(id_Notificacion);
		
	}

	public Notificacion crearNotificacion(Notificacion notificacion) {
		return notificacionDAO.crearNotificacion(notificacion);
	}

	public void editarNotificacion(Notificacion notificacion) {
	  notificacionDAO.editarNotificacion(notificacion);
	  
	}
	
	public List<Notificacion> obtenerNotificacionesDeHoy (){
		return notificacionDAO.obtenerNotificacionesDeHoy();
	}
	/*FIN NOTIFICACION*/
	
	/*PRACTICAS*/
	public Practicas obtenerInformacionDePracticas(int id_Practicas) {
		return practicasDAO.obtenerInformacionDePracticas(id_Practicas);
	}

	public void eliminarPracticas(int id_Practicas) {
		practicasDAO.eliminarPracticas(id_Practicas);
		
	}

	public Practicas crearPracticas(Practicas Practicas) {
		return practicasDAO.crearPracticas(Practicas);
	}

	public void editarPracticas(Practicas Practicas) {
	   practicasDAO.editarPracticas(Practicas);
		
	}
	
	public List<Actividad> obtenerPracticasDeAsignatura(Asignatura asignatura){
		return practicasDAO.obtenerActividadesDeAsignatura(asignatura);
	}

	public List<Actividad> obtenerTodasPracticas(){
		return practicasDAO.obtenerTodasActividades();
	}
		
	public List<Actividad> obtenerPracticasHoy(){
		return practicasDAO.obtenerActividadesHoy();
	}
	
	public List<Actividad> obtenerPracticasParaDespues(){
		return practicasDAO.obtenerActividadesParaDespues();
	}
	/*FIN PRACTICAS*/
	
	/* USUARIO */
	public Usuario obtenerInformacionDeUsuario(int id_usuario){
		return usuarioDAO.obtenerInformacionDeUsuario(id_usuario);
	}
	
	public void eliminarUsuario(int id_usuario){
		usuarioDAO.eliminarUsuario(id_usuario);
	}
	
	public Usuario crearUsuario( Usuario usuario ){
		return usuarioDAO.crearUsuario(usuario);
	}
	
	public Usuario buscarUsuario(int id_usuario){
		return usuarioDAO.obtenerInformacionDeUsuario(id_usuario);
	}
	
	public Usuario asociarUniversidadUsuario(Usuario usuario, int id_universidad){
		return usuarioDAO.asociarUniversidadUsuario(usuario, id_universidad);
	}
	
	public boolean existeUsuario(){
		return usuarioDAO.existeUsuario();
	}
	
	public void editarUsuario(Usuario usuario){
		 usuarioDAO.editarUsuario(usuario);
	}
	/* FIN USUARIO */
	
	/* UNIVERSIDAD */
	public Universidad crearUniversidad(Universidad universidad){
		return universidadDAO.crearUniversidad(universidad);
	}
	
	public Universidad obtenerInformacionDeUniversidad(int id_universidad){
		return universidadDAO.obtenerInformacionDeUniversidad(id_universidad);
	}
	
	public void eliminarUniversidad(int id_universidad){
		universidadDAO.eliminarUniversidad(id_universidad);
	}
	
	public void editarUniversidad(Universidad universidad){
		universidadDAO.editarUniversiad(universidad);
	}
	/* FIN UNIVERSIDAD */
	
}
