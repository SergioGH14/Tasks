package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Util.Basics;
import Util.InputValid;
import bussines.Asignatura;
import bussines.Cuatrimestre;
import bussines.Unidad_Logica;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import persistence.DAL;

public class CrearAsignaturaController implements Initializable{
	  @FXML
	    private RadioButton rbDificil;

	    @FXML
	    private Text tTitulo;

	    @FXML
	    private Line lFacil;

	    @FXML
	    private Line lCuatriA;

	    @FXML
	    private Pane pFondo;

	    @FXML
	    private Line lCuatriB;

	    @FXML
	    private ImageView ivAceptar;

	    @FXML
	    private RadioButton rbMedio;

	    @FXML
	    private Line lDificil;

	    @FXML
	    private RadioButton rbCuatriAnual;

	    @FXML
	    private Line lMedio;

	    @FXML
	    private CheckBox cbCuatriAnual;

	    @FXML
	    private ToggleGroup tgCuatrimestre;

	    @FXML
	    private RadioButton rbFacil;

	    @FXML
	    private ToggleGroup tgPrioridad;

	    @FXML
	    private RadioButton rbCuatriB;

	    @FXML
	    private Circle cColor;

	    @FXML
	    private ImageView ivCancelar;

	    @FXML
	    private TextField tfNombre;

	    @FXML
	    private RadioButton rbCuatriA;

	    @FXML
	    private ColorPicker cpColorPicker;
	    
	    private Stage primaryStage;
	    
	    private Asignatura asignatura;
	    
	    private Cuatrimestre cuatri;
	    
	    private int dificultad;
		
	    private MainController controladorPrincipal;
	    
	    public void initStage(Stage stage, MainController controladorPrincipal){
			this.primaryStage = stage;
			this.controladorPrincipal = controladorPrincipal;
			dificultad = 0;
			
			}

	  public Asignatura getAsignatura() {
			return asignatura;
		}

		public void setAsignatura(Asignatura asignatura) {
			this.asignatura = asignatura;
		}

	/*Pone opacidad a la dificultad seleccionada
	   * 0 Facil
	   * 1 Medio
	   * 2 Dificl
	   *   */
	public void indicadorDificultad(int valor){
		lFacil.setOpacity(0);
		lMedio.setOpacity(0);
		lDificil.setOpacity(0);
		
		switch (valor) {
		case 0:
			lFacil.setOpacity(1);
			dificultad=7;
			break;
		case 1:
			lMedio.setOpacity(1);
			dificultad=14;
			break;
		case 2:
			lDificil.setOpacity(1);
			dificultad=21;
		default:
			break;
		}
		
	}    
	public void indicadorCuatrimestre(int valor){
		lCuatriA.setOpacity(0);
		lCuatriB.setOpacity(0);
		
		switch (valor) {
		case 0:
			lCuatriA.setOpacity(1);
			cuatri = DAL.getInstance().obtenerInformacionCuatrimestre(1);
			break;
		case 1:
			lCuatriB.setOpacity(1);
			cuatri = DAL.getInstance().obtenerInformacionCuatrimestre(2);
			break;
		case 2:
			lCuatriA.setOpacity(1);
			lCuatriB.setOpacity(1);
			cuatri = DAL.getInstance().obtenerInformacionCuatrimestre(3);
		default:
			break;
		}
		
	}   
	public CrearAsignaturaController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//Visual del texto del titulo
		tTitulo.setFont(Basics.generateFontById(23, 75));
		tfNombre.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
		        if(newValue.length()<=17){
		        	tTitulo.setText(newValue);
		        }else{
		        	tTitulo.setText(newValue.substring(0, 16));
		        }
		    	
		    }
		});
		
		cpColorPicker.setOnAction(t -> {
		    cColor.setFill(cpColorPicker.getValue());  
		    pFondo.setBackground(new Background(new BackgroundFill(Color.web(Basics.RGBToHex(cpColorPicker.getValue())), null, null)));
		});
		
		rbFacil.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				indicadorDificultad(0);
			}});
		rbMedio.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				indicadorDificultad(1);
			}});
		rbDificil.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				indicadorDificultad(2);
			}});
		rbCuatriA.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				indicadorCuatrimestre(0);
			}});
		rbCuatriB.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				indicadorCuatrimestre(1);
			}});
		rbCuatriAnual.setOnMouseClicked(new EventHandler<javafx.event.Event>(){

			@Override
			public void handle(javafx.event.Event event) {
				// TODO Auto-generated method stub
				indicadorCuatrimestre(2);
			}});
		
		ivAceptar.setOnMouseClicked(new EventHandler<Event>() {
			
			@Override
			public void handle(Event event) {
				// Hacer el input valid antes
				if(Basics.RGBToHex(cpColorPicker.getValue())=="#ffffff"&&
						InputValid.estaRellenado(tfNombre.getText())&&
						dificultad == 0 &&cuatri==null){
				asignatura = new Asignatura(cuatri,tfNombre.getText(),0,dificultad,false,cpColorPicker.getValue());
			    asignatura = Unidad_Logica.getInstance().crearAsignatura(asignatura);
				primaryStage.close();
			}else
				controladorPrincipal.sacarError("\nSelecciona un color en el circulo\n O revisa a ver si te dejas algo");;
		
			}});
	}

}
