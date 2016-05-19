package gui.controller;

import Util.Basics;
import Util.Date_solver;
import bussines.Actividad;
import bussines.Asignatura;
import bussines.Notificacion;
import bussines.Unidad_Logica;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ListCellFactoryItemNotificaciones {
	@FXML
    private Text tvDescripcion;

    @FXML
    private Text tvFecha;

    @FXML
    private Circle cColorAsignatura;

    @FXML
    private Text tvTituloAsignatura;
    
    public void setInformacion(Notificacion notificacion){
    	tvTituloAsignatura.setText(notificacion.getTitulo());
    	tvTituloAsignatura.setFont(Basics.generateFontById(9, 13));
    	tvDescripcion.setText(notificacion.getDescripcion());
    	tvDescripcion.setFont(Basics.generateFontById(3, 13));
    	//cColorAsignatura.setFill( notificacion.getActividad().getAsignatura().getColor() );
    	tvFecha.setFont(Basics.generateFontById(3, 10));
    	tvFecha.setText(Date_solver.obtenerFechaParaActividades(notificacion.getFecha_notificacion()));
    }

}
