package com.example.taskmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public static String formatDateToString(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return dateFormat.format(date);
    }

    public static Date parseDate(String dateString) throws ParseException {

        if (dateString == null || "".equals(dateString)) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return dateFormat.parse(dateString);
    }
}
