package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import bussines.Asignatura;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class BarraInferiorPrincipalController implements Initializable {
	
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Asignatura asignatura;
	
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;
	
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
