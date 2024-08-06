package com.gp1.gstock.common.utils;

import com.gp1.gstock.common.Exception.CustomException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.gp1.gstock.common.constants.BizConstants.DEFAULT_ERR_MSG;

@Service
public class DateTimeUtils {

    public static String getDateFormat(String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.now();
        return localDate.format(dateTimeFormatter);
    }

    public static String convertDateFormat(String input, SimpleDateFormat inputDateFormat, SimpleDateFormat outputDateFormat){
        try {
            // 입력 문자열을 Date 객체로 파싱
            Date date = inputDateFormat.parse(input);
            // Date 객체를 원하는 형식으로 포맷팅
            return outputDateFormat.format(date);
        } catch (ParseException e) {
            throw new CustomException(DEFAULT_ERR_MSG);
        }
    }

}
