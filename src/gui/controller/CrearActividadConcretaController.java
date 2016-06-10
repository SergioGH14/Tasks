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
import bussines.Actividad;
import bussines.Actividad_Examen;
import bussines.Asignatura;
import bussines.Examen_Clase;
import bussines.Examen_Poliformat;
import bussines.Examen_Practicas;
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
    
    private boolean ex_clase;
    private boolean ex_clase_grupal;
    private boolean ex_clase_apuntes;
    
    private boolean ex_poliformat;
    private boolean ex_poliformat_reintentable;

    private boolean ex_practicas;
    private boolean ex_practicas_apuntes;
    
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
	
	public boolean isEx_clase() {
		return ex_clase;
	}
	public void setEx_clase(boolean ex_clase) {
		this.ex_clase = ex_clase;
	}
	public boolean isEx_poliformat() {
		return ex_poliformat;
	}
	public void setEx_poliformat(boolean ex_poliformat) {
		this.ex_poliformat = ex_poliformat;
	}
	public boolean isEx_practicas() {
		return ex_practicas;
	}
	public void setEx_practicas(boolean ex_practicas) {
		this.ex_practicas = ex_practicas;
	}
	public boolean isEx_clase_grupal() {
		return ex_clase_grupal;
	}
	public void setEx_clase_grupal(boolean ex_clase_grupal) {
		this.ex_clase_grupal = ex_clase_grupal;
	}
	public boolean isEx_clase_apuntes() {
		return ex_clase_apuntes;
	}
	public void setEx_clase_apuntes(boolean ex_clase_apuntes) {
		this.ex_clase_apuntes = ex_clase_apuntes;
	}
	public boolean isEx_poliformat_reintentable() {
		return ex_poliformat_reintentable;
	}
	public void setEx_poliformat_reintentable(boolean ex_poliformat_reintentable) {
		this.ex_poliformat_reintentable = ex_poliformat_reintentable;
	}
	public boolean isEx_practicas_apuntes() {
		return ex_practicas_apuntes;
	}
	public void setEx_practicas_apuntes(boolean ex_practicas_apuntes) {
		this.ex_practicas_apuntes = ex_practicas_apuntes;
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
			
			if(tipo != 0){
				System.err.println("Lista de booleanos : "+lista + " " +lista.get(0) + lista.get(1));
				actividad = Fabrica_Actividad.getInstance().crearActividad(tipo, actividaddto, (ArrayList<Boolean>) lista);
				
				if(tipo == 3){
					Actividad_Examen examen = (Actividad_Examen)actividad;
					if(ex_poliformat){
						examen = new Examen_Poliformat(examen);
						
						Examen_Poliformat ex = (Examen_Poliformat)examen;
						ex.setReintentable(ex_poliformat_reintentable);
						
						examen = ex;
						
					}
					if(ex_clase){
						examen = new Examen_Clase(examen);
						
						Examen_Clase ex = (Examen_Clase)examen;
						ex.setGrupal(ex_clase_grupal);
						ex.setApuntes(ex_clase_apuntes);
						
						examen = ex;
					}
					if(ex_practicas){
						examen = new Examen_Practicas(examen);
						
						Examen_Practicas ex = (Examen_Practicas)examen;
						ex.setApuntes(ex_practicas_apuntes);
						
						examen = ex;
						
					}
					
					actividad = Unidad_Logica.getInstance().crearExamen(examen);
					
					
				}
				
				primaryStage.close();
			} else {
					controladorPrincipal.sacarError("\nSelecciona un tipo de Actividad");
			}
			
		}
	});
	
	}
	
	
}
