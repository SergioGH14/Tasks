package gui.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CrearClaseController implements Initializable {
	  
	
	  
    @FXML
    private ImageView ivPuntuable;
    
    @FXML
    private Rectangle rPuntuable;
        
	private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    private CrearActividadConcretaController contenedora;
	
	 public void initStage(Stage stage, MainController controladorPrincipal, CrearActividadConcretaController contenedora){
			this.primaryStage = stage;
			this.controladorPrincipal = controladorPrincipal;
			this.contenedora = contenedora;
			}
	public CrearClaseController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rPuntuable.setFill(new ImagePattern(new Image("file:assets/unchecked_box.png")));
		
		ivPuntuable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(contenedora.getLista().get(1)==false )rPuntuable.setFill(new ImagePattern( new Image("file:assets/checked_checkbox.png")));
				else rPuntuable.setFill(new ImagePattern( new Image("file:assets/unchecked_box.png")));
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
	
	}
}