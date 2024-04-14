package com.gp1.gstock.stock.utils;

public class StockUtils {
    public static String getVrssSign(String code){
        String sign = "";
        switch (code){
            case "1":
            case "2":
                sign = "+";
                break;
            case "3":
                sign = " ";
                break;
            case "4":
            case "5":
                sign = "-";
                break;
        }
        return sign;
    }
}
