package persistence;

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
			public void crearUsuario(Usuario usuario) {
				 new UsuarioDAOImp().crearUsuario(usuario);		
			}

			@Override
			public Usuario asociarUniversidadUsuario(Usuario usuario, int id_univerisdad) {
				return new UsuarioDAOImp().asociarUniversidadUsuario(usuario, id_univerisdad);
			}
		};
		
		
	}
	
	public static DAL getInstance(){
		if(instance == null){
			instance = new DAL();
		}
		return instance;
	}

	/* USUARIO */
	public Usuario obtenerInformacionDeUsuario(int id_usuario){
		return usuarioDAO.obtenerInformacionDeUsuario(id_usuario);
	}
	
	public void eliminarUsuario(int id_usuario){
		usuarioDAO.eliminarUsuario(id_usuario);
	}
	
	public void crearUsuario( Usuario usuario ){
		usuarioDAO.crearUsuario(usuario);
	}
	
	public Usuario buscarUsuario(int id_usuario){
		return usuarioDAO.obtenerInformacionDeUsuario(id_usuario);
	}
	
	public Usuario asociarUniversidadUsuario(Usuario usuario, int id_universidad){
		return usuarioDAO.asociarUniversidadUsuario(usuario, id_universidad);
	}
	/* FIN USUARIO */
	
	
	
	
}
