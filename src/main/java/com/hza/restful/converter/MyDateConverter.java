package com.hza.restful.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by hza
 * 2019-11-15 11:42
 */
public class MyDateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        try {
            Date date = sdf.parse(s);
            return date ;
        } catch (ParseException e) {
            return null ;
        }
    }
}
