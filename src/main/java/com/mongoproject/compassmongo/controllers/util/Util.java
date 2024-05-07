package com.mongoproject.compassmongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Util {
    public static String decodeParam(String query){
        try{
            return URLDecoder.decode(query, "UTF-8");

        } catch(UnsupportedEncodingException exception){
            return  "";
        }
    }

    public static Date converttDate(String textDate, Date defaultDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        try{
            return simpleDateFormat.parse(textDate);
        } catch(ParseException exception){
            return  defaultDate;
        }
    }
}
