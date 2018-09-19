package com.spring_ssm_exception;

/**
 * 自定义异常类
 */
public class CustomException extends Exception{
    public CustomException(String message) {

        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
