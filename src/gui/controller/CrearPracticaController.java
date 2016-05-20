package gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class CrearPracticaController implements Initializable{

    @FXML
    private ImageView ivRecuperable;

    @FXML
    private ImageView ivGrupal;
    
    
	
  
	private static CrearPracticaController instancia;
    
	private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    private CrearActividadConcretaController contenedora;
	
	 public void initStage(Stage stage, MainController controladorPrincipal, CrearActividadConcretaController contenedora){
			this.primaryStage = stage;
			this.controladorPrincipal = controladorPrincipal;
			}
	private CrearPracticaController() {
		// TODO Auto-generated constructor stub
	}
	public static CrearPracticaController getInstancia() {
		if(instancia == null)instancia = new CrearPracticaController()  ;
		return instancia;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ivRecuperable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(!contenedora.getLista().get(1))ivRecuperable.setImage(new Image("/Tasks/assets/Checked Checkbox 2-100 (1).png"));
				else ivRecuperable.setImage(new Image("/Tasks/assets/Unchecked Checkbox-100.png"));
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
		ivGrupal.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(!contenedora.getLista().get(0))ivGrupal.setImage(new Image("/Tasks/assets/Checked Checkbox 2-100 (1).png"));
				else ivGrupal.setImage(new Image("/Tasks/assets/Unchecked Checkbox-100.png"));
				contenedora.getLista().set(0, !contenedora.getLista().get(0));
			}
		});
}
	
	
}
