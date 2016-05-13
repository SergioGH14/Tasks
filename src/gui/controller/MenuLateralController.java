package gui.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.geom.Shape;

import Util.Basics;
import bussines.Actividad;
import bussines.Asignatura;
import bussines.Clase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;


/*
 * author @kevin
 * 
 * Clase del controlador de la pantalla donde sale el menu lateral y el centro de la aplicacion, el cual se ira
 * sustituyendo su contenido dependiendo de la Asigntara que den click para mostrar las actividades
 */

public class MenuLateralController implements Initializable {
	//Objetos basicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	
	//Etiquetas XML para identificar objetos en pantalla
	//Barra TOP
	@FXML private ImageView ivAvatar;
	@FXML private Text tvNombreUsuario;
	@FXML private Text logoArdum;
	@FXML private ImageView ivNotificacion;
	@FXML private ImageView ivConfiguracion;
	@FXML private Text tvNotificaciones;

	//Botones principales laterales
	@FXML private Text tvBandeja;
	@FXML private HBox hbBandeja;
	
	@FXML private Text tvHoy;
	@FXML private HBox hbHoy;

	@FXML private Text tvParaDespues;
	@FXML private HBox hbParaDespues;

	//menu lateral
	@FXML private ListView listViewAsignaturas;
	@FXML private Text TextTituloGrado;
	
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//nombre de usuario y fuente
		tvNombreUsuario.setText("Kevin Sotomayor V.");
		tvNombreUsuario.setFont(Basics.generateFontById(1, 14));
		
		tvBandeja.setFont(Basics.generateFontById(3, 14));
		hbBandeja.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				tvBandeja.setFont(Basics.generateFontById(2, 14));
				hbBandeja.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				hbHoy.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvHoy.setFont(Basics.generateFontById(3, 14));
				hbParaDespues.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvParaDespues.setFont(Basics.generateFontById(3, 14));

				//acciones al hacer click
				
			}
		});
		
		tvHoy.setFont(Basics.generateFontById(3, 14));
		hbHoy.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				tvHoy.setFont(Basics.generateFontById(2, 14));
				hbHoy.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				hbBandeja.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvBandeja.setFont(Basics.generateFontById(3, 14));

				hbParaDespues.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvParaDespues.setFont(Basics.generateFontById(3, 14));
				//acciones al hacer click
				
			}
		});
		
		tvParaDespues.setFont(Basics.generateFontById(3, 14));
		hbParaDespues.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				tvParaDespues.setFont(Basics.generateFontById(2, 14));
				hbParaDespues.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				hbHoy.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvHoy.setFont(Basics.generateFontById(3, 14));
				hbBandeja.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvBandeja.setFont(Basics.generateFontById(3, 14));

				//acciones al hacer click
				
			}
		});
		
		tvNotificaciones.setFont(Basics.generateFontById(8, 14));

		//prueba para rellenar la lista de asignaturas y mostrarlas en pantalla
		
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		listaAsignaturas.add(new Asignatura("CSD", Color.CRIMSON));
		listaAsignaturas.add(new Asignatura("ETC",Color.AQUAMARINE ));
		listaAsignaturas.add(new Asignatura("PSW",Color.BLUEVIOLET));
		listaAsignaturas.add(new Asignatura("DDS",Color.CADETBLUE));
		listaAsignaturas.add(new Asignatura("GPR",Color.CORAL));
		
		Asignatura asignaturaPruebaConActividades = new Asignatura("PRB", Color.BLANCHEDALMOND);
		
		Actividad actPrueba = new Clase(1,asignaturaPruebaConActividades, "Actividad pendiente de hacer", "Descripcion de prueba pendiente", LocalDateTime.now(), 0, 0, 0, true, false);
		actPrueba.setId_actividad(0);
		
		asignaturaPruebaConActividades.anyadirActividad(actPrueba);
		listaAsignaturas.add(asignaturaPruebaConActividades);
		
		ObservableList<Asignatura> loAsignaturas = FXCollections.observableArrayList(listaAsignaturas);
		listViewAsignaturas.setItems(loAsignaturas);
		
	    TextTituloGrado.setText("Ingeniería Informática");
	    TextTituloGrado.setFont(Basics.generateFontById(8, 16));
	    
	    logoArdum.setFont(Basics.generateFontById(23, 35));

		
		//celda a celda
		listViewAsignaturas.setCellFactory(new Callback<ListView<Asignatura>, ListCell<Asignatura> >() {

			@Override
			public ListCell<Asignatura> call(ListView<Asignatura> param) {
				
				ListCell<Asignatura> celda = new ListCell<Asignatura>(){
					
					@Override
					protected void updateItem(Asignatura a, boolean flag){
						super.updateItem(a, flag);
						
						if(a!=null){
							setText(a.getTitulo());
							setFont(Basics.generateFontById(3, 16));
							setStyle("-fx-padding: 10 20 10 20;");
							
							Button button = new Button();
							Circle circuloActividad = new Circle(1.5);
							button.setShape(circuloActividad);
							button.setStyle("-fx-background-radius: 10em; " +
										        "-fx-min-width: 10px; " +
										        "-fx-min-height: 10px; " +
										        "-fx-max-width: 10px; " +
										        "-fx-max-height: 10px; " +
										        "-fx-background-color: "+Basics.RGBToHex(a.getColor())+";" +
										        "-fx-background-insets: 0px; " +
										        "-fx-border-color: #fff;"+
										        "-fx-padding: 1px;"+
											    "-fx-border-insets: 1px;"+
											    "-fx-background-insets: 1px;"+
										        "-fx-border-width: 0.5;" );
							setGraphic(button);
																	
						}
					}
				};
				
				celda.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						celda.setFont(Basics.generateFontById(2, 16));
					}
				});
				
				return celda;
			}
			
		});

		
		/* Método escuchador de la lista para cuando se seleccione un elemento
		 * se pueda lanzar la pantalla con las activiades correspondientes a esa asignatura
		 */
		
		listViewAsignaturas.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				if(listViewAsignaturas.getSelectionModel().getSelectedItem()!=null){
					lanzarPantallaDeActividades(listaAsignaturas.get(listViewAsignaturas.getSelectionModel().getSelectedIndex()));
				}
			}
			
		});
		
		
	}
	
	public void lanzarPantallaDeActividades(Asignatura asignaturaSeleccionada){
		
		controladorPrincipal.abrirPantallaActividades(primaryStage, asignaturaSeleccionada);
		
	}

}
