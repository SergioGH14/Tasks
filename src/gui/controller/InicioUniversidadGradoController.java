package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import bussines.Grado;
import bussines.Universidad;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InicioUniversidadGradoController  implements Initializable{
	

    @FXML
    private ImageView ivSiguiente;

    @FXML
    private TextField tfCreditosAprobados;

    @FXML
    private TextField tfTituloGrado;

    @FXML
    private TextField tfAnyoGrado;

    @FXML
    private TextField tfCreditosTotales;
    
	private Stage primaryStage;
	private MainController controladorPrincipal;
	public  InicioUniversidadGradoController() {
		// TODO Auto-generated constructor stub
	}
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		
		}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
		ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// ¿Comprobamos que todos los parametros son validos?
				
				//Creamos la universidad
				Universidad upv = new Universidad("/Tasks/assets/logo_upv[1].png","Universitat Politecnica de Valencia", "Camino de Vera");
				/*
				Grado actual = new Grado(tfTituloGrado.getText(),tfAnyoGrado.getText());*/
				
				
				
				//Mandamos el Usuario a persistencia mediante fachada
				
				
				
				//Una vez acabamos de crear los objetos y mandarlos al fachada cambiamos de pantalla
				controladorPrincipal.inicioCuatrimestreAsignatura(primaryStage);
			}
		});
	}

}
