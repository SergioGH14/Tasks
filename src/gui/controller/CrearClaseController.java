package gui.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CrearClaseController implements Initializable {
	  
	
	  
    @FXML
    private ImageView ivPuntuable;
        
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
	public Image cargarImagen(String ruta){
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bufferedImage!=null){
				Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				return image;
			}
			return null;
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ivPuntuable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(contenedora.getLista().get(1)==false )ivPuntuable.setImage(cargarImagen("C:/Users/Sergio/Documents/GitHub/Tasks/assets/checked_checkbox.png"));
				else ivPuntuable.setImage(cargarImagen("C:/Users/Sergio/Documents/GitHub/Tasks/assets/unchecked_box.png"));
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
	
	}
}