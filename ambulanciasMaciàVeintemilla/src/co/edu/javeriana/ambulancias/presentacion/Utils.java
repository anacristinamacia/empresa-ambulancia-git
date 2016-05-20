package co.edu.javeriana.ambulancias.presentacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
	/**
	 * Instancia una fecha y la retorna para obtener la fecha y hora actual 
	 * @return Retorna la fecha actual
	 */
	public static Date manejoFechas () {
		Date date = new Date();
		return date;
	}
	
	public static String formatDate(Date hora) {
		if (hora == null) return "NA";
		SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm a");
		return formatoHora.format(hora);
	}
}
