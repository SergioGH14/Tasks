package gui.controller;

import java.io.IOException;

import bussines.Asignatura;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * Clase principal que lanza la aplicacion, la cual lanzara las demas pantallas de la aplicacion
 * Lanza la pantalla con el border pane contenedor de el menu lateral.
 * 
 * Esta clase comprobara al inicio si el usuario ya ha preconfigurado la aplicacion para lanzar 
 * una pantalla ( la de las actividades ) u otra ( la de configuracion de inicio )
 * 
 */

public class MainController  extends Application {
	private BorderPane root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/MenuLateralBorderPanePrincipal.fxml"));
			root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle(Util.Constantes.ARDUM);
			
			//acceso al controlador de la pantalla de activiades con menu lateral
			//previo paso de datos antes de que se lanze la pantalla
			MenuLateralController pantallaInicialActiviades = loader.<MenuLateralController>getController();
			pantallaInicialActiviades.initStage(primaryStage, this);
			
			primaryStage.show();
			setBarraInferiorPrincipal(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//la pantalla de activiades siempre abre la misma, solo que con diferentes asignaturas que tendrán activiades diferentes
	public void abrirPantallaActividades(Stage primaryStage, Asignatura asignatura){
		primaryStage.setTitle(Util.Constantes.ARDUM + " - " + asignatura.getTitulo());
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/ListaActividades.fxml"));
			GridPane pantallaListaActiviades = (GridPane)loader.load();
			
			if(root!=null){
				root.setCenter(pantallaListaActiviades);
			}
			
			ListaActividadesController controladorPantalla = loader.<ListaActividadesController>getController();
			controladorPantalla.initStage(primaryStage, this, asignatura);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al abrir la pantalla de activiades de una asignatura: " + e.getLocalizedMessage());
		}
		
	}
	
	
	public void setBarraInferiorPrincipal(Stage primaryStage){
		 try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/BarraInferiorPrincipal.fxml"));
			GridPane barraInferiorPrincipal = (GridPane)loader.load();
			
			if(root!=null){
				root.setBottom(barraInferiorPrincipal);
			}
			
			BarraInferiorPrincipalController barrainferiorprincipal = loader.<BarraInferiorPrincipalController>getController();
			barrainferiorprincipal.initStage(primaryStage, this);
			
		} catch (IOException e){
			// TODO Auto-generated catch block
			System.err.println("Error al establecer la barra inferior " + e.getLocalizedMessage());
		}
	}
}
