package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import bussines.Asignatura;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListaActividadesController implements Initializable{
	//Objetos básicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private BorderPanePrincipalController controladorPrincipal;
	private Asignatura asignatura;
	
	//Etiquetas XML para identificar objetos en pantalla
	@FXML Text textNombreAsignatura;
	
	
	public void initStage(Stage stage, BorderPanePrincipalController controladorPrincipal, Asignatura asignatura){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;
		
		if(asignatura!=null){
			textNombreAsignatura.setText("Se ha seleccionado la asignatura: "+asignatura.getTitulo());
		}
	}
		

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
