package gui.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.sun.javafx.geom.Shape;

import bussines.Asignatura;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.Basics;


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
	//menu lateral
	@FXML private ListView listViewAsignaturas;
	@FXML private Text TextTituloGrado;
	@FXML private Text logoArdum;
	
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//prueba para rellenar la lista de asignaturas y mostrarlas en pantalla
		
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		listaAsignaturas.add(new Asignatura("CSD", Color.CRIMSON));
		listaAsignaturas.add(new Asignatura("ETC",Color.AQUAMARINE ));
		listaAsignaturas.add(new Asignatura("PSW",Color.BLUEVIOLET));
		listaAsignaturas.add(new Asignatura("DDS",Color.CADETBLUE));
		listaAsignaturas.add(new Asignatura("GPR",Color.CORAL));
		
	
		
		ObservableList<Asignatura> loAsignaturas = FXCollections.observableArrayList(listaAsignaturas);
		listViewAsignaturas.setItems(loAsignaturas);
		
	    TextTituloGrado.setText("Ingeniería Informática");
	    TextTituloGrado.setFont(Basics.generateFontById(9, 14));
	    
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
							setFont(Basics.generateFontById(9, 90));
							
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
										        "-fx-padding: 5, 25, 5, 25;"+
										        "-fx-border-color: #fff;"+
										        "-fx-border-width: 0.5;" );
							setGraphic(button);
																	
						}
					}
				};
				
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
