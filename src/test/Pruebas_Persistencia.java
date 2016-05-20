package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Util.Basics;
import Util.Date_solver;
import bussines.Actividad;
import bussines.Asignatura;
import bussines.Cuatrimestre;
import bussines.Curso;
import bussines.Grado;
import bussines.Universidad;
import bussines.Usuario;
import persistence.CursoDAOImp;
import persistence.DAL;
import persistence.GradoDAOImp;
import persistence.UniversidadDAOImp;
import persistence.UsuarioDAOImp;

public class Pruebas_Persistencia {
	private static Scanner teclado;

	public static void main(String[] args) {
		/*teclado = new Scanner(System.in);	
		LocalDateTime l = LocalDateTime.now();
		
		System.out.println("Existen usuario: " +  DAL.getInstance().existeUsuario()+"\n");
		
		System.out.println("Introduce el nombre de tu universidad: ");
		String nombreuni = teclado.nextLine();
		
		System.out.println("Introduce la dirección de tu universidad: ");
		String direccionuni = teclado.nextLine();
		
		Universidad universidad = new UniversidadDAOImp().crearUniversidad(new Universidad("./logo_universidad.png", nombreuni, direccionuni));
		
		System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n" + " La universidad creada es: " +universidad);
		
		
		System.out.println("Introduce Nombre de usuario: ");
		String nombre = teclado.nextLine();
		
		System.out.println("Introduce Apellidos del usuario: ");
		String apellidos = teclado.nextLine();
		
		System.out.println("Introduce url foto de usuario: ");
		String foto = teclado.nextLine();
		
		System.out.println("Introduce email del usuario: ");
		String email = teclado.nextLine();
			
		//usuario inicialmente con universidad previamente creada
		Usuario user = new Usuario(universidad,nombre, apellidos, foto, Date_solver.formatLocalDateTime(l) , email);
		
		System.out.println("¿Desea continuar para crear el usuario en persistencia? S/N");
		String res = teclado.nextLine();
		
		if(res.equalsIgnoreCase("s")){
			DAL dal = DAL.getInstance();
			dal.crearUsuario(user);
			System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n" + " USUARIO CREADO CON ÉXITO");
		}
		
		UsuarioDAOImp d = new UsuarioDAOImp();
		System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n" + "USUARIO OBTENIDO: "+d.obtenerInformacionDeUsuario(user.getId_usuario()));

		
		System.out.println("¿Desea asignarle una unversidad al usuario? S/N");
		String res2 = teclado.nextLine();
		
		if(res2.equalsIgnoreCase("s")){
			UsuarioDAOImp dao = new UsuarioDAOImp();
			dao.asociarUniversidadUsuario(user, universidad.getId_universidad());
			System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n" + " USUARIO ASIGNADO A UNIVERSIDAD");
		}
		
		System.out.println("\nVamos a crear un grado, como se llama tu titulacion:");
		String titulacion = teclado.nextLine();
		Grado grado = new Grado(universidad, titulacion, l);
		
		GradoDAOImp gimp = new GradoDAOImp();
		grado = gimp.crearGrado(grado);
		
		System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n" + " GRADO CREADO: " + grado);
		
		System.out.println("Se está creando el curso... ");
		Curso curso = new Curso(grado, l, 63.0);
		CursoDAOImp cur = new CursoDAOImp();
		
		curso = cur.crearCurso(curso);
		System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n" + " CURSO CREADO: " + curso);
		
		probarHastaAsignatura(curso);

		*/
		System.out.println("VAMOS A RECUPERAR UNA ACTIVIDAD DE PRACTICAS");
		Actividad practicas = DAL.getInstance().getInstance().obtenerInformacionDePracticas(1);
		System.out.println("practica: " + practicas);
	}

	private static void probarHastaAsignatura(Curso curso) {
		// TODO Auto-generated method stub
		System.out.println("\nVamos a crear los cuatrimestres:");
		DAL dal = DAL.getInstance();
		List<Cuatrimestre> listaCuatrimestres = new ArrayList<Cuatrimestre>();
		for(int i = 1; i<3; i++){
			Cuatrimestre cuatri = dal.crearCuatrimestre(new Cuatrimestre(curso, i));
			System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n CUATRIMESTRE CREADO: " + cuatri);
			listaCuatrimestres.add(cuatri);

		}
		
		Asignatura asignatura = dal.crearAsignatura( new Asignatura(listaCuatrimestres.get(0), "CSD 2", 66, 5, false, Basics.HexToColor("#c1c1c1")));
		System.out.println("\n #### PRUEBAS DIRECTAS DE PERSISTENCIA ### \n ASIGNATURA CREADA: " + asignatura);
		

	}
		
		
}
