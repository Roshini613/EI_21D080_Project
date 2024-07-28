package com.classroom.util;

import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter getDateFormatter() {
        return dateFormatter;
    }
}
