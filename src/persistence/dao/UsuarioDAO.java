package persistence.dao;

import bussines.Usuario;

public interface UsuarioDAO {
	
	public Usuario obtenerInformacionDeUsuario(int id_usuario);
	
	public void eliminarUsuario();
	
	public void crearUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);
	
	public int crearSecuencia(String nombreSecuencia);
	
	public void asociarUniversidadUsuario(int id_univerisdad);


}
