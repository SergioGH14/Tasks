package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
		
	    private MainController controladorPrincipal;
	    
	    public void initStage(Stage stage, MainController controladorPrincipal){
			this.primaryStage = stage;
			this.controladorPrincipal = controladorPrincipal;
			
			}

	public CrearAsignaturaController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
