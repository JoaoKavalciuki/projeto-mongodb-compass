package com.mongoproject.compassmongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Util {
    public static String decodeParam(String query){
        try{
            return URLDecoder.decode(query, "UTF-8");

        } catch(UnsupportedEncodingException exception){
            return  "";
        }
    }
}
