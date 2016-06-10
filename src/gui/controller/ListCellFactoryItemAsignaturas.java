package gui.controller;

import Util.Basics;
import bussines.Asignatura;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ListCellFactoryItemAsignaturas  {
	@FXML 
	private HBox lciHBox;
	@FXML
    private Circle lciColor;
	@FXML
    private Text lciTitulo;
	
private boolean ctxmenu;
	
	public void setInformacion(Asignatura asignatura, MenuLateralController menulateral, MainController mainController){
		lciColor.setFill(asignatura.getColor());
		if(asignatura.getTitulo().length()<=8)
			lciTitulo.setText(asignatura.getTitulo());
		else
			lciTitulo.setText(asignatura.getTitulo().substring(0, 7)+"...");
		
		lciTitulo.setFont(Basics.generateFontById(3, 16));
		ctxmenu = false;
		
		lciHBox.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				ContextMenu contextMenu = new ContextMenu();

				if(event.getButton() == MouseButton.SECONDARY && !ctxmenu){
					
					System.err.println("Se ha hecho click derecho");
					//crear el menú contextual en right click 
					MenuItem eliminar = new MenuItem("Eliminar " + asignatura.getTitulo());
					eliminar.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							ctxmenu = true;
							if(menulateral!=null)
								menulateral.eliminarAsignatura(asignatura);
						}
					});
					
					MenuItem editar = new MenuItem("Editar "  + asignatura.getTitulo());
					editar.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							ctxmenu = false;
							if(menulateral!=null && mainController!=null){
								mainController.editarAsignatura(asignatura);
								menulateral.editarAsignatura(asignatura);
							}
						}
					});
					
					contextMenu.getItems().addAll(editar, eliminar);
					contextMenu.show(lciHBox, event.getScreenX(), event.getScreenY());
					contextMenu.setAutoHide(true);
					
				}
				
				if(!ctxmenu) ctxmenu = true;
				
				if(event.getButton() == MouseButton.PRIMARY){
					ctxmenu = false;
				}

			}
		});
	}
	

}
