package com.gp1.gstock.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class StringUtils {
    public static boolean isDigit(String str){return str.chars().allMatch(Character::isDigit);}
    public static boolean isEmpty(String str) {return str == null || str.isEmpty();}
    public static boolean equals(String str1, String str2) {return str1!=null&&str1.equals(str2);}
}
