package persistence;

import java.sql.ResultSet;

import bussines.Usuario;
import persistence.dao.UsuarioDAO;
import util.Constantes;
import util.Date_Solver;

public class UsuarioDAOImp implements UsuarioDAO{
	
	protected ConnectionManager connectionManager;
	
	
	public UsuarioDAOImp (){
		try{
			connectionManager= new ConnectionManager(Constantes.DATABASE);

		}catch(Exception e){
			System.err.println("Error en persistencia, UsuarioDAOImp: "+e.getLocalizedMessage());

		}
	}

	@Override
	public Usuario obtenerInformacionDeUsuario(int id_usuario) {
		Usuario user = null;
		try{
			connectionManager.connect();
			ResultSet usuario = connectionManager.queryDB("SELECT * from USUARIO where id_usuario = '"+id_usuario+"'");
			connectionManager.close();
		
			if (usuario.next()){
				user = new Usuario(
						usuario.getInt("ID_USUARIO"),
						usuario.getInt("ID_UNIVERSIDAD"),
						usuario.getString("NOMBRE"),
						usuario.getString("APELLIDOS"),
						usuario.getString("AVATAR"),
						Date_Solver.convertirDateSQLEnLocalDate( usuario.getDate("FECHA_NACIMIENTO")),
						usuario.getString("EMAIL")
							);
				//saber cuantos caracteres tiene un atributo
				System.out.println("El usuario tiene de  nombre:" + user.getNombre()+" y contiene: " + user.getNombre().toCharArray().length + " caracteres");
			}else
				return null;	
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar al usuario: "+e.getLocalizedMessage() );
		}
		return user;
	}

	@Override
	public void eliminarUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.USUARIO_SQ);
			if(id>0){
				String str = "INSERT INTO USUARIO (ID_USUARIO, ID_UNIVERSIDAD, NOMBRE, APELLIDOS, AVATAR, FECHA_NACIMIENTO, EMAIL) " + 
							 "VALUES ("+
							 id+","+
							 usuario.getUniversidad()+",'"+
							 usuario.getNombre() +"','"+
							 usuario.getApellidos() +"','"+
							 usuario.getAvatar() +"','"+
							 Date_Solver.convertirLocalDateEnSQL(usuario.getFechanacimiento())+"','"+
							 usuario.getEmail()+"'"+
							 ")";
	
				usuario.setId_usuario(id);
				connectionManager.updateDB(str);
				System.out.println("Usuario creado con éxito: " + usuario);
			}
			connectionManager.close();
			
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el usuario: "+e.getLocalizedMessage() );
		}
		
	}

	
	@Override
	public int crearSecuencia(String nombreSecuencia){
		try{
		ResultSet sq = connectionManager.queryDB("CALL NEXT VALUE FOR " + nombreSecuencia);

		if (sq.next())
			return sq.getInt(1);

		}catch(Exception e){
		   System.err.println("Ha ocurrido un error al generar la secuencia de id "+e.getLocalizedMessage());
		}
		return -1;

	}

	@Override
	public void editarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asociarUniversidadUsuario(int id_univerisdad) {
		// TODO Auto-generated method stub
		
	}

}
