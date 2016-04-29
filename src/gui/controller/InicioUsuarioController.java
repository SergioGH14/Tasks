package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class InicioUsuarioController implements Initializable{
	private Stage primaryStage;
	private MainController controladorPrincipal;
	public InicioUsuarioController() {
		// TODO Auto-generated constructor stub
	}
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		
		}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
