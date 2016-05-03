package test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import bussines.Usuario;
import persistence.UsuarioDAOImp;
import util.Basics;
import util.Date_Solver;

public class Pruebas_Persistencia {
	private static Scanner teclado;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teclado = new Scanner(System.in);	
		Date fecha = new Date();
		LocalDateTime l = LocalDateTime.now();
		
		System.out.println("Introduce Nombre de usuario: ");
		String nombre = teclado.nextLine();
		
		System.out.println("Introduce apellidos del usuario: ");
		String apellidos = teclado.nextLine();
		
		System.out.println("Introduce url foto de usuario: ");
		String foto = teclado.nextLine();
		
		System.out.println("Introduce email del usuario: ");
		String email = teclado.nextLine();
		
		String fechaUsuario = Basics.fechaByDate(fecha);
		System.out.println("Fecha de nacimineto por defecto del usuario: " + fechaUsuario);
		
		Usuario user = new Usuario(nombre, apellidos, foto,Date_Solver.formatLocalDateTime(l) , email);
		
		System.out.println("¿Desea continuar? S/N");
		String res = teclado.nextLine();
		
		if(res.equalsIgnoreCase("s")){
			UsuarioDAOImp dao = new UsuarioDAOImp();
			dao.crearUsuario(user);
		}
		
		UsuarioDAOImp d = new UsuarioDAOImp();
		System.out.println("Obtenido: "+d.obtenerInformacionDeUsuario(user.getId_usuario()));
		System.out.println("El usuario a guardar era: " + user);

		
	}

}
