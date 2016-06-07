package gui.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.DAL;
import persistence.dto.ActividadDTO;

import java.net.URL;
import java.util.ResourceBundle;

import Util.Basics;
import Util.Date_solver;
import Util.InputValid;
import bussines.Asignatura;
import bussines.Unidad_Logica;
import javafx.fxml.Initializable;

public class CrearActividadController implements Initializable{

    @FXML
    private Line lPrioridadMedia;

    @FXML
    private ImageView ivPrioridadAlta;

    @FXML
    private TextArea taDescripcion;

    @FXML
    private RadioButton rbPrioridadAlta;

    @FXML
    private Text tTiempoBajo;

    @FXML
    private Line lTiempoBajo;

    @FXML
    private RadioButton rbTiempoMedio;

    @FXML
    private Line lPrioridadAlta;

    @FXML
    private RadioButton rbTiempoBajo;

    @FXML
    private ImageView ivSiguiente;

    @FXML
    private DatePicker dpFechaFin;

    @FXML
    private TextField tfTituloActividad;

    @FXML
    private ImageView ivPrioridadBaja;

    @FXML
    private Line lTiempoMedio;

    @FXML
    private RadioButton rbPrioridadMedia;

    @FXML
    private Text tTituloActividad;

    @FXML
    private ImageView ivPrioridadMedia;

    @FXML
    private GridPane gpFondo;

    @FXML
    private Rectangle rFondo;

    @FXML
    private Line lTiempoAlto;

    @FXML
    private RadioButton rbPrioridadBaja;

    @FXML
    private Text tTiempoAlto;

    @FXML
    private RadioButton rbTiempoAlto;

    @FXML
    private Text tTiempoMedio;

    @FXML
    private Line lPrioridadBaja;
	    
	private int prioridad;
	
	private int tiempo;
	
    private ActividadDTO actividaddto;
    
    private Asignatura asignatura;
	
    private Stage primaryStage;
    
    private MainController controladorPrincipal;
    
    public void initStage(Stage stage, MainController controladorPrincipal, Asignatura asignatura){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.asignatura = asignatura;
		rFondo.setFill(asignatura.getColor());
		
		}
	public CrearActividadController() {
		// TODO Auto-generated constructor stub
	}
	
	public void indicadorPrioridad(int valor){
		lPrioridadBaja.setOpacity(0);
		lPrioridadMedia.setOpacity(0);
		lPrioridadAlta.setOpacity(0);
		
		switch (valor) {
		case 0:
			lPrioridadBaja.setOpacity(1);
			prioridad=10;
			break;
		case 1:
			lPrioridadMedia.setOpacity(1);
			prioridad=20;
			break;
		case 2:
			lPrioridadAlta.setOpacity(1);
			prioridad=30;
		default:
			break;
		}
		
	}    
	public boolean inputValid(){
		String res = "\n";
		boolean valid = true;
		if(InputValid.estaRellenado(tfTituloActividad.getText())==false)
			{res = res + "No hay titulo de la Actividad\n";
			valid = false;}
		if(InputValid.estaRellenado(taDescripcion.getText())==false)
			taDescripcion.setText("");
		if(prioridad == 0)
			{res = res + "No has seleccionado prioridad\n";
			valid = false;}
		if(tiempo == 0)
			{res = res + "No has seleccionado la duracion de la actividad\n";
			valid = false;}
		if(InputValid.esFechaFutura(dpFechaFin.getValue())==false)
			{res = res + "No has seleccionado niguna fecha correcta\n";
			valid = false;}
			if(!valid)controladorPrincipal.sacarError(res);
		return valid;
		
	}
	public void indicadorTiempo(int valor){
		lTiempoBajo.setOpacity(0);
		lTiempoMedio.setOpacity(0);
		lTiempoAlto.setOpacity(0);
		
		
		switch (valor) {
		case 0:
			lTiempoBajo.setOpacity(1);
			tiempo =5;
			break;
		case 1:
			lTiempoMedio.setOpacity(1);
			tiempo =10;
			break;
		case 2:
			lTiempoAlto.setOpacity(1);
			tiempo =15;
		default:
			break;
		}}
	
	public ActividadDTO getActividad() {
		return actividaddto;
	}
	public void setActividad(ActividadDTO actividad) {
		this.actividaddto = actividad;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		 tTituloActividad.setFont(Basics.generateFontById(5, 50));
			tfTituloActividad.textProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
			        if(newValue.length()<=17){
			        	tTituloActividad.setText(newValue);
			        }else{
			        	tTituloActividad.setText(newValue.substring(0, 16));
			        }
			    	
			    }
			});
	
			
			rbPrioridadAlta.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

				@Override
				public void handle(javafx.event.Event event) {
					// TODO Auto-generated method stub
					indicadorPrioridad(2);
				}});
			rbPrioridadMedia.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

				@Override
				public void handle(javafx.event.Event event) {
					// TODO Auto-generated method stub
					indicadorPrioridad(1);
				}});
			rbPrioridadBaja.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

				@Override
				public void handle(javafx.event.Event event) {
					// TODO Auto-generated method stub
					indicadorPrioridad(0);
				}});
			
			rbTiempoAlto.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

				@Override
				public void handle(javafx.event.Event event) {
					// TODO Auto-generated method stub
					indicadorTiempo(2);
				}});
			rbTiempoMedio.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

				@Override
				public void handle(javafx.event.Event event) {
					// TODO Auto-generated method stub
					indicadorTiempo(1);
				}});
			rbTiempoBajo.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

				@Override
				public void handle(javafx.event.Event event) {
					// TODO Auto-generated method stub
					indicadorTiempo(0);
				}});
			ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {
				
				@Override
				public void handle(Event event) {
					// Hacer el input valid antes
					
					if(inputValid()){
					actividaddto = new ActividadDTO(asignatura.getTitulo(), 
							tfTituloActividad.getText(), 
							taDescripcion.getText(), 
							dpFechaFin.getValue().atTime(0,0) , 
							tiempo, 
							0, 
							prioridad, 
							false);
					primaryStage.close();
				}}
			
			});
	}
	
	}
	


