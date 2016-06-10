package gui.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import Util.Basics;
import Util.Date_solver;
import bussines.Grado;
import bussines.Unidad_Logica;
import bussines.Universidad;
import bussines.Usuario;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ConfiguracionUsuarioController implements Initializable{
	//Objetos basicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Unidad_Logica fachada;
	
	//Datos a modificar y para persistir
	Usuario usuario;
	Universidad universidad;
	Grado grado;
	
	@FXML
    private TextField tvNombreUniversidad;

    @FXML
    private ImageView ivGuardar;

    @FXML
    private TextField tvApellidos;

    @FXML
    private ImageView ivAvatar;

    @FXML
    private ImageView ivCancelar;

    @FXML
    private TextField tvNombre;

    @FXML
    private Label tvInfoGradoTag;

    @FXML
    private TextField tvNombreGrado;

    @FXML
    private DatePicker tvFechaNacimiento;
    	
	public void initStage(Stage stage, MainController mainController) {
		this.primaryStage = stage;
		this.controladorPrincipal = mainController;
		this.fachada = Unidad_Logica.getInstance();
		this.usuario = fachada.getUsuario();
		System.err.println("usuario recogido : " + usuario);
		this.universidad = fachada.getUniversidad();
		this.grado = fachada.getGrado();
		
		
		if(usuario!= null && universidad!=null && grado!=null){
			tvNombre.setText(usuario.getNombre());
			tvApellidos.setText(usuario.getApellidos());
			//tvFechaNacimiento.setPromptText(Date_solver.obtenerFechaParaActividades(usuario.getFechanacimiento()));
			tvFechaNacimiento.setValue(usuario.getFechanacimiento().toLocalDate());
			
			tvNombreGrado.setText(grado.getTitulacion());
			tvNombreUniversidad.setText(universidad.getNombre());
			
			//establecer imagen del item seleccionado en la pantalla de descripcion
			BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(new File(usuario.getAvatar()));
			} catch (IOException e) {
				System.err.println("No se ha podido encontrar la imagen");
			}finally{
				if(bufferedImage!=null){
					Image image = SwingFXUtils.toFXImage(bufferedImage, null);
					ivAvatar.setImage(image);
				}
			}
		}
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		tvInfoGradoTag.setFont(Basics.generateFontById(9, 18));
		
		ivCancelar.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				primaryStage.close();
			}
		});
		
		ivGuardar.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				usuario.setNombre(tvNombre.getText());
				usuario.setApellidos(tvApellidos.getText());
				usuario.setFechanacimiento(tvFechaNacimiento.getValue().atStartOfDay());
				
				universidad.setNombre(tvNombreUniversidad.getText());
				
				grado.setTitulacion(tvNombreGrado.getText());
				
				fachada.setUsuario(usuario);
				fachada.setGrado(grado);
				fachada.setUniversidad(universidad);
				
				primaryStage.close();
			}
		});
		
		ivAvatar.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
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
		        String res=null;
		        if(imgFile!=null)res = imgFile.getAbsolutePath();
		        if(res!=null){
		        
			        // Mostar la ruta de la imagen
			        if(res!=null && !res.isEmpty() && res.trim().length()>0){
	                    try {
	                        BufferedImage bufferedImage = ImageIO.read(imgFile);
	                        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	                        usuario.setAvatar(res);
	                        ivAvatar.setImage(image);
	                    } catch (IOException ex) {
	                        System.err.println(ex.getMessage());
	                    }
	                }
		        }
			}
		});
	}

}
