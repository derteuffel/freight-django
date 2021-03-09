package com.liss;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtils {

	  public  Date convertStringToDate_(String dateInString){
		  	 
		   if(dateInString.indexOf('-') > -1) dateInString = dateInString.replace("-", "/"); 
		  	
		    SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
			try {
				 return formater.parse(dateInString);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			} 
	  }

	  public  Date convertStringToDate(String dateInString){
		    SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			try {
				 return formater.parse((dateInString).toString());
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			} 
	   }
	  
	  /**
	   * @author Issofa
	   */
	  public String convertLocalDateTimeToString(LocalDateTime dateTime) {
		  try {
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			 return  dateTime.format(formatter); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	  }
	  /**
	   * @author Issofa
	   */
	  public LocalDateTime convertStringToLocalDateTime(String dateInString) { 
		 try {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
			 return LocalDateTime.parse(dateInString, formatter);
		 } catch (Exception e) {
				e.printStackTrace();
				return null;
		 }  
		  
	  }
	 /**Ajout d'un jour à une date*/ 
	  public Date addOneDayToDate(Date date) {
		  Calendar c = Calendar.getInstance(); 
		  c.setTime(date); 
		  c.add(Calendar.DATE, 1);
		  return c.getTime();  
	  }
	  /**retrait d'un jour à une date*/ 
	  public Date removeOneDayToDate(Date date) {
		  Calendar c = Calendar.getInstance(); 
		  c.setTime(date); 
		  c.add(Calendar.DATE, -1);
		  return c.getTime();  
	  }
	  
	  public String convertDateToString(Date date) {
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		 //System.err.println("t-est heur:"+df.format(getStartOfDay(date)));
		   return df.format(getStartOfDay(date));
		   
	  }
	  
	  /** donne le debut d'un jour precis**/
	   public Date getStartOfDay(Date date) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.set(Calendar.HOUR_OF_DAY, 0);
		    calendar.set(Calendar.MINUTE, 0);
		    calendar.set(Calendar.SECOND, 0);
		    calendar.set(Calendar.MILLISECOND, 0);
		    return calendar.getTime();
		}
 
	   /*** donne la fin d'un jour precis **/
	 	public Date getEndOfDay(Date date) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.set(Calendar.HOUR_OF_DAY, 23);
		    calendar.set(Calendar.MINUTE, 59);
		    calendar.set(Calendar.SECOND, 59);
		    calendar.set(Calendar.MILLISECOND, 999);
		    return calendar.getTime();
		}
	 	
}
