package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Util.Basics;
import bussines.Unidad_Logica;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListaNotificacionesController implements Initializable{
	//Objetos basicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Unidad_Logica fachada;

	@FXML private Text tvNoNotificaciones;

    @FXML
    private Text tvDescripcion;

    @FXML
    private Text tvFecha;

    @FXML
    private Circle cColorAsignatura;

    @FXML
    private Text tvTituloAsignatura;

    
	public void initStage(Stage stage, MainController mainController) {
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tvNoNotificaciones.setFont(Basics.generateFontById(9, 16));
		
	}

}
