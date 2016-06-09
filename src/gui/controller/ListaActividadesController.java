package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import Util.Basics;
import Util.Constantes;
import bussines.Actividad;
import bussines.Asignatura;
import bussines.Estrategia_Ordenacion;
import bussines.Estrategia_Ordenacion_BandejaEntrada;
import bussines.Estrategia_Ordenacion_Hoy;
import bussines.Estrategia_Ordenacion_ParaDespues;
import bussines.Estrategia_Ordenacion_Prioridad;
import bussines.Unidad_Logica;
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
import javafx.scene.layout.GridPane;
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
	@FXML ImageView ivEditarAsignatura;
	@FXML ImageView ivEditarAsignatura2;
	@FXML Text tEditarAsignatura;
	@FXML GridPane gpAnyadirActividad;
	@FXML GridPane gpAnyadirActividadNO;
	
	//listas con actividades
	@FXML ListView lvActividades;
	private ObservableList<Actividad> olActividades;
	
	
	public void initStage(Stage stage, MainController controladorPrincipal, Asignatura asignatura, int tipoItemMenuSeleccionado){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;
		
		//bandeja, hoy, para despues es una recopilacion de actividades y desde alli no se podran crear
		if(asignatura!=null){
			gpAnyadirActividad.setVisible(true);
			gpAnyadirActividadNO.setVisible(true);
		}else{
			tEditarAsignatura.setVisible(false);
			ivEditarAsignatura2.setVisible(false);
			ivEditarAsignatura.setVisible(false);
			gpAnyadirActividad.setVisible(false);
			gpAnyadirActividadNO.setVisible(false);
		}
		
		iniciarPantallaListaDeActividades(tipoItemMenuSeleccionado);	
		
	}
		
	
	@SuppressWarnings("unchecked")
	private void iniciarPantallaListaDeActividades(int tipoItemMenuSeleccionado) {
		textNombreAsignatura.setFont(Basics.generateFontById(3, 23));

		switch(tipoItemMenuSeleccionado){
		case 0:
			if(asignatura!=null){
				//rellenar la lista en pantalla con la que devuelve el patrón estrategia.
				olActividades = FXCollections.observableArrayList(Unidad_Logica.getInstance().ordenar(new Estrategia_Ordenacion_Prioridad(asignatura)));
			}
			textNombreAsignatura.setText(Constantes.ACTIVIDADES_PARA+asignatura.getTitulo());
			break;
		case 1:
			//metodo estrategia que devuelve actividades de bandeja de entrada
			olActividades = FXCollections.observableArrayList(Unidad_Logica.getInstance().ordenar(new Estrategia_Ordenacion_BandejaEntrada()));
			textNombreAsignatura.setText(Constantes.BANDEJA);
			break;
		case 2:
			//metodo estrategia que devuelve actividades de hoy
			olActividades = FXCollections.observableArrayList(Unidad_Logica.getInstance().ordenar(new Estrategia_Ordenacion_Hoy()));
			textNombreAsignatura.setText(Constantes.BANDEJA_HOY);
			break;
		case 3:
			//metodo estrategia que devuelve actividades de para despues
			olActividades = FXCollections.observableArrayList(Unidad_Logica.getInstance().ordenar(new Estrategia_Ordenacion_ParaDespues()));
			textNombreAsignatura.setText(Constantes.BANDEJA_PARA_DESPUES);
			break;
		}
		
		//estilo para las listas de actividades
		lvActividades.getStylesheets().add(getClass().getResource("/gui/view/listaactividades.css").toExternalForm());
		lvActividades.setItems(olActividades);
		lvActividades.setCellFactory(c -> new ListCellFactoryActividades(this));
		
		actualizarListas();
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tEditarAsignatura.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Asignatura aux = controladorPrincipal.editarAsignatura(asignatura);
				textNombreAsignatura.setText(Constantes.ACTIVIDADES_PARA +aux.getTitulo());
			}
		});
		ivEditarAsignatura.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Asignatura aux = controladorPrincipal.editarAsignatura(asignatura);
				textNombreAsignatura.setText(Constantes.ACTIVIDADES_PARA +aux.getTitulo());
			}
		});
		
		gpAnyadirActividad.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
					Actividad actividad = controladorPrincipal.crearActividad(asignatura);
					if(actividad!=null){
						olActividades.add(actividad);
						actualizarListas();
					}

			}
		});

		gpAnyadirActividadNO.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Actividad actividad = controladorPrincipal.crearActividad(asignatura);
				if(actividad!=null){
					olActividades.add(actividad);
					actualizarListas();
				}
			}
		});
	}
	
	private void actualizarListas(){
		if(olActividades!=null && olActividades.isEmpty()){
			//mostrar pantalla de todo hecho
			pnTodoHecho.setVisible(true);
			lvActividades.setVisible(false);
			tvMensajeTodoOk.setFont(Basics.generateFontById(9, 23));
			
			/*
			 * Aqui podriamos generar mensajes con logos aleatorios para que sea gracioso
			 * 
			 */

		}else{
			pnTodoHecho.setVisible(false);
			lvActividades.setVisible(true);
		}
	}
	
	public void marcarActividadFinalizada(Actividad actividad){
		int id_actividad = ((Actividad)actividad).getId_actividad();
		System.out.println("MARCAR COMO FINALIZADA LA TAREA QUE HE RECIBIDO ID: " +id_actividad);
		for(int i = 0; i<olActividades.size(); i++){
			if(olActividades.get(i).getId_actividad() == id_actividad){
				Unidad_Logica.getInstance().marcarActividadHecha(id_actividad);
				olActividades.remove(i);
				actualizarListas();
			}
		}
	}
	
	public void marcarActividadParaDespues(Actividad actividad){
		int id_actividad = ((Actividad)actividad).getId_actividad();
		System.out.println("MARCAR COMO PARA_DESPUES LA TAREA QUE HE RECIBIDO ID: " + id_actividad);
		for(int i = 0; i<olActividades.size(); i++){
			if(olActividades.get(i).getId_actividad() == id_actividad){
				Unidad_Logica.getInstance().marcarActividadParaDespues(id_actividad);
				olActividades.remove(i);
				actualizarListas();
			}
		}
	}
	
	public void eliminarActividad(Actividad actividad){
		int id_actividad = ((Actividad)actividad).getId_actividad();
		System.out.println("MARCAR COMO BORRAR LA TAREA QUE HE RECIBIDO ID: " + id_actividad);
		for(int i = 0; i<olActividades.size(); i++){
			if(olActividades.get(i).getId_actividad() == id_actividad){
				Unidad_Logica.getInstance().eliminarActividad(id_actividad);
				olActividades.remove(i);
				actualizarListas();
			}
		}
	}

}
