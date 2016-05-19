package gui.controller;

import java.io.IOException;

import bussines.Actividad;
import bussines.Notificacion;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class ListCellFactoryNotificaciones extends ListCell<Notificacion>{
	@Override
	protected void updateItem(Notificacion notificacion, boolean flag){
		super.updateItem(notificacion, flag);
		if(notificacion!=null){ 
			

			ListCellFactoryItemNotificaciones controllerItem = new ListCellFactoryItemNotificaciones();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/ListCellFactoryItemNotificaciones.fxml"));
			try {
				loader.setController(controllerItem);
				HBox hboxNotificaciones = (HBox)loader.load();

				controllerItem.setInformacion(notificacion);
				setGraphic(hboxNotificaciones);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			setGraphic(null);
		}
		 
	}
}
