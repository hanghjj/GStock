package com.gp1.gstock.dividend.utils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DividendUtils {
    public static String getPayPeriod(String payPerd){
        return switch (payPerd) {
            case "월배당" -> "MM";
            case "분기배당" -> "QT";
            case "반기배당" -> "HF";
            case "연배당" -> "YY";
            default -> "";
        };
    }
}
