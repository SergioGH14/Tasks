package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bussines.Asignatura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/*
 * author @kevin
 * 
 * Clase del controlador de la pantalla donde sale el menú lateral y el centro de la aplicación, el cual se irá
 * sustituyendo su contenido dependiendo de la Asigntara que den click para mostrar las actividades
 */

public class MenuLateralController implements Initializable {
	//Objetos básicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	
	//Etiquetas XML para identificar objetos en pantalla
	//menú lateral
	@FXML private ListView listViewAsignaturas;
	
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//prueba para rellenar la lista de asignaturas y mostrarlas en pantalla
		
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		listaAsignaturas.add(new Asignatura("CSD"));
		listaAsignaturas.add(new Asignatura("ETC"));
		listaAsignaturas.add(new Asignatura("PSW"));
		listaAsignaturas.add(new Asignatura("DDS"));
		listaAsignaturas.add(new Asignatura("GPR"));
		
		ObservableList<Asignatura> loAsignaturas = FXCollections.observableArrayList(listaAsignaturas);
		listViewAsignaturas.setItems(loAsignaturas);

		
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
