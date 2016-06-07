package gui.controller;

import Util.Date_solver;
import Util.Tipos;
import bussines.Actividad;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ListCellFactoryItemActividades {
	@FXML
    private ImageView lciMenuContextual;

    @FXML
    private Text lciFechaActividad;

    @FXML
    private CheckBox lciTituloActividad;

    @FXML
    private HBox lciHbox;
    
    @FXML
    private Label lbTipo;
        
    public void setInformacion(Actividad actividad, ListaActividadesController listaActividadesController){
 
    	lciTituloActividad.setSelected(actividad.isFinalizada());
    	lciTituloActividad.setText(actividad.getTitulo());
    	lciFechaActividad.setText( Date_solver.obtenerFechaParaActividades(actividad.getFechafinalizacion()) );
    	lbTipo.setText(Tipos.obtainString(actividad));
    	lbTipo.setTextFill(actividad.getAsignatura().getColor());
    	
    	lciMenuContextual.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//crear el menú contextual en cada click 
				ContextMenu contextMenu = new ContextMenu();

				MenuItem editar = new MenuItem("Editar");
				editar.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						System.out.println("Ha seleccionado editar");
					}
				});
				
				MenuItem borrar = new MenuItem("Borrar");
				borrar.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						System.out.println("Ha seleccionado borrar");
						if(listaActividadesController!=null)
						listaActividadesController.eliminarActividad(actividad);
					}
				});
				
				MenuItem marcar = new MenuItem("Marcar como hecho");
				marcar.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						System.out.println("Ha seleccionado marcar como hecho");
						((Actividad)actividad).setFinalizada(true);
						if(listaActividadesController!=null)
						listaActividadesController.marcarActividadFinalizada(actividad);
					}
				});

				if(!actividad.isPara_despues()){
					MenuItem marcarParaDespues = new MenuItem("Para después");
					marcarParaDespues.setOnAction(new EventHandler<ActionEvent>() {
	
						@Override
						public void handle(ActionEvent event) {
							System.out.println("Ha seleccionado para despues");
							((Actividad)actividad).setPara_despues(true);
							if(listaActividadesController!=null)
							listaActividadesController.marcarActividadParaDespues(actividad);
						}
					});
					contextMenu.getItems().addAll(editar, borrar, marcar, marcarParaDespues);

				}else{
					contextMenu.getItems().addAll(editar, borrar, marcar);

				}
				
				contextMenu.show(lciMenuContextual, event.getScreenX(), event.getScreenY());
				
			}
		});
    	
    	lciTituloActividad.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if(lciTituloActividad.isSelected()){
					lciTituloActividad.setStyle("-fx-underline: true;");
					lciTituloActividad.setTextFill(Color.web("#dddddd"));
					lciFechaActividad.setFill(Color.web("#dddddd"));
					lbTipo.setTextFill(Color.web("#dddddd"));

					actividad.setFinalizada(true);
					if(listaActividadesController!=null)
					listaActividadesController.marcarActividadFinalizada(actividad);
					
				}
			}
		});
    	
    }
}
