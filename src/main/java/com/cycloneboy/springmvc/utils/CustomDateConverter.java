package com.cycloneboy.springmvc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public class CustomDateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return  simpleDateFormat.parse(source);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return  null;
    }
}
