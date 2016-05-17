package gui.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import Util.Date_solver;
import bussines.Unidad_Logica;
import bussines.Universidad;
import bussines.Usuario;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class InicioUsuarioController implements Initializable{
	
	 @FXML
	    private Button btImagen;

	    @FXML
	    private ImageView ivSiguiente;

	    @FXML
	    private TextField tfNombre;

	    @FXML
	    private TextField tfApellidos;

	    @FXML
	    private TextField tfEmail;

	    @FXML
	    private DatePicker dpFechanacimiento;

	    @FXML
	    private Circle cImage;

	    
	    
	    private Usuario user;
	    private String path;
	    
	    private Stage primaryStage;
	
	    private MainController controladorPrincipal;
	
	    public InicioUsuarioController() {
	    	// TODO Auto-generated constructor stub
	}
	
    public Usuario getUser() {
			return user;
		}

		public void setUser(Usuario user) {
			this.user = user;
		}

	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		
		}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		path = "/Tasks/assets/Login As User-96.png";
		btImagen.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				FileChooser fileChooser = new FileChooser();
		        fileChooser.setTitle("Buscar Imagen");

		        // Agregar filtros para facilitar la busqueda
		        fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("All Images", "*.*"),
		                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
		                new FileChooser.ExtensionFilter("PNG", "*.png")
		        );

		        Window dialogStage = null;
				// Obtener la imagen seleccionada
		        File imgFile = fileChooser.showOpenDialog(dialogStage);
		        String res = imgFile.getAbsolutePath();
		        if(res!=null){
		        
		       path = res;
		        // Mostar la ruta de la imagen
		        if(res!=null && !res.isEmpty() && res.trim().length()>0){
                    try {
                        BufferedImage bufferedImage = ImageIO.read(imgFile);
                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                        cImage.setFill(new ImagePattern(image));;
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
			
			}}
		});
		
		
		ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// ¿Comprobamos que todos los parametros son validos?
				
				
				//Creamos la universidad
				Universidad upv = new Universidad("/Tasks/assets/logo_upv[1].png","Universitat Politecnica de Valencia", "Camino de Vera");
				//Mandamos a la persistencia la universidad
				upv = Unidad_Logica.getInstance().crearUniversidad(upv);
				
				//Creamos el Usuario
				user = new Usuario(upv,tfNombre.getText(),
						tfApellidos.getText(),
						path,
						dpFechanacimiento.getValue().atTime(0, 0),tfEmail.getText());
				//Mandamos el Usuario a la  persistencia mediante fachada
				user = 	Unidad_Logica.getInstance().crearUsuario(user);

				
				
				
				
				//Una vez acabamos de crear los objetos y mandarlos al fachada cambiamos de pantalla
				controladorPrincipal.inicioUniversidadGrado(primaryStage,upv);
			}
		});
	}}


