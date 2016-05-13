package persistence;

import java.util.List;

import bussines.*;
import persistence.dao.*;
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
		};
		
	}
	
	public static DAL getInstance(){
		if(instance == null){
			instance = new DAL();
		}
		return instance;
	}
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
