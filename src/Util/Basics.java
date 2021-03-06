package Util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Basics {
	

	
	//para obtener una letra y el tamaño de letra aplicada a un Text/Label
	public static Font generateFontById(int id, double size){
		Font font = Font.getDefault();
		try{
			switch (id){
			case 1:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOREGULAR)), size);
			case 2:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOBOLD)), size);
			case 3:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOLIGHT)), size);
			case 4:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOTHIN)), size);
			case 5:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOCONDENSEDLIGHT)), size);
			case 6:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOCONDENSEDREGULAR)), size);
			case 7:
				return  Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOSLABBOLD)), size);
			case 8:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOSLABLIGHT)), size);
			case 9:
				return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOSLABREGULAR)), size);
			case 10:
		    	return Font.loadFont(new FileInputStream(new File(Constantes.ROBOTOSLABTHIN)), size);
			case 23:
		    	return Font.loadFont(new FileInputStream(new File(Constantes.ATELIEROMEGA)), size);
		    	  

			}
		}catch(Exception e){
			System.err.println("No se han podido cargar las fuentes");
		}
		
		return font;
		
	}
	
	public static String RGBToHex(Color color){
		return String.format( "#%02X%02X%02X",
	            (int)( color.getRed() * 255 ),
	            (int)( color.getGreen() * 255 ),
	            (int)( color.getBlue() * 255 ) );
	}
	
	public static Color HexToColor(String hexaColor){
		return Color.web(hexaColor);
	}
	
	public static String fechaByDate(Date date){
		return new SimpleDateFormat("dd/MM/yyyy").format( date ); 

	}
	
	public static int cuatrimestreActual(){
		LocalDateTime fecha = LocalDateTime.now();
		if((fecha.getMonthValue() > 8 && fecha.getMonthValue()<=12) || (fecha.getMonthValue()<2 && fecha.getMonthValue()>0) ){
			return 1;
		}
		if((fecha.getMonthValue() >= 2 && fecha.getMonthValue()<7)){
			return 2;
		}
		return 3;
	}
}
