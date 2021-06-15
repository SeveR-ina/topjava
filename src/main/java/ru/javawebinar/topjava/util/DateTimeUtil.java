package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) < 0;
    }

    public static boolean isBetweenDateHalfOpen(LocalDate lt, LocalDate startTime, LocalDate endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

    public static LocalDate getLocalDateMin(String dateMin) {
        if (dateMin == null || dateMin.isEmpty()) {
            return LocalDate.MIN;
        }
        return LocalDate.parse(dateMin);
    }

    public static LocalDate getLocalDateMax(String dateMax) {
        if (dateMax == null || dateMax.isEmpty()) {
            return LocalDate.MAX;
        }
        return LocalDate.parse(dateMax);
    }

    public static LocalTime getLocalTimeMin(String timeMin) {
        if (timeMin == null || timeMin.isEmpty()) {
            return LocalTime.MIN;
        }
        return LocalTime.parse(timeMin);
    }

    public static LocalTime getLocalTimeMax(String timeMax) {
        if (timeMax == null || timeMax.isEmpty()) {
            return LocalTime.MAX;
        }
        return LocalTime.parse(timeMax);
    }
}

