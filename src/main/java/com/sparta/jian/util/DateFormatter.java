package com.sparta.jian.util;

public class DateFormatter {

    public static String changeDateFormat(String date){

        String[] values = date.split("/");
        date = values[2] + "-" + values[0] +"-" + values[1];
        return date;
    }
}
