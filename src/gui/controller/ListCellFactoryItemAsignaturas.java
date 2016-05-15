package gui.controller;


import Util.Basics;
import bussines.Asignatura;
import javafx.fxml.FXML;
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
	
	public void setInformacion(Asignatura asignatura){
		lciColor.setFill(asignatura.getColor());
		lciTitulo.setText(asignatura.getTitulo());
		lciTitulo.setFont(Basics.generateFontById(3, 16));
	}
	

}
