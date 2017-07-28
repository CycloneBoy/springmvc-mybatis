package com.cycloneboy.springmvc.utils;

/**
 * Created by CycloneBoy on 2017/7/28.
 */
public class CustomException extends Exception{
        public String message;

        public CustomException(String message){
            super(message);
            this.message = message;
        }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
