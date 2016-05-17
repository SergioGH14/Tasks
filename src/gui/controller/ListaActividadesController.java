package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import Util.Basics;
import bussines.Actividad;
import bussines.Asignatura;
import bussines.Estrategia_Ordenacion;
import bussines.Estrategia_Ordenacion_BandejaEntrada;
import bussines.Estrategia_Ordenacion_Hoy;
import bussines.Estrategia_Ordenacion_ParaDespues;
import bussines.Estrategia_Ordenacion_Prioridad;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListaActividadesController implements Initializable{
	//Objetos básicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Asignatura asignatura;
	
	//Etiquetas XML para identificar objetos en pantalla
	@FXML Text textNombreAsignatura;
	
	@FXML Pane pnTodoHecho; //pantalla que se muestra cuando todo está hecho
	@FXML Text tvMensajeTodoOk;
	@FXML ImageView ivLogoTodoHecho;
	
	//listas con actividades
	@FXML ListView lvActividades;
	private ObservableList<Actividad> olActividades;
	
	
	public void initStage(Stage stage, MainController controladorPrincipal, Asignatura asignatura, int tipoItemMenuSeleccionado){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;

		iniciarPantallaListaDeActividades(tipoItemMenuSeleccionado);	
		
	}
		
	
	@SuppressWarnings("unchecked")
	private void iniciarPantallaListaDeActividades(int tipoItemMenuSeleccionado) {
		Estrategia_Ordenacion estrategiaOrdenacion = new Estrategia_Ordenacion();
		textNombreAsignatura.setFont(Basics.generateFontById(3, 23));

		switch(tipoItemMenuSeleccionado){
		case 0:
			if(asignatura!=null){
				//rellenar la lista en pantalla con la que devuelve el patrón estrategia.
				olActividades = FXCollections.observableArrayList(estrategiaOrdenacion.ordenar(new Estrategia_Ordenacion_Prioridad(asignatura)));
			}
			textNombreAsignatura.setText("Actividades por hacer para "+asignatura.getTitulo());
			break;
		case 1:
			//metodo estrategia que devuelve actividades de bandeja de entrada
			olActividades = FXCollections.observableArrayList(estrategiaOrdenacion.ordenar(new Estrategia_Ordenacion_BandejaEntrada()));
			textNombreAsignatura.setText("Bandeja de Entrada");
			break;
		case 2:
			//metodo estrategia que devuelve actividades de hoy
			olActividades = FXCollections.observableArrayList(estrategiaOrdenacion.ordenar(new Estrategia_Ordenacion_Hoy()));
			textNombreAsignatura.setText("Lo que tienes para hoy");
			break;
		case 3:
			//metodo estrategia que devuelve actividades de para despues
			olActividades = FXCollections.observableArrayList(estrategiaOrdenacion.ordenar(new Estrategia_Ordenacion_ParaDespues()));
			textNombreAsignatura.setText("Ya lo harás después... ");
			break;
		}
		
		if(olActividades!=null && olActividades.isEmpty()){
			//mostrar pantalla de todo hecho
			pnTodoHecho.setVisible(true);
			tvMensajeTodoOk.setFont(Basics.generateFontById(9, 23));
			
			/*
			 * Aqui podriamos generar mensajes con logos aleatorios para que sea gracioso
			 * 
			 */

		}
		
		//estilo para las listas de actividades
		lvActividades.getStylesheets().add(getClass().getResource("/gui/view/listaactividades.css").toExternalForm());
		lvActividades.setItems(olActividades);
		lvActividades.setCellFactory(c -> new ListCellFactoryActividades());
		
		/*lvActividades.setCellFactory(new Callback<ListView<Asignatura>, ListCell<Actividad> >() {

			@Override
			public ListCell<Actividad> call(ListView<Asignatura> param) {
				
				ListCell<Actividad> celda = new ListCell<Actividad>(){
					
					@Override
					protected void updateItem(Actividad actividad, boolean flag){
						super.updateItem(actividad, flag);
						if(actividad!=null){ 
							

							ListCellFactoryItemActividades controllerItem = new ListCellFactoryItemActividades();
							FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/ListCellFactoryItemActividades.fxml"));
							try {
								loader.setController(controllerItem);
								HBox hboxItemsAsignaturas = (HBox)loader.load();

								controllerItem.setInformacion(actividad);
								setGraphic(hboxItemsAsignaturas);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}		
						
					}
				};
				
				celda.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						System.out.println("ha hecho click en el elemento: " + celda.getIndex());
						olActividades.remove(celda.getIndex());
					}
				});
				
				return celda;
			}
			
		});*/
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
