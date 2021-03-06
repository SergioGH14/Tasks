package gui.controller;

import java.io.IOException;

import bussines.Actividad;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class ListCellFactoryActividades extends ListCell<Actividad>{
	private ListaActividadesController listaActividadesController;
	
	public ListCellFactoryActividades(ListaActividadesController listaActividadesController) {
		this.listaActividadesController = listaActividadesController;
	}
	
	@Override
	protected void updateItem(Actividad actividad, boolean flag){
		super.updateItem(actividad, flag);
		if(actividad!=null){ 
			

			ListCellFactoryItemActividades controllerItem = new ListCellFactoryItemActividades();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view/ListCellFactoryItemActividades.fxml"));
			try {
				loader.setController(controllerItem);
				HBox hboxItemsAsignaturas = (HBox)loader.load();

				controllerItem.setInformacion(actividad, listaActividadesController);
				setGraphic(hboxItemsAsignaturas);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			setGraphic(null);
		}
		 
	}
}
