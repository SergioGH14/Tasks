package gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Util.Basics;
import bussines.Unidad_Logica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import bussines.*;

public class ListaNotificacionesController implements Initializable{
	//Objetos basicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Unidad_Logica fachada;

	@FXML private Text tvNoNotificaciones;
	@FXML private Pane pnNoNotificaciones;
    @FXML private ListView lvNotificaciones;

    private List<Notificacion> listaNotificaciones;
    private ObservableList<Notificacion> olNotificaciones;
    
	public void initStage(Stage stage, MainController mainController) {
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tvNoNotificaciones.setFont(Basics.generateFontById(9, 16));
		listaNotificaciones = Unidad_Logica.getInstance().notificacionesDeHoy();
		olNotificaciones = FXCollections.observableArrayList(listaNotificaciones);
		if(olNotificaciones!=null && !olNotificaciones.isEmpty()){
			pnNoNotificaciones.setVisible(false);
			lvNotificaciones.getStylesheets().add(getClass().getResource("/gui/view/listanotificaciones.css").toExternalForm());
			lvNotificaciones.setItems(olNotificaciones);
			lvNotificaciones.setCellFactory(c -> new ListCellFactoryNotificaciones());
		}else{
			pnNoNotificaciones.setVisible(true);
		}
		
	}

}
