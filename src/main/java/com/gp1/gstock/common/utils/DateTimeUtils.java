package com.gp1.gstock.common.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeUtils {

    public static String getDateFormat(String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.now();
        return localDate.format(dateTimeFormatter);
    }
}
