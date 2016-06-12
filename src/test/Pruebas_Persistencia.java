package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import Util.*;
import bussines.*;
import persistence.*;

public class Pruebas_Persistencia {
	private Scanner teclado;
	private LocalDateTime l = LocalDateTime.now();
	private Universidad universidad;
	private Usuario usuario;
	private Grado grado;
	private Curso curso;
	private Cuatrimestre cuatrimestre;
	private Asignatura asignatura;
	private Actividad actividad;
	private Notificacion notificacion;
	private boolean existe;
	private List<Cuatrimestre> list;

	/*@Test
	public static void main (String []args) {
		teclado = new Scanner(System.in);	
		
		System.err.println("\n\t##### PRUEBAS UNITARIAS DE LA SUBCAPA DE PERSISTENCIA #####\n");
		System.out.println("Existen usuarios en base de datos: " + existe +"\n");

		
		if(universidad!=null){
			System.out.println(" CREAR UNIVERSIDAD OK : " + universidad.getNombre());
			
			/*Usuario usuario = crearUsuario(universidad);
			if(usuario!=null){
				System.out.println(" CREAR USUARIO OK : " + universidad.getNombre());
				
				UsuarioDAOImp userDAOImp= new UsuarioDAOImp();
				System.out.println(" USUARIO OBTENIDO DE BBDD: "+userDAOImp.obtenerInformacionDeUsuario(usuario.getId_usuario()));

				usuario = userDAOImp.asociarUniversidadUsuario(usuario, universidad.getId_universidad());
				if(usuario!=null){
					System.out.println(" USUARIO ASIGNADO A UNIVERSIDAD ");
					
					Grado grado = crearGrado(universidad);
					if(grado!=null){
						System.out.println(" CREAR GRADO OK : " + grado.getTitulacion());
						
						Curso curso = crearCurso(grado);
						if(curso!=null){
							System.out.println(" CREAR CURSO OK :" + curso.getAnyo());
							
							List<Cuatrimestre> listCuatrimestres = crearCuatrimestres(curso);
							if(listCuatrimestres!=null && !listCuatrimestres.isEmpty()){
								System.out.println(" CREAR CUATRIMESTRES OK :" + listCuatrimestres);

							}else{
								System.err.println(" FALLO AL CREAR CUATRIMESTRES, REVISAR DATOS ");
							}
							
						}else{
							System.err.println(" FALLO AL CREAR CURSO, REVISAR DATOS ");
						}
					}else{
						System.err.println(" FALLO AL CREAR GRADO, REVISAR DATOS ");
					}
					
				}else{
					System.err.println(" FALLO AL ASOCIAR USUARIO A UNIVERSIDAD, REVISAR DATOS ");
				}
				
			}else{
				System.err.println(" FALLO AL CREAR USUARIO, REVISAR DATOS ");
			}
			
		}else{
			System.err.println(" FALLO AL CREAR UNIVERSIDAD, REVISAR DATOS ");
		}
	
	}*/

	
	@Test
	public void existeUsuario(){
		this.existe = DAL.getInstance().existeUsuario();
	}
	
	@Test
	public void crearUniversidad(){
		
		//System.out.println("Introduce el nombre de tu universidad: ");
		String nombreuni = "Universidad Politécnica de Valencia";
		
		//System.out.println("Introduce la dirección de tu universidad: ");
		String direccionuni = "Camí de Vera";
		
		this.universidad = new UniversidadDAOImp().crearUniversidad(new Universidad("./logo_universidad.png", nombreuni, direccionuni));
				
	}
	
	@Test
	public void crearUsuario(){

		//System.out.println("Introduce Nombre de usuario: ");
		String nombre = "Kevin";
		
		//System.out.println("Introduce Apellidos del usuario: ");
		String apellidos = "S.";
		
		//System.out.println("Introduce url foto de usuario: ");
		String foto = "/Kevin/fotos/foto.png";
		
		//System.out.println("Introduce email del usuario: ");
		String email = "kesover@inf.upv.es";
			
		//usuario inicialmente con universidad previamente creada
		crearUniversidad();
		this.usuario = new UsuarioDAOImp().crearUsuario( new Usuario(universidad,nombre, apellidos, foto, Date_solver.formatLocalDateTime(l) , email) );
		
	}
	
	@Test
	public void crearGrado(){
		crearUniversidad();
		//System.out.println("\nVamos a crear un grado, como se llama tu titulacion:");
		String titulacion = "Inigeniería Informática";
		Grado grado = new Grado(universidad, titulacion, l);
		
		GradoDAOImp gimp = new GradoDAOImp();
		this.grado = gimp.crearGrado(grado);
		
	}
	
	@Test
	public void crearCurso(){
		crearGrado();
		Curso curso = new Curso(grado, l, 63.0);
		CursoDAOImp cur = new CursoDAOImp();
		this.curso = cur.crearCurso(curso);
	}
	
	@Test
	public void crearCuatrimestres() {
		crearCurso();
		DAL dal = DAL.getInstance();
		List<Cuatrimestre> listaCuatrimestres = new ArrayList<Cuatrimestre>();
		for(int i = 1; i<4; i++){
			Cuatrimestre cuatri = dal.crearCuatrimestre(new Cuatrimestre(curso, i));
			System.out.println(" CUATRIMESTRE CREADO: " + cuatri);
			listaCuatrimestres.add(cuatri);

		}
		this.cuatrimestre = listaCuatrimestres.get(0);
	}
	
	@Test
	public void crearAsignatura(){
		crearCuatrimestres();
		this.asignatura = new AsignaturaDAOImp().crearAsignatura( new Asignatura(cuatrimestre, "DDS", 66, 5, false, Basics.HexToColor("#c1c1c1")));
	}
}
