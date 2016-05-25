package gui.controller;
import java.net.URL;
import java.util.ResourceBundle;

import Util.Basics;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CrearExamenController implements Initializable {

    @FXML
    private Text tvPoliformat;

    @FXML
    private Pane pAnyadirDetallesAbierto;

    @FXML
    private ImageView ivUltimoExamen;

    @FXML
    private Pane pAnyadirDetalles;

    @FXML
    private ImageView ivPoliformatClicked;

    @FXML
    private ImageView ivClaseGrupal;

    @FXML
    private GridPane gpExamen;

    @FXML
    private Text tvClaseApuntes;

    @FXML
    private ImageView ivClase;

    @FXML
    private ImageView ivPracticasClicked;

    @FXML
    private ImageView ivClaseGrupalClicked;

    @FXML
    private Text tvClase;

    @FXML
    private Text tvPracticas;

    @FXML
    private Text tvClaseTag;

    @FXML
    private ImageView ivUltimoExamenClicked;

    @FXML
    private ImageView ivRecuperarExamenClicked;

    @FXML
    private GridPane gpMasDetalles;

    @FXML
    private Text tvPoliReintentable;

    @FXML
    private VBox vbPracticas;

    @FXML
    private VBox vbClase;

    @FXML
    private VBox vbPoliformat;

    @FXML
    private ImageView ivPoliReintentable;

    @FXML
    private Text tvPracticasApuntes;

    @FXML
    private ImageView ivPoliReintentableClicked;

    @FXML
    private ImageView ivRecuperarExamen;

    @FXML
    private ImageView ivClaseApuntes;

    @FXML
    private ImageView ivClaseClicked;

    @FXML
    private Text tvPoliformatTag;

    @FXML
    private ImageView ivPoliformat;

    @FXML
    private ImageView ivPractApuntes;

    @FXML
    private ImageView ivPractApuntesClicked;

    @FXML
    private ImageView ivClaseApuntesClicked;

    @FXML
    private Text tvText1;

    @FXML
    private Text tvPracticasTag;

    @FXML
    private Text tvText2;

    @FXML
    private Text tvClaseGrupal;

    @FXML
    private ImageView ivPracticas;
        
	private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    private CrearActividadConcretaController contenedora;
    
    private boolean ultimo;
	private boolean recuperable;

	private boolean poliformat;
	private boolean practicas;
	private boolean clase;
	
	
	 public void initStage(Stage stage, MainController controladorPrincipal, CrearActividadConcretaController contenedora){
			this.primaryStage = stage;
			this.controladorPrincipal = controladorPrincipal;
			this.contenedora = contenedora;
	}
	public CrearExamenController() {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		botonesDeExamenSinDecorar();
		botonesAnyadirMasDetalles();
		actualizarEstado();
		

	}
	private void botonesAnyadirMasDetalles() {
		
		
		ivPoliformat.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				poliformat = true;
				ivPoliformat.setVisible(!poliformat);
				ivPoliformatClicked.setVisible(poliformat);
				actualizarEstado();
				
			}
		});
		
		ivPoliformatClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				poliformat = false;
				ivPoliformat.setVisible(!poliformat);
				ivPoliformatClicked.setVisible(poliformat);
				actualizarEstado();
				
			}
		});
		
		ivPoliReintentable.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivPoliReintentableClicked.setVisible(poliformat);
				ivPoliReintentable.setVisible(!poliformat);

			}
		});
		
		ivPoliReintentableClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivPoliReintentableClicked.setVisible(!poliformat);
				ivPoliReintentable.setVisible(poliformat);

			}
		});
		
		ivClase.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				clase = true;
				ivClase.setVisible(!clase);
				ivClaseClicked.setVisible(clase);
				actualizarEstado();
				
			}
		});
		
		ivClaseClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				clase = false;
				ivClase.setVisible(!clase);
				ivClaseClicked.setVisible(clase);
				actualizarEstado();
				
			}
		});
		
		ivClaseApuntes.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivClaseApuntes.setVisible(!clase);
				ivClaseApuntesClicked.setVisible(clase);

			}
		});
		
		ivClaseApuntesClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				ivClaseApuntes.setVisible(clase);
				ivClaseApuntesClicked.setVisible(!clase);				
			}
		});
		
		ivClaseGrupal.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivClaseGrupal.setVisible(!clase);
				ivClaseGrupalClicked.setVisible(clase);

			}
		});
		
		ivClaseGrupalClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				ivClaseGrupal.setVisible(clase);
				ivClaseGrupalClicked.setVisible(!clase);				
			}
		});
		
		
		
		
		ivPracticas.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				practicas = true;
				ivPracticas.setVisible(!practicas);
				ivPracticasClicked.setVisible(practicas);
				actualizarEstado();
				
			}
		});
		
		ivPracticasClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				practicas= false;
				ivPracticas.setVisible(!practicas);
				ivPracticasClicked.setVisible(practicas);
				actualizarEstado();
				
			}
		});
		
		ivPractApuntes.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivPractApuntes.setVisible(!practicas);
				ivPractApuntesClicked.setVisible(practicas);
			}
		});
		ivPractApuntesClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivPractApuntes.setVisible(practicas);
				ivPractApuntesClicked.setVisible(!practicas);
			}
		});
		
	}
	
	private void botonesDeExamenSinDecorar() {
		ivUltimoExamen.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
 				 
				ivUltimoExamen.setVisible(false);
				ivUltimoExamenClicked.setVisible(true);
				ultimo = true;
			
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
		
		ivUltimoExamenClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				 
				ivUltimoExamen.setVisible(true);
				ivUltimoExamenClicked.setVisible(false);
				ultimo = false;
				
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
	
		ivRecuperarExamen.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivRecuperarExamen.setVisible(false);
				ivRecuperarExamenClicked.setVisible(true);
				recuperable = true;
			
				contenedora.getLista().set(1, !contenedora.getLista().get(1));
			}
		});
		
		ivRecuperarExamenClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				 
				ivRecuperarExamen.setVisible(true);
				ivRecuperarExamenClicked.setVisible(false);
				recuperable = false;
				
				contenedora.getLista().set(0, !contenedora.getLista().get(0));
			}
		});
		
		pAnyadirDetalles.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				gpMasDetalles.setVisible(true);
				gpExamen.setVisible(false);
				
			}
		});
		
		pAnyadirDetallesAbierto.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				gpMasDetalles.setVisible(false);
				gpExamen.setVisible(true);
				
			}
		});
	}

	private void actualizarEstado() {
		
		if(poliformat){
			vbPoliformat.setVisible(poliformat);
		}else{
			vbPoliformat.setVisible(poliformat);
		}
		
		if(clase){
			vbClase.setVisible(clase);
			ivPracticas.setDisable(clase);
			tvPracticas.setFill(Color.web("#d3d3d3"));
		}else{
			vbClase.setVisible(clase);
			ivPracticas.setDisable(clase);
			tvPracticas.setFill(Color.web("#000"));
		}
		
		if(practicas){
			vbPracticas.setVisible(practicas);
			ivClase.setDisable(practicas);
			tvClase.setFill(Color.web("#d3d3d3"));
		}else{
			vbPracticas.setVisible(practicas);
			ivClase.setDisable(practicas);
			tvClase.setFill(Color.web("#000"));
		}
		
	}
}