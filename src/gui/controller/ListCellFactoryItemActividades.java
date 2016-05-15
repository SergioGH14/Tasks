package gui.controller;

import Util.Date_solver;
import bussines.Actividad;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    
    public void setInformacion(Actividad actividad){
 
    	lciTituloActividad.setSelected(actividad.isFinalizada());
    	lciTituloActividad.setText(actividad.getTitulo());
    	//convertidor de fecha prox
    	lciFechaActividad.setText( Date_solver.obtenerFechaParaActividades(actividad.getFechafinalizacion()) );
    }

}
