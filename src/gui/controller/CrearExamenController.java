package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
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
				contenedora.setEx_poliformat(poliformat);
				ivPoliformat.setVisible(!poliformat);
				ivPoliformatClicked.setVisible(poliformat);
				actualizarEstado();
				
			}
		});
		
		ivPoliformatClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				poliformat = false;
				contenedora.setEx_poliformat(poliformat);
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
				contenedora.setEx_poliformat_reintentable(!contenedora.isEx_poliformat_reintentable());
			}
		});
		
		ivPoliReintentableClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivPoliReintentableClicked.setVisible(!poliformat);
				ivPoliReintentable.setVisible(poliformat);
				contenedora.setEx_poliformat_reintentable(!contenedora.isEx_poliformat_reintentable());

			}
		});
		
		ivClase.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				clase = true;
				contenedora.setEx_clase(clase);
				ivClase.setVisible(!clase);
				ivClaseClicked.setVisible(clase);
				actualizarEstado();
				
			}
		});
		
		ivClaseClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				clase = false;
				contenedora.setEx_clase(clase);
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
				contenedora.setEx_clase_apuntes(!contenedora.isEx_clase_apuntes());
			}
		});
		
		ivClaseApuntesClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				ivClaseApuntes.setVisible(clase);
				ivClaseApuntesClicked.setVisible(!clase);		
				contenedora.setEx_clase_apuntes(!contenedora.isEx_clase_apuntes());
			}
		});
		
		ivClaseGrupal.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivClaseGrupal.setVisible(!clase);
				ivClaseGrupalClicked.setVisible(clase);
				contenedora.setEx_clase_grupal(!contenedora.isEx_clase_grupal());
			}
		});
		
		ivClaseGrupalClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {

				ivClaseGrupal.setVisible(clase);
				ivClaseGrupalClicked.setVisible(!clase);
				contenedora.setEx_clase_grupal(!contenedora.isEx_clase_grupal());
				
			}
		});
		
		
		
		
		ivPracticas.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				practicas = true;
				contenedora.setEx_practicas(practicas);
				ivPracticas.setVisible(!practicas);
				ivPracticasClicked.setVisible(practicas);
				actualizarEstado();
				
			}
		});
		
		ivPracticasClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				practicas= false;
				contenedora.setEx_practicas(practicas);
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
				contenedora.setEx_practicas_apuntes(!contenedora.isEx_practicas_apuntes());
			}
		});
		ivPractApuntesClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivPractApuntes.setVisible(practicas);
				ivPractApuntesClicked.setVisible(!practicas);
				contenedora.setEx_practicas_apuntes(!contenedora.isEx_practicas_apuntes());
			}
		});
		
	}
	
	private void botonesDeExamenSinDecorar() {
		ivUltimoExamen.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
 				 
				ivUltimoExamen.setVisible(false);
				ivUltimoExamenClicked.setVisible(true);			
				contenedora.getLista().set(0,true);
			}
		});
		
		ivUltimoExamenClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				 
				ivUltimoExamen.setVisible(true);
				ivUltimoExamenClicked.setVisible(false);
				contenedora.getLista().set(0, false);
			}
		});
	
		ivRecuperarExamen.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				ivRecuperarExamen.setVisible(false);
				ivRecuperarExamenClicked.setVisible(true);			
				contenedora.getLista().set(1, true);
			}
		});
		
		ivRecuperarExamenClicked.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				 
				ivRecuperarExamen.setVisible(true);
				ivRecuperarExamenClicked.setVisible(false);				
				contenedora.getLista().set(1, false);
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