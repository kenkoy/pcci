package com.pcci.idlsweb.reports.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {
	/**
	 * Convert string value to Date format based on date format given
	 * @param <code>String</code> to convert
	 * @param stringFormat date format e.g MM/dd/yyyy
     * @return A <code>Date</code> parsed from the string. In case of
     *         error, returns null.
	 */
	public synchronized static Date strToDate(String stringFormat , String  dateString) {
		Date currentTime = null;
		dateString = DateUtil.handleString(dateString);
		if (!"".equals(dateString)) {
			try {
				if (stringFormat==null) {
					stringFormat = "MM/dd/yyyy";
				}
				SimpleDateFormat formatter = new SimpleDateFormat(stringFormat);
				ParsePosition pos = new ParsePosition(0);
				currentTime = formatter.parse(dateString, pos);
			} catch (Exception e) {
				return null;
			}
		}
		return currentTime;
	}
	
	/**
	 * Handle String by checking null & trim the value
	 * @param str <code>String</code>
     * @return  A copy of this string with leading and trailing white
     *          space removed, or this string if it has no leading or
     *          trailing white space or return "" if this string is null.
	 */
	public static String handleString(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}
	/**
	 * Gets the today.
	 *
	 * @param timeZone the time zone
	 *
	 * @return the today
	 *
	 * @method name		:getToday
	 */
	public static String getToday(String timeZone) {
		return getToday(timeZone, "MM/dd/yyyy");
	}
	/**
	 * Gets the today.
	 *
	 * @param timeZone the time zone
	 * @param pattern the pattern
	 *
	 * @return the today
	 *
	 * @method name		:getToday
	 */
	public static String getToday(String timeZone, String pattern) {
		
		TimeZone stimeZone = TimeZone.getTimeZone(timeZone);
		Calendar now = new GregorianCalendar();
		Date dt = now.getTime();
		SimpleDateFormat formatter1 = new SimpleDateFormat(pattern);
		formatter1.setTimeZone(stimeZone);
		String date = formatter1.format(dt);
		return date;
	}
	
	public static int dateDiff(String startDate, String endDate){
		Date dateFrom = DateUtil.strToDate(null,startDate);
		Date dateTo = DateUtil.strToDate(null,endDate);
		long dateDiff = dateTo.getTime() - dateFrom.getTime();
		int days = (int)dateDiff / (1000 * 60 * 60 * 24);
		
		return days;
	}
	
	public static int getNumDays(String startDate, String endDate){
		int days = dateDiff(startDate, endDate)+1;
		
		return days;
	}
	
	public static String dateToString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}

	public static String dateToString(Date date, String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = formatter.format(date);
		return strDate;
	}
}
