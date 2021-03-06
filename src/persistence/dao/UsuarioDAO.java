package persistence.dao;

import bussines.Usuario;

public interface UsuarioDAO {
	
	public Usuario obtenerInformacionDeUsuario(int id_usuario);
	
	public void eliminarUsuario(int id_usuario);
	
	public Usuario crearUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);
		
	public Usuario asociarUniversidadUsuario(Usuario usuario, int id_univerisdad);

	public boolean existeUsuario();
}
