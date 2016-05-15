package Util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Date_solver {
	
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
	 
	//restar los dias de un localDatetime
	public static LocalDateTime restar(long dias, LocalDateTime fecha){ 
		return  fecha.minusDays(dias);
	}
	
	//Devuelve la hora del sistema en formato date 
    public static Date getHoraActual() {
        Date ahora = new Date();
        System.out.println("Datesolver ahora-->"+ahora);
        return ahora; 
	  }
	    
    //devuelve en String la fecha pasada por parametros en formato dia, mes y a�o 
    public static String dateastring(Date d){
    	 SimpleDateFormat formateador = new SimpleDateFormat("dd:MM:yyyy");
    	 String f = formateador.format(d);
    	 return f;
    }
    
    //convertir localdate en localdatetime
    public static LocalDateTime convertirLocalDateEnLocalDateTime(LocalDate localDate){
    	return localDate.atStartOfDay();
    }
    
    //metodos usados para persistencia
    public static LocalDateTime convertirDateSQLEnLocalDateTime(java.sql.Date date){
    	DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
    	String text = date.toLocalDate().format(dTF);
    	LocalDate localdt = LocalDate.parse(text, dTF);
    	return localdt.atStartOfDay();
    }
    
    
    public static java.sql.Date convertirLocalDateEnSQL( LocalDateTime date) {
        return java.sql.Date.valueOf(date.toLocalDate());
    }
  
    //Añade al String año todo lo que necesita un LocalDateTime
  		public static String getDateinString(String date){
  			String res = date+"-09-10";
  			res+="T00:00:00";//hour by default with only date
  			return res;
  		}
  	//Convierte un String de forma yyyy (anyo) en localdatetime
  		public static LocalDateTime setDateinLocaleDateTime(String date){
  			LocalDateTime dateTime = null;
  			try{
  				date = getDateinString(date);
  				
  				dateTime= LocalDateTime.parse(date);
  				
  			}catch(Exception e){
  				System.out.println("Ocurrió un error al obtener una fecha válida por el sistema");
  			}
  			return dateTime;
  		
  		}
    
    //fecha con formato:
    public static LocalDateTime formatLocalDateTime(LocalDateTime date){
    	DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
    	String text = date.format(dTF);
    	LocalDate localdt = LocalDate.parse(text, dTF);
    	return localdt.atStartOfDay();
    }
    
    public static String obtenerFechaParaActividades(LocalDateTime date){
    	DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd MMM uuuu");
    	return dTF.format(date);
    }
}

 
