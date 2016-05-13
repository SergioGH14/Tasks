package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import Util.Basics;
import bussines.Actividad;
import bussines.Asignatura;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListaActividadesController implements Initializable{
	//Objetos básicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Asignatura asignatura;
	
	//Etiquetas XML para identificar objetos en pantalla
	@FXML Text textNombreAsignatura;
	
	//listas con actividades
	@FXML ListView lvActividades;
	private ObservableList<Actividad> olActividades;
	private List<Actividad> listActividades;
	
	
	public void initStage(Stage stage, MainController controladorPrincipal, Asignatura asignatura){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;
		
		if(asignatura!=null){
			textNombreAsignatura.setText("Actividades por hacer para "+asignatura.getTitulo());
			textNombreAsignatura.setFont(Basics.generateFontById(3, 23));
		}
		
		if(asignatura!=null && asignatura.getListaActividades()!=null){
			iniciarPantallaListaDeActividades();
		}else{
			//futuro mensaje de que esta asignatura no tiene activiades asociadas.
		}
		
	}
		
	
	private void iniciarPantallaListaDeActividades() {
		this.listActividades = new ArrayList<>(asignatura.getListaActividades().size());
		for(Integer id_actividad : asignatura.getListaActividades().keySet()){
			listActividades.add(asignatura.obtenerActividad(id_actividad));
			System.out.println("Actividad: " + asignatura.obtenerActividad(id_actividad));
		}
		olActividades = FXCollections.observableArrayList(listActividades);
		System.out.println("Actividadessss: " + listActividades);

		lvActividades.setItems(olActividades);

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
