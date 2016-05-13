package gui.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

import Util.Date_Solver;
import bussines.Curso;
import bussines.Grado;
import bussines.Unidad_Logica;
import bussines.Universidad;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InicioUniversidadGradoController  implements Initializable{
	

    @FXML
    private ImageView ivSiguiente;

    @FXML
    private TextField tfCreditosAprobados;

    @FXML
    private TextField tfTituloGrado;

    @FXML
    private TextField tfAnyoGrado;

    @FXML
    private TextField tfCreditosTotales;
    
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Universidad upv;
	public  InicioUniversidadGradoController() {
		// TODO Auto-generated constructor stub
	}
	public void initStage(Stage stage, MainController controladorPrincipal,Universidad upv){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.upv = upv;
		
		}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
		ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// ¿Comprobamos que todos los parametros son validos?
				
				System.out.println("Este es el año convertido supuestamente en una fecha -->"+Date_Solver.setDateinLocaleDateTime(tfAnyoGrado.getText()));
				
				Grado grado = new Grado(upv, tfTituloGrado.getText(),Date_Solver.setDateinLocaleDateTime(tfAnyoGrado.getText()));
				
				
				
				Curso actual = new Curso(grado,
						LocalDateTime.now(),
						Double.parseDouble(tfCreditosTotales.getText()));
				
				
				//Mandamos el Grado a persistencia mediante fachada
				
				Unidad_Logica.getInstance().crearGrado(grado);
				
				//Una vez acabamos de crear los objetos y mandarlos al fachada cambiamos de pantalla
				controladorPrincipal.inicioCuatrimestreAsignatura(primaryStage, actual);
			}
		});
	}

}
