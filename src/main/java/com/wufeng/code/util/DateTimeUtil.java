package com.wufeng.code.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author niuyq
 */
public class DateTimeUtil {
    public static final String DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    public static String date2String(Date date) {
        return date2String(date, DATE_TIME_FORMAT_STR);
    }

    public static String date2String(Date date, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        return sd.format(date);
    }

    public static Date string2Date(String date, String format) {
        try {
            SimpleDateFormat sd = new SimpleDateFormat(format);
            return sd.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String subDays(Date date, int days) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return date2String(cal.getTime());
    }
}
