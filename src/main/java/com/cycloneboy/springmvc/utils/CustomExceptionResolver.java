package com.cycloneboy.springmvc.utils;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CycloneBoy on 2017/7/28.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
       ex.printStackTrace();
       CustomException customException = null;

        //如果抛出的是系统自定义的异常则直接转换
       if(ex instanceof CustomException){
          customException = (CustomException) ex;
       }else {
           //如果抛出的不是系统自定义的异常则重新构造一个未知错误异常
           //这里我就也有CustomException省事了，实际中应该要再定义一个新的异常
           customException = new CustomException("系统未知错误");
       }

       //向前台返回错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",customException.getMessage());
        modelAndView.setViewName("error");

       return modelAndView;
    }
}
