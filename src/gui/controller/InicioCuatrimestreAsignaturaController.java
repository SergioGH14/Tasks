package gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Util.Basics;
import bussines.Asignatura;
import bussines.Curso;
import bussines.Universidad;
import bussines.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class InicioCuatrimestreAsignaturaController implements Initializable{
	
	    @FXML
	    private ImageView ivSiguiente;

	    @FXML
	    private ListView<Asignatura> lvListaAsignaturas;

	    @FXML
	    private Button btAnyadirAsignatura;
	
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Curso actual;
	private ObservableList<Asignatura> observableListAsignaturas;
	
	public  InicioCuatrimestreAsignaturaController() {
		// TODO Auto-generated constructor stub
	}
	public void initStage(Stage stage, MainController controladorPrincipal, Curso actual){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.actual = actual;
		
		}
	
	private void anyadirAsignatura (Asignatura asignatura){
		observableListAsignaturas.add(asignatura);
		if(observableListAsignaturas!=null)elementosEnCelda();
	}

	private void elementosEnCelda(){
		lvListaAsignaturas.setItems(observableListAsignaturas);
		lvListaAsignaturas.setCellFactory(new Callback<ListView<Asignatura>, ListCell<Asignatura> >() {

			@Override
			public ListCell<Asignatura> call(ListView<Asignatura> param) {
				
				ListCell<Asignatura> celda = new ListCell<Asignatura>(){
					
					@Override
					protected void updateItem(Asignatura a, boolean flag){
						super.updateItem(a, flag);
						
						if(a!=null){
							setText(a.getTitulo());
							setFont(Basics.generateFontById(9, 17));
							
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
	} 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Inicializo el ObservableArrayList
		
		observableListAsignaturas = FXCollections.observableArrayList();
		
		
		
		//Boton que HA DE LLAMAR AL METODO CREAR ASIGNATURA QUE DEVUELVE UNA ASIGNATURA
		btAnyadirAsignatura.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				Asignatura pruebita = new Asignatura("CSO",Color.ALICEBLUE);
				System.out.println(pruebita);
				anyadirAsignatura(pruebita);
			}
		});
		
		ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				
				//Mandamos la lista de Asignaturas a fachada
				
				/*C'MON EVERYBODY PUT IN THE AIR*/
				
				//Una vez acabamos de crear los objetos y mandarlos al fachada cambiamos de pantalla
				controladorPrincipal.tenemosUsuario(true);
				controladorPrincipal.start(primaryStage);
			}
		});
		
	}

}
