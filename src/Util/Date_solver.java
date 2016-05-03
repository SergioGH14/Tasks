package util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date_Solver {
	
	//suma los dias a la fecha pasada por parametros 
	//devolviendolo a en formato date

	public static  Date sumarFechasDias(Date fecha, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }
	
	
    //resta  los dias a la fecha pasada por parametros 
	//devolviendolo a en formato date

	public static Date restarFechasDias(Date fecha, int dias) {
	        Calendar cal = new GregorianCalendar();
	        cal.setTimeInMillis(fecha.getTime());
	        cal.add(Calendar.DATE, -dias);
	        return new Date(cal.getTimeInMillis());
	    }
	 
	    //Devuelve la hora del sistema en formato date 
	 
	    public static Date getHoraActual() {
	        Date ahora = new Date();
	      
	        return ahora; 
	  }
	    
    //devuelve en String la fecha pasada por parametros en formato dia, mes y a�o 
    public static String dateastring(Date d){
    	 SimpleDateFormat formateador = new SimpleDateFormat("dd:MM:yyyy");
    	 String f = formateador.format(d);
    	 return f;
    }
    
    //metodos usados para persistencia
    public static LocalDateTime convertirDateSQLEnLocalDate(java.sql.Date date){
    	DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
    	String text = date.toLocalDate().format(dTF);
    	LocalDate localdt = LocalDate.parse(text, dTF);
    	return localdt.atStartOfDay();
    }
    
    
    public static java.sql.Date convertirLocalDateEnSQL( LocalDateTime date) {
        return java.sql.Date.valueOf(date.toLocalDate());
    }
    
    //fecha con formato:
    public static LocalDateTime formatLocalDateTime(LocalDateTime date){
    	DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
    	String text = date.format(dTF);
    	LocalDate localdt = LocalDate.parse(text, dTF);
    	return localdt.atStartOfDay();
    }
    
}

 
