package test;

import java.time.LocalDateTime;
import org.junit.Test;
import bussines.*;
import persistence.DAL;

public class Pruebas_Decorador {
	private Actividad_Examen examenBase;
	private LocalDateTime l = LocalDateTime.now();
	
	@Test
	public void crearExamenBase(){
		System.err.println("\n\n\n\t##### PRUEBAS DEL PATRON DECORADOR ##### ");
		Asignatura asignatura = DAL.getInstance().obtenerInformacionAsignatura("ETC");
		Actividad_Examen examen = new Examen(asignatura, 
				"Examen SOLO CLASE de ETC para decorar de poliformat y de practicas a la vez",
				"Descripcion de examen de dsm",
				l, 
				15,
				0.0,
				30,
				false,
				false,
				false,
				true);
		
		examen = DAL.getInstance().crearExamen(examen);
		System.err.println("Examen id: "+examen.getId_examen()+" prioridad de examen : "  + examen.getPrioridadTotal());
		this.examenBase = examen;
	}
	
	@Test 
	public void crearExamenDecorado(){
		System.err.print("\n\n\n### VOLVEMOS A CREAR UN EXAMEN BASE PARA DECORACION SIMPLE ##");
		crearExamenBase();
		Actividad_Examen examen = examenBase;

		if(examen instanceof Actividad_Examen){
			
			//Decoracion de poliformat
			System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN POLIFORMAT ##################");
			Actividad_Examen ex_poli = new Examen_Poliformat(examen);
			((Examen_Poliformat)ex_poli).setReintentable(true);
			ex_poli = DAL.getInstance().crearExamen(ex_poli);
			
			System.err.println("Examen decorado con solo poliformat: " + ((Examen_Poliformat)ex_poli)  );
			
			Actividad examen_act = (Actividad)ex_poli;
			if(examen_act instanceof Examen_Poliformat){
				System.out.println("Informacion base:\n" + examen_act.getDescripcion());
			}
			
			//Decoracion Practicas
			System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN PRACTICAS ##################");
			Actividad_Examen ex_practi = new Examen_Practicas(examen);
			((Examen_Practicas)ex_practi).setApuntes(true);
			
			ex_practi = DAL.getInstance().crearExamen(ex_practi);
			
			System.err.println("Examen decorado con solo practica: " + ((Examen_Practicas)ex_practi)  );
			
			Actividad examen_act_practica = (Actividad)ex_practi;
			if(examen_act_practica instanceof Examen_Practicas){
				System.out.println("Informacion base:\n" + examen_act_practica.getDescripcion());
			}
			
			//Decoracion Practicas
			System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN CLASE ##################");
			Actividad_Examen ex_clase = new Examen_Clase(examen);
			((Examen_Clase)ex_clase).setApuntes(true);
			((Examen_Clase)ex_clase).setGrupal(true);

			
			ex_clase = DAL.getInstance().crearExamen(ex_clase);
			
			System.err.println("Examen decorado con solo clase: " + ((Examen_Clase)ex_clase)  );
			
			Actividad examen_act_cls = (Actividad)ex_clase;
			if(examen_act_cls instanceof Examen_Clase){
				System.out.println("Informacion base:\n" + examen_act_cls.getDescripcion());
			}
		}
	}
	
	@Test
	public void crearExamenDecoradoCompuestoClasePoli(){
		System.err.print("\n\n\n### VOLVEMOS A CREAR UN EXAMEN BASE PARA DECORACION COMPUESTA CLASE-POLIFORMAT ##");
		crearExamenBase();
		Actividad_Examen examen = examenBase;
		//Decoracion de poliformat
		System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN POLIFORMAT COMPUESTO ->POLIFORMAT<- ##################");
		Actividad_Examen ex_poli = new Examen_Poliformat(examen);
		((Examen_Poliformat)ex_poli).setReintentable(true);
		ex_poli = DAL.getInstance().crearExamen(ex_poli);
		
		System.err.println("Examen base del compuesto con solo poliformat: " + ((Examen_Poliformat)ex_poli)  );
		
		//Decorcion examen poliformat-clase
		//Decoracion Practicas
		System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN CLASE COMPUESTO -> CLASE-POLIFORMAT <- ##################");
		Actividad_Examen ex_clase = new Examen_Clase(ex_poli);
		((Examen_Clase)ex_clase).setApuntes(true);
		((Examen_Clase)ex_clase).setGrupal(true);

		ex_clase = DAL.getInstance().crearExamen(ex_clase);
		
		System.err.println("Examen decorado compuesto clase-poliformat: " + ((Examen_Clase)ex_clase)  );
		
		Actividad examen_act_cls = (Actividad)ex_clase;
		if(examen_act_cls instanceof Examen_Clase){
			System.err.println("### Informacion del examen decorado compuesto ###");
			System.out.println("Examen de clase: " + ex_clase);
			Examen_Poliformat ePoli = (Examen_Poliformat)((Examen_Clase)ex_clase).getExamen();
			System.out.println("Examen poliformat de clase: " + ePoli);
			Examen  ex= (Examen)ePoli.getExamen(); 
			System.out.println("Examen base de poliformat de clase: " + ex);

		}
	}
	
	@Test
	public void crearExamenDecoradoCompuestoPractPoli(){
		System.err.print("\n\n\n### VOLVEMOS A CREAR UN EXAMEN BASE PARA DECORACION COMPUESTA PRACTICA-POLIFORMAT ###");
		crearExamenBase();
		Actividad_Examen examen = examenBase;
		//Decoracion de poliformat
		System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN POLIFORMAT COMPUESTO ->POLIFORMAT<- ##################");
		Actividad_Examen ex_poli = new Examen_Poliformat(examen);
		((Examen_Poliformat)ex_poli).setReintentable(true);
		ex_poli = DAL.getInstance().crearExamen(ex_poli);
		
		System.err.println("Examen base del compuesto con solo poliformat: " + ((Examen_Poliformat)ex_poli)  );
		
		//Decorcion examen poliformat-clase
		//Decoracion Practicas
		System.err.println("\n\n\t ################## PRUEBA UNITARIA DE EXAMEN CLASE COMPUESTO ->PRACTICA-POLIFORMAT<- ##################");
		Actividad_Examen ex_practi = new Examen_Practicas(examen);
		((Examen_Practicas)ex_practi).setApuntes(true);
		
		ex_practi = DAL.getInstance().crearExamen(ex_practi);
		
		System.err.println("Examen decorado compuesto PRACTICA-poliformat: " + ((Examen_Practicas)ex_practi)  );
		
		Actividad examen_act_cls = (Actividad)ex_practi;
		if(examen_act_cls instanceof Examen_Clase){
			System.err.println("### Informacion del examen decorado compuesto ###");
			System.out.println("Examen de practicas: " + ex_practi);
			Examen_Poliformat ePoli = (Examen_Poliformat)((Examen_Clase)ex_practi).getExamen();
			System.out.println("Examen poliformat de practicas: " + ePoli);
			Examen  ex= (Examen)ePoli.getExamen(); 
			System.out.println("Examen base de poliformat de practicas: " + ex);

		}
	}
}
