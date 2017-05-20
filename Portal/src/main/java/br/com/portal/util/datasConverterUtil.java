package br.com.portal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class datasConverterUtil {

	public String dateConverter(Calendar calendar) {

		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String data = format.format(date);

		return data;
	}

	public Calendar toCalendar(String data) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
		try {
			Date dateObj;
			dateObj = format.parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateObj);
			return calendar;
		} catch (ParseException e) {
			FacesUtil.msgErro("ERROOOO!!!!!!!");
			e.printStackTrace();
		}
		return null;

	}

}
