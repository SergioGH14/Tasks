package gui.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import Util.Basics;
import bussines.Asignatura;
import bussines.Unidad_Logica;
import bussines.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/*
 * author @kevin
 * 
 * Clase del controlador de la pantalla donde sale el menu lateral y el centro de la aplicacion, el cual se ira
 * sustituyendo su contenido dependiendo de la Asigntara que den click para mostrar las actividades
 */

public class MenuLateralController implements Initializable {
	//Objetos basicos de paso entre pantallas: Stage y Controlador principal
	private Stage primaryStage;
	private MainController controladorPrincipal;
	private Unidad_Logica fachada;
	
	//pantalla principal si no hay tareas
	@FXML private Text tvMensajeTodoOk;
	@FXML private Label lbNoAsignaturas;
	
	//Etiquetas XML para identificar objetos en pantalla
	//Barra TOP
	@FXML private ImageView ivAvatar;
	@FXML private Text tvNombreUsuario;
	@FXML private Text logoArdum;
	@FXML private ImageView ivNotificaciones;
	@FXML private ImageView ivNotificacionTriangulo;
	@FXML private ImageView ivConfiguracion;

	//Botones principales laterales
	@FXML private Text tvBandeja;
	@FXML private HBox hbBandeja;
	@FXML private Text tvHoy;
	@FXML private HBox hbHoy;
	@FXML private Text tvParaDespues;
	@FXML private HBox hbParaDespues;
	
	//menu lateral
	@FXML private Text TextTituloGrado;
	@FXML private ListView listViewAsignaturas;
	@FXML private ImageView ivAnyadirAsignatura;
	
	//boolean para mostrar o no la lista de notificaciones
	private boolean mostrarNotificaciones;
	
	private Usuario usuario;
	
	private ObservableList<Asignatura> loAsignaturas;
	
	//prueba de asignatura auxiliar clickada
	Asignatura asignaturaAux;
	public void initStage(Stage stage, MainController controladorPrincipal){
		this.primaryStage = stage;
		this.controladorPrincipal = controladorPrincipal;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.fachada = Unidad_Logica.getInstance();
		this.usuario = fachada.informacionUsuario(1);
		
		inicializarContenidoVisual();
		
		//prueba para rellenar la lista de asignaturas y mostrarlas en pantalla
		List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		listaAsignaturas.addAll(fachada.obtenerAsignaturasPorCuatrimestre(Basics.cuatrimestreActual()));
		listaAsignaturas.addAll(fachada.obtenerAsignaturasPorCuatrimestre(3));

		
		
	    loAsignaturas = FXCollections.observableArrayList(listaAsignaturas);
		listViewAsignaturas.setItems(loAsignaturas);
		
		if(fachada.obtenerInformacionGrado(1)!=null){
		    TextTituloGrado.setText(fachada.obtenerInformacionGrado(1).getTitulacion());
		    TextTituloGrado.setFont(Basics.generateFontById(8, 16));
		}
		
		
		//lista de asignaturas chetada + estilo en css
		listViewAsignaturas.getStylesheets().add(getClass().getResource("/gui/view/application.css").toExternalForm());
		listViewAsignaturas.setCellFactory(c-> new ListCellFactoryAsignaturas(this, controladorPrincipal));

		//inicialmente presentamos la lista de bandeja de entrada y seleccionamos ese elemento
		tvBandeja.setFont(Basics.generateFontById(1, 14));
		hbBandeja.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				
		/* Método escuchador de la lista para cuando se seleccione un elemento
		 * se pueda lanzar la pantalla con las activiades correspondientes a esa asignatura
		 */
		listViewAsignaturas.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				if(listViewAsignaturas.getSelectionModel().getSelectedItem()!=null){
					//desseleccionar los otros elementos
					hbBandeja.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
					hbHoy.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
					hbParaDespues.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
					tvBandeja.setFont(Basics.generateFontById(3, 14));
					tvHoy.setFont(Basics.generateFontById(3, 14));
					tvParaDespues.setFont(Basics.generateFontById(3, 14));
					asignaturaAux = (Asignatura) listViewAsignaturas.getSelectionModel().getSelectedItem();
					int index = listViewAsignaturas.getSelectionModel().getSelectedIndex();
					if(index>-1 && index< loAsignaturas.size())
						lanzarPantallaDeActividades(loAsignaturas.get(index),0);
				}
			}
			
		});

				
		ivAnyadirAsignatura.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
					Asignatura asignatura = controladorPrincipal.crearAsignatura();
					if(asignatura!=null){
						if(asignatura.getCuatrimestre().getCuatrimestre()==3 || asignatura.getCuatrimestre().getCuatrimestre()==Basics.cuatrimestreActual()){
							loAsignaturas.add(asignatura);
						}
						comprobarAsignaturas();
						System.out.println("Se ha añadido la asignatura : " +asignatura.getTitulo());
						System.out.println("La lista tiene: "+loAsignaturas.size());
					}
				}
		});
		

		comprobarAsignaturas();
	}
	public void inicializarContenidoVisual(){
	    logoArdum.setFont(Basics.generateFontById(23, 35));
		lbNoAsignaturas.setFont((Basics.generateFontById(3, 14)));

		//nombre de usuario y fuente
		if(usuario!=null){
			tvNombreUsuario.setText(usuario.getNombreCompleto());
			tvNombreUsuario.setFont(Basics.generateFontById(1, 14));
			
			//establecer imagen del item seleccionado en la pantalla de descripcion
			BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(new File(usuario.getAvatar()));
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(bufferedImage!=null){
					Image image = SwingFXUtils.toFXImage(bufferedImage, null);
					ivAvatar.setImage(image);
				}
			}
		}
		
		tvBandeja.setFont(Basics.generateFontById(3, 14));
		hbBandeja.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				tvBandeja.setFont(Basics.generateFontById(1, 14));
				hbBandeja.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				hbHoy.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvHoy.setFont(Basics.generateFontById(3, 14));
				hbParaDespues.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvParaDespues.setFont(Basics.generateFontById(3, 14));
				listViewAsignaturas.getSelectionModel().select(null);
				
				//acciones al hacer click
				lanzarPantallaDeActividades(null,1);

				
			}
		});
		
		tvHoy.setFont(Basics.generateFontById(3, 14));
		hbHoy.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				tvHoy.setFont(Basics.generateFontById(1, 14));
				hbHoy.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				hbBandeja.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvBandeja.setFont(Basics.generateFontById(3, 14));
				listViewAsignaturas.getSelectionModel().select(null);
				hbParaDespues.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvParaDespues.setFont(Basics.generateFontById(3, 14));
				
				//acciones al hacer click
				lanzarPantallaDeActividades(null,2);

				
			}
		});
		
		tvParaDespues.setFont(Basics.generateFontById(3, 14));
		hbParaDespues.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				tvParaDespues.setFont(Basics.generateFontById(1, 14));
				hbParaDespues.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				hbHoy.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvHoy.setFont(Basics.generateFontById(3, 14));
				hbBandeja.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
				tvBandeja.setFont(Basics.generateFontById(3, 14));
				listViewAsignaturas.getSelectionModel().select(null);

				//acciones al hacer click
				lanzarPantallaDeActividades(null,3);
				
			}
		});
				
		ivNotificaciones.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if(!mostrarNotificaciones){
					mostrarNotificaciones = true;
					lanzarPantallaDeNotificaciones(mostrarNotificaciones);
				}else{
					mostrarNotificaciones = false;
					lanzarPantallaDeNotificaciones(mostrarNotificaciones);
				}
				ivNotificacionTriangulo.setVisible(mostrarNotificaciones);
			}
		});

		ivConfiguracion.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				controladorPrincipal.mostrarPantallaConfiguracionUsuario();
			}
		});
	}
	
	public void lanzarPantallaDeActividades(Asignatura asignaturaSeleccionada, int tipoItemMenu){
		controladorPrincipal.abrirPantallaActividades(primaryStage, asignaturaSeleccionada,tipoItemMenu);
	}
	
	public void lanzarPantallaDeNotificaciones(boolean mostrar){
		controladorPrincipal.mostrarListaDeNotificaciones(primaryStage, mostrar);
	}
	
	public void comprobarAsignaturas(){
		if(loAsignaturas!=null && !loAsignaturas.isEmpty()){
			lbNoAsignaturas.setVisible(false);
		}else{
			lbNoAsignaturas.setVisible(true);
		}
	}
	
	public void actualizarDatosConfiguracion(){
		if(tvNombreUsuario!=null && TextTituloGrado!=null && fachada.getUsuario()!=null){
			tvNombreUsuario.setText(fachada.getUsuario().getNombreCompleto());
			TextTituloGrado.setText(fachada.getGrado().getTitulacion());
			//establecer imagen del item seleccionado en la pantalla de descripcion
			BufferedImage bufferedImage = null;
			try {
				System.out.println("Avatar: " + fachada.getUsuario().getAvatar());
				bufferedImage = ImageIO.read(new File(fachada.getUsuario().getAvatar()));
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(bufferedImage!=null){
					Image image = SwingFXUtils.toFXImage(bufferedImage, null);
					ivAvatar.setImage(image);
				}
			}
		}else{
			System.err.println("No se ha podido actualizar tu información de usuario");

		}
	}
	
	public void editarAsignatura(Asignatura asignatura){

		if(asignatura!=null){
			if(asignatura.getCuatrimestre().getCuatrimestre()==3 || asignatura.getCuatrimestre().getCuatrimestre()==Basics.cuatrimestreActual()){
				for(int i = 0; i<loAsignaturas.size(); i++){
					if(loAsignaturas.get(i).getId_asignatura() == asignatura.getId_asignatura()){
						loAsignaturas.remove(i);
						loAsignaturas.add(i, asignatura);
						listViewAsignaturas.getSelectionModel().select(i);
						lanzarPantallaDeActividades(loAsignaturas.get(i),0);
					}
				}
			}
			System.out.println("Se ha editado la asignatura : " +asignatura.getTitulo());
		}
	}



	public void eliminarAsignatura(Asignatura asignatura){
		int id_asignatura = asignatura.getId_asignatura();
		System.out.println("BORRAR LA ASIGNATURA QUE HE RECIBIDO ID: " + asignatura.getTitulo());
		for(int i = 0; i<loAsignaturas.size(); i++){
			if(loAsignaturas.get(i).getId_asignatura() == id_asignatura){
				Unidad_Logica.getInstance().eliminarAsignatura(id_asignatura);
				loAsignaturas.remove(i);
				lanzarPantallaDeActividades(null,1);
				listViewAsignaturas.getSelectionModel().select(null);
				seleccionPorDefecto();

			}
		}
		comprobarAsignaturas();
	}


	private void seleccionPorDefecto() {
		if(tvBandeja!=null){
			tvBandeja.setFont(Basics.generateFontById(1, 14));
			hbBandeja.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			hbHoy.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
			tvHoy.setFont(Basics.generateFontById(3, 14));
			hbParaDespues.setBackground(new Background(new BackgroundFill(Color.web("#f3f3f3"), null, null)));
			tvParaDespues.setFont(Basics.generateFontById(3, 14));	
		}
	}
}
