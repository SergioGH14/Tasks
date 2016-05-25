package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController implements Initializable{

	@FXML
    private Label lTextoError;

    @FXML
    private Button bOk;

	private Stage primaryStage;

	private MainController controladorPrincipal;
	
	private String texto;

    public void initStage(Stage stage, MainController controladorPrincipal, String texto){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.texto=texto;
		lTextoError.setText(texto);
		
		}
    
	public ErrorController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		bOk.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				primaryStage.close();
			}
		});
		
	}

}
