package es.dg.avan.jtools.control.tiempo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;

import es.dg.avan.jtools.exceptions.AvanToolException;

public class AvanControlFechas {
	
	//Obtencion de fechas para base de datos
	public static String getFechaEnStringParaDatabase(Date fecha) throws Exception {
		String pattern = "yyyy-MM-dd";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(fecha);
	}
	
	public static Date getFechaFromStringParaDatabase(String fecha) throws Exception {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.parse(fecha);
	}
	//Obtencion de fechas de hoy en distintos objetos de fecha
	public static Date getActualDay(){
	   Calendar calendario = Calendar.getInstance();
	   return calendario.getTime();
	}
	
	public static Calendar getActualDayCalendar(){
	   Calendar calendario = Calendar.getInstance();
	   calendario.getTime();
	   return calendario;
	}

	//Suma resta de dias. 
	public static Date getDateActualPlusDays(int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());
		calendario.add(Calendar.DATE,dias);
		return calendario.getTime();
	}
	public static Calendar getDateActualPlusDaysCalendar(int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());
		calendario.add(Calendar.DATE,dias);
		return calendario;
	}
	public static Date getDateActualMinusDays(int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());
		calendario.add(Calendar.DATE,-dias);
		return calendario.getTime();
	}
	public static Calendar getDateActualMinusDaysCalendar(int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new Date());
		calendario.add(Calendar.DATE,-dias);
		return calendario;
	}
	
	//Suma resta de dias desde una fecha 
	public static Date getDatePlusDays(Date fecha, int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.DATE,dias);
		return calendario.getTime();
	}
	public static Calendar getDatePlusDaysCalendar(Date fecha, int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.DATE,dias);
		return calendario;
	}
	public static Date getDateMinusDays(Date fecha, int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.DATE,-dias);
		return calendario.getTime();
	}
	public static Calendar getDateMinusDaysCalendar(Date fecha, int dias){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.DATE,-dias);
		return calendario;
	}
	
	
	//Operaciones con fechas para trabjos de calculo.

	public static int getDaysBetween(Date dayMenor, Date dayMayor) throws AvanToolException {
		long dias = -1;
		try {
	      Calendar calendar = new GregorianCalendar();
	      calendar.setTimeInMillis(dayMenor.getTime());
	      java.util.Date ffecha1 = new java.util.Date(calendar.getTimeInMillis());
	      calendar.setTimeInMillis(dayMayor.getTime());
	      java.util.Date ffecha2 = new java.util.Date(calendar.getTimeInMillis());
	      long diasEnMilis = ffecha1.getTime() - ffecha2.getTime();
	      dias = diasEnMilis / 86400000L;
	    } catch (Exception e){
		    throw new AvanToolException("".concat(e.toString()));
	    }
	    return (int)(dias*-1);
	}
	
	public static Date getDateAddMinutes(int minutes, Date fecha){
		return DateUtils.addMinutes(fecha, minutes);
		
	}
	
}
