package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class UsuarioRootController implements Initializable{
	private Stage secondaryStage;
	private MainController controladorPrincipal;
	public UsuarioRootController() {
		// TODO Auto-generated constructor stub
	}
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.secondaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
