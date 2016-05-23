package gui.controller;

import Util.Basics;
import Util.Date_solver;
import bussines.Notificacion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ListCellFactoryItemNotificaciones {
	@FXML
    private Label tvDescripcion;

    @FXML
    private Text tvFecha;

    @FXML
    private Circle cColorAsignatura;

    @FXML
    private Label tvTituloAsignatura;
    
    public void setInformacion(Notificacion notificacion){    	
    	tvTituloAsignatura.setText(notificacion.getTitulo());
    	tvTituloAsignatura.setFont(Basics.generateFontById(9, 13));
    	
    	tvDescripcion.setText( notificacion.getDescripcion() );
    	tvDescripcion.setFont(Basics.generateFontById(3, 13));
    	cColorAsignatura.setFill(Basics.HexToColor(notificacion.getColor()));
    	tvFecha.setFont(Basics.generateFontById(1, 10));
    	tvFecha.setText(Date_solver.obtenerFechaParaActividades(notificacion.getFecha_notificacion()));
    }

}
