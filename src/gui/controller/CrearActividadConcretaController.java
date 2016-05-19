package gui.controller;

import bussines.Actividad;
import bussines.Asignatura;
import javafx.stage.Stage;
import persistence.dto.ActividadDTO;

public class CrearActividadConcretaController {
    
	private Actividad actividad;
	
	private ActividadDTO actividaddto;
    
    private Asignatura asignatura;
	
    private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    public void initStage(Stage stage, MainController controladorPrincipal, ActividadDTO actividaddto){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.actividaddto = actividaddto;
		
		}
	public CrearActividadConcretaController() {
		// TODO Auto-generated constructor stub
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

}
