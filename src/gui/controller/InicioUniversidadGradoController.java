package gui.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

import Util.Date_solver;
import Util.InputValid;
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
	
	public String textoError(){
		String res = "\n";
		if(InputValid.esAnyo(tfAnyoGrado.getText())==false)
			res = res+"No has un año correcto \n";
		if(InputValid.estaRellenado(tfTituloGrado.getText())==false)
			res = res + "El Titulo del grado no esta bien\n";
		if(InputValid.esNumerico(tfCreditosTotales.getText())==false)
			res = res + "¿Cuantos Creditos en total?\n";
		if(InputValid.esNumerico(tfCreditosAprobados.getText())==false)
			res = res + "¿Has aprobado algun crédito?\n";
			return res;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
		ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// ¿Comprobamos que todos los parametros son validos?
				if(InputValid.esAnyo(tfAnyoGrado.getText())&&
				   InputValid.estaRellenado(tfTituloGrado.getText())&&
				   InputValid.esNumerico(tfCreditosTotales.getText())&&
				   InputValid.esNumerico(tfCreditosAprobados.getText()))
				{
				
				Grado grado = new Grado(upv, tfTituloGrado.getText(),Date_solver.setDateinLocaleDateTime(tfAnyoGrado.getText()));	
				//Mandamos el Grado a persistencia mediante fachada
				grado = Unidad_Logica.getInstance().crearGrado(grado);
				
				Curso actual = new Curso(grado,
						LocalDateTime.now(),
						Double.parseDouble(tfCreditosTotales.getText()));
				//Mandamos el Curso a persistencia
				actual = Unidad_Logica.getInstance().crearCurso(actual );
				
				
				//Una vez acabamos de crear los objetos y mandarlos al fachada cambiamos de pantalla
				controladorPrincipal.inicioCuatrimestreAsignatura(primaryStage, actual);
			}
			else controladorPrincipal.sacarError(textoError());
		}});
	}

}
