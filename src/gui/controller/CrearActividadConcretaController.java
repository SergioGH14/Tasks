package gui.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen_Poliformat;
import bussines.Fabrica_Actividad;
import bussines.Unidad_Logica;
import javafx.stage.Stage;
import persistence.dto.ActividadDTO;

public class CrearActividadConcretaController implements Initializable{
    
    @FXML
    private ImageView ivSiguiente;

    @FXML
    private Pane pFondoPractica;

    @FXML
    private Pane pPractica;

    @FXML
    private ImageView ivCancelar;

    @FXML
    private Text tTituloActividad;

    @FXML
    private Pane pFondoCLase;

    @FXML
    private Pane pFondoExamen;

    @FXML
    private Pane pExamen;

    @FXML
    private Rectangle rFondo;

    @FXML
    private Pane pClase;
	
    private int tipo;
    
    /*
     * TIPO 1 PRACTICA
     * TIPO 2 CLASE
     * TIPO 3 EXAMEN
     */
    
    private List<Boolean> lista;
    
	private Actividad actividad;
	
	private ActividadDTO actividaddto;
	
	private Asignatura asignatura;
    
    private BorderPane contenedor;
	
    private Stage primaryStage;
    
    private CrearActividadConcretaController instancia;
    
    private MainController controladorPrincipal;
    
    public void initStage(Stage stage, MainController controladorPrincipal, 
    		ActividadDTO actividaddto,
    		BorderPane contenedor
    		){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
		this.actividaddto = actividaddto;
		this.instancia=this;
		this.contenedor=contenedor;
		asignatura = Unidad_Logica.getInstance().obtenerInformacionAsignatura(actividaddto.getId_asignatura());
		lista = new ArrayList<Boolean>();
		lista.add(false);
		lista.add(false);
		
		rFondo.setFill(asignatura.getColor());
		tTituloActividad.setText(actividaddto.getTitulo());
		}
	public List<Boolean> getLista() {
		
		return lista;
	}
	public void setLista(List<Boolean> lista) {
		this.lista = lista;
	}
	public CrearActividadConcretaController() {
		// TODO Auto-generated constructor stub
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
		pPractica.setOnMouseClicked(new EventHandler<Event>() {

			
			
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				
				pFondoExamen.setOpacity(0);
				pFondoCLase.setOpacity(0);
				pFondoPractica.setOpacity(1.0);
				
				
				tipo = 1;
				lista.set(0, false);
				lista.set(1, false);
				controladorPrincipal.crearActividadEspecifica(primaryStage, instancia,contenedor, tipo);
			}
		});
		pClase.setOnMouseClicked(new EventHandler<Event>() {

			
			
			@Override
			public void handle(Event event) {
				
				pFondoExamen.setOpacity(0);
				pFondoCLase.setOpacity(1.0);
				pFondoPractica.setOpacity(0);
				
				tipo = 2;
				lista.set(0, false);
				lista.set(1, false);
				controladorPrincipal.crearActividadEspecifica(primaryStage, instancia,contenedor, tipo);
			}
		});
		
		pExamen.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				
				pFondoExamen.setOpacity(1.0);
				pFondoCLase.setOpacity(0);
				pFondoPractica.setOpacity(0);
				
				tipo = 3;
				lista.set(0, false);
				lista.set(1, false);
				controladorPrincipal.crearActividadEspecifica(primaryStage, instancia,contenedor, tipo);
			}
		});
		
	ivSiguiente.setOnMouseClicked(new EventHandler<Event>() {

		@Override
		public void handle(Event event) {
			actividad = Fabrica_Actividad.getInstance().crearActividad(tipo, actividaddto, (ArrayList<Boolean>) lista);
			
			actividad = new Examen_Poliformat((Actividad_Examen)actividad);
			
			primaryStage.close();
			
		}
	});
	}

}
