package com.erhsh.prj.distrmgmtsys.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @see com.ematchina.test.common.utils.date.DateTimeUtilsTest
 * @author Jingqi Xu
 */
public final class DateTimeUtils {
	//
	private static final GregorianCalendar CALENDAR = new GregorianCalendar();
	private static AtomicReference<DateTimeProvider> PROVIDER = new AtomicReference<DateTimeProvider>(new DefaultDateTimeProvider());

	//
	private static final int MIN_YEAR = 0;
	private static final int MAX_YEAR = 9999;
	private static final int MIN_MONTH = 0;
	private static final int MAX_MONTH = 11;
	private static final int MIN_DAY_OF_MONTH = 1;
	private static final int MAX_DAY_OF_MONTH = 31;
	private static final int DAYS_OF_MONTH[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	

	
	/**
	 * 
	 */
	public static Date currentDate() {
		return date(now());
	}
	
	public static Date currentTime() {
		return now();
	}
	
	public static long currentTimeInMillis() {
		return now().getTime();
	}
	
	/**
	 * 
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		return sdf.format(date);
	}
	
	public static String format(long date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		return sdf.format(new Date(date));
	}
	
	public static String formatCurrentDate(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		return sdf.format(currentDate());
	}
	
	public static String formatCurrentTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		return sdf.format(currentTime());
	}
	
	public static String lenientlyFormat(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(true);
		return sdf.format(date);
	}
	
	public static String lenientlyFormat(long date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(true);
		return sdf.format(new Date(date));
	}
	
	public static String lenientlyFormatCurrentDate(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(true);
		return sdf.format(currentDate());
	}
	
	public static String lenientlyFormatCurrentTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(true);
		return sdf.format(currentTime());
	}
	
	/**
	 * 
	 */
	public static Date parse(String pattern, String source) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			sdf.setLenient(false);
			return sdf.parse(source);
		} catch(Exception e) {
			throw new IllegalArgumentException("failed to parse " + source + " by pattern: " + pattern, e);
		}
	}
	
	public static Date lenientlyParse(String pattern, String source) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			sdf.setLenient(true);
			return sdf.parse(source);
		} catch(Exception e) {
			throw new IllegalArgumentException("failed to parse " + source + " by pattern: " + pattern, e);
		}
	}
	
	/**
	 * 
	 */
	public static boolean isWeekend(Date date) {
		final int dayOfWeek = getDayOfWeek(date);
		return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
	}
	
	public static boolean isMonday(Date date) {
		final int dayOfWeek = getDayOfWeek(date);
		return dayOfWeek == Calendar.MONDAY;
	}
	
	public static boolean isLeapYear(Date date) {
		return isLeapYear(getYear(date));
	}

	public static boolean isLeapYear(int year) {
		return CALENDAR.isLeapYear(year);
	}
	
	public static boolean isSameDay(Date d1, Date d2) {
		//
		assertNotNull(d1, "invalid parameter d1");
		assertNotNull(d2, "invalid parameter d2");
		
		//
		return date(d1).compareTo(date(d2)) == 0;
	}
	
	public static boolean isValidDate(int year, int month, int dayOfMonth) {
		//
		if (year < MIN_YEAR || year > MAX_YEAR) {
			return false;
		}
		if (month < MIN_MONTH || month > MAX_MONTH) {
			return false;
		}
		if (dayOfMonth < MIN_DAY_OF_MONTH || dayOfMonth > MAX_DAY_OF_MONTH) {
			return false;
		}
		
		//
		if (month == 1) {
			if (isLeapYear(year)) {
				if(dayOfMonth > 29) {
					return false;
				}
			} else {
				if(dayOfMonth > 28) {
					return false;
				}
			}
		} else {
			if(dayOfMonth > DAYS_OF_MONTH[month]) {
				return false;
			}
		}
		
		//
		Date gregorianChange = new GregorianCalendar().getGregorianChange();
		final int gcYear = DateTimeUtils.getYear(gregorianChange); // 1582
		final int gcMonth = DateTimeUtils.getMonth(gregorianChange); // Calendar.OCTOBER
		if(year == gcYear && month == gcMonth && (dayOfMonth >= 5 && dayOfMonth <= 14)) {
			return false;
		}
		
		//
		return true;
	}
	
	/**
	 * 
	 */
	public static Date date(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	public static java.sql.Date toSqlDate(Date date) {
		if(date == null) {
			return null;
		} else {
			return new java.sql.Date(date.getTime());
		}
	}
	
	public static Date valueOf(java.sql.Date date) {
		if(date == null) {
			return null;
		} else {
			return new Date(date.getTime());
		}
	}
	
	public static java.sql.Timestamp toTimestamp(Date date) {
		if(date == null) {
			return null;
		} else {
			return new java.sql.Timestamp(date.getTime());
		}
	}
	
	public static Date valueOf(java.sql.Timestamp timestamp) {
		if(timestamp == null) {
			return null;
		} else {
			return new Date(timestamp.getTime());
		}
	}
	
	public static Date valueOf(long milliSeconds) {
		return new Date(milliSeconds);
	}
	
	public static Date valueOf(int year, int month, int dayOfMonth) {
		// Precondition checking
		if(!isValidDate(year, month, dayOfMonth)) {
			throw new IllegalArgumentException("invalid parameters, year: " + year + ", month: " + month + ", dayOfMonth: " + dayOfMonth);
		}
		
		//
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 
	 */
	public static int getYear(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}
	
	public static int getDayOfMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getDayOfWeek(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
	public static int getHourOfDay(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}
	
	public static int getSecond(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}
	
	public static int getMilliSecond(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MILLISECOND);
	}
	
	public static int getLastDayOfMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static Date getFirstDateOfMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	
	public static Date getLastDateOfMonth(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, getLastDayOfMonth(date));
		return c.getTime();
	}
	
	public static int getLastDayOfWeek(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_WEEK);
	}
	
	public static Date getFirstDateOfWeek(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 1);
		return c.getTime();
	}
	
	public static Date getLastDateOfWeek(Date date) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, getLastDayOfWeek(date));
		return c.getTime();
	}	
	/**
	 * 
	 */
	public static Date addYear(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, delta);
		return c.getTime();
	}
	
	public static Date addMonth(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, delta);
		return c.getTime();
	}
	
	public static Date addDayOfMonth(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, delta);
		return c.getTime();
	}
	
	public static Date addWeekOfYear(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.WEEK_OF_YEAR, delta);
		return c.getTime();
	}
	
	public static Date addHourOfDay(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, delta);
		return c.getTime();
	}
	
	public static Date addMinute(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, delta);
		return c.getTime();
	}
	
	public static Date addSecond(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, delta);
		return c.getTime();
	}
	
	public static Date addMilliSecond(Date date, int delta) {
		//
		assertNotNull(date, "invalid parameter date");
		
		//
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MILLISECOND, delta);
		return c.getTime();
	}
	
	 
	/**
	 * 
	 */
	public static DateTimeProvider getProvider() {
		return PROVIDER.get();
	}

	public static void setProvider(DateTimeProvider provider) {
		PROVIDER.set(provider);
	}

	/**
	 * 
	 */
	private static Date now() {
		return getProvider().now();
	}
	
	private static void assertNotNull(Date date, String message) {
		if(date == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static long getDiffTime(Date fromDate, Date toDate) throws ParseException{
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date d1 = df.parse(df.format(fromDate));
		 Date d2 = df.parse(df.format(toDate));
		 long diff = d2.getTime() - d1.getTime();
		 return diff;
	}
	
	public static Date getPlusDate(Date date, long delta) throws ParseException{
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date d = df.parse(df.format(date));
		 long plus = d.getTime() + delta;
		 Date finalDate = new Date(plus);
		 return finalDate;
	}
	/**
	 * 
	 */
	public static interface DateTimeProvider {
		
		Date now();
	}
	
	public static class DefaultDateTimeProvider implements DateTimeProvider {

		public Date now() {
			return new Date();
		}
	}
	
}
