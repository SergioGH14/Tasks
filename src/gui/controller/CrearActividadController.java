package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.dto.ActividadDTO;

import java.net.URL;
import java.util.ResourceBundle;

import bussines.Asignatura;
import javafx.fxml.Initializable;

public class CrearActividadController implements Initializable{

	
	
    @FXML
    private ImageView ivSiguiente;

    @FXML
    private Line lPrioridadMedia;

    @FXML
    private ImageView ivPrioridadAlta;

    @FXML
    private TextField tfTituloActividad;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private ImageView ivPrioridadBaja;

    @FXML
    private Line lTiempoMedio;

    @FXML
    private Text tTituloActividad;

    @FXML
    private ImageView ivPrioridadMedia;

    @FXML
    private Text tTiempoBajo;

    @FXML
    private Line lTiempoAlto;

    @FXML
    private Line lTiempoBajo;

    @FXML
    private Text tTiempoAlto;

    @FXML
    private Line lPrioridadAlta;

    @FXML
    private Text tTiempoMedio;

    @FXML
    private Line lPrioridadBaja;
    
    private ActividadDTO actividad;
    
    private Asignatura asignatura;
	
    private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    public void initStage(Stage stage, MainController controladorPrincipal, Asignatura asignatura){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;
		
		}
	public CrearActividadController() {
		// TODO Auto-generated constructor stub
	}
	public ActividadDTO getActividad() {
		return actividad;
	}
	public void setActividad(ActividadDTO actividad) {
		this.actividad = actividad;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
