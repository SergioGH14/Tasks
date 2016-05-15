package gui.controller;

import java.io.IOException;

import bussines.Asignatura;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class ListCellFactoryAsignaturas extends ListCell<Asignatura>{
	
	@Override
	protected void updateItem(Asignatura asignatura, boolean flag){
		super.updateItem(asignatura, flag);
		if(asignatura!=null){ 
			

			ListCellFactoryItemAsignaturas controllerItem = new ListCellFactoryItemAsignaturas();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/ListCellFactoryItemAsignaturas.fxml"));
			try {
				loader.setController(controllerItem);
				HBox hboxItemsAsignaturas = (HBox)loader.load();

				controllerItem.setInformacion(asignatura);
				setGraphic(hboxItemsAsignaturas);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		 
	}
}
