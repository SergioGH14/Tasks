package gui.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;



public class CrearPracticaController implements Initializable{

	@FXML
    private ImageView ivRecuperable;

    @FXML
    private ImageView ivGrupal;
    
      
	private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    private CrearActividadConcretaController contenedora;
	
	 public void initStage(Stage stage, MainController controladorPrincipal, CrearActividadConcretaController contenedora){
			this.primaryStage = stage;
			this.controladorPrincipal = controladorPrincipal;
			this.contenedora = contenedora;
			}
	public CrearPracticaController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		ivRecuperable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(contenedora.getLista().get(1)==false )ivRecuperable.setImage(new Image("file:assets/checked_checkbox.png"));
				else ivRecuperable.setImage(new Image("file:assets/unchecked_box.png"));
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
		ivGrupal.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(!contenedora.getLista().get(0))ivGrupal.setImage(new Image("file:assets/checked_checkbox.png"));
				else ivGrupal.setImage(new Image("file:assets/unchecked_box.png"));
				contenedora.getLista().set(0, !contenedora.getLista().get(0));
			}
		});
}
		
		
		
		
		
}
	
	

