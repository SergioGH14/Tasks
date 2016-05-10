package persistence;

import java.sql.ResultSet;

import Util.Constantes;
import Util.Date_Solver;
import bussines.Usuario;
import persistence.dao.UsuarioDAO;

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
						new UniversidadDAOImp().obtenerInformacionDeUniversidad(usuario.getInt("ID_UNIVERSIDAD")),
						usuario.getString("NOMBRE"),
						usuario.getString("APELLIDOS"),
						usuario.getString("AVATAR"),
						Date_Solver.convertirDateSQLEnLocalDateTime( usuario.getDate("FECHA_NACIMIENTO")),
						usuario.getString("EMAIL") );
				//saber cuantos caracteres tiene un atributo
				//System.out.println("El usuario tiene de  nombre:" + user.getNombre()+" y contiene: " + user.getNombre().toCharArray().length + " caracteres");
			}
		}catch(Exception e){
			System.err.println("Ha ocurrido un error al buscar al usuario: "+e.getLocalizedMessage() );
		}
		return user;
	}

	@Override
	public void eliminarUsuario(int id_usuario) {
		try{
			connectionManager.connect();
			String str = "DELETE FROM USUARIO WHERE id_usuario="+ id_usuario ;
			connectionManager.updateDB(str);


			System.out.println("\nUsuario eliminado con éxito: ");
			connectionManager.close();


		}catch(Exception e){
			System.err.println("Ha ocurrido un error al eliminar el usuario: "+e.getLocalizedMessage() );
		}


	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		try{
			connectionManager.connect();
			int id = crearSecuencia(Constantes.USUARIO_SQ);
			if(id>0){
				String str = "INSERT INTO USUARIO (ID_USUARIO, ID_UNIVERSIDAD, NOMBRE, APELLIDOS, AVATAR, FECHA_NACIMIENTO, EMAIL) " +
							 "VALUES ("+
							 id+","+
							 usuario.getUniversidad().getId_universidad()+",'"+
							 usuario.getNombre() +"','"+
							 usuario.getApellidos() +"','"+
							 usuario.getAvatar() +"','"+
							 Date_Solver.convertirLocalDateEnSQL(usuario.getFechanacimiento())+"','"+
							 usuario.getEmail()+"'"+
							 ")";

				usuario.setId_usuario(id);
				connectionManager.updateDB(str);
				System.out.println("\nUsuario creado con éxito: " + usuario);
			}
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al crear el usuario: "+e.getLocalizedMessage() );
		}
		return usuario;

	}

	@Override
	public void editarUsuario(Usuario usuario) {
		try{
			connectionManager.connect();
			String str = "UPDATE USUARIO "+
						 "SET id_universidad= "+usuario.getUniversidad().getId_universidad()+", "+
						 "SET nombre= '"+usuario.getNombre() +"', "+
						 "SET apellidos= '"+usuario.getApellidos() +"', "+
						 "SET avatar= '"+ usuario.getAvatar() +"', "+
						 "SET fecha_nacimiento= '"+Date_Solver.convertirLocalDateEnSQL(usuario.getFechanacimiento())+"', "+
						 "SET email= '"+usuario.getEmail()+"' "+
						 " WHERE id_usuario=" + usuario.getId_usuario() +")";
			connectionManager.updateDB(str);
			System.out.println("\nUsuario editado con éxito: " + usuario);
			connectionManager.close();

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar el usuario: "+e.getLocalizedMessage() );
		}

	}

	@Override
	public Usuario asociarUniversidadUsuario(Usuario usuario, int id_univerisdad) {
		try{
			connectionManager.connect();
			String str = "UPDATE USUARIO SET id_universidad="+ id_univerisdad +" where id_usuario="+ usuario.getId_usuario();
			connectionManager.updateDB(str);

			Usuario auxiliar = usuario;
			auxiliar.getUniversidad().setId_universidad(id_univerisdad);

			System.out.println("\nUsuario con nueva universidad: " + auxiliar);
			connectionManager.close();

			return auxiliar;

		}catch(Exception e){
			System.err.println("Ha ocurrido un error al editar el usuario y ponerle su universidad: "+e.getLocalizedMessage() );
		}

		return null;
	}


	private int crearSecuencia(String nombreSecuencia){
		try{
		ResultSet sq = connectionManager.queryDB("CALL NEXT VALUE FOR " + nombreSecuencia);

		if (sq.next())
			return sq.getInt(1);

		}catch(Exception e){
		   System.err.println("Ha ocurrido un error al generar la secuencia de id "+e.getLocalizedMessage());
		}
		return -1;

	}

}
