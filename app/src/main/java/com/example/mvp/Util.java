package com.example.mvp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final DateFormat dateFormatTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());

    public static String parseDate(Date date) {
        return dateFormatTime.format(date);
    }

    public static String currentDate() {
        return dateFormat.format(new Date());
    }

    public static String currentDateMinusDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -days);
        return dateFormat.format(calendar.getTime());
    }
}
