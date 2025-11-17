package com.attendly.Attendly.app.dto;

public class LoginResponse {
    private String message;
    private boolean success;
    public String token;

    public LoginResponse(){}

    public LoginResponse(String message, boolean success){
        this.message = message;
        this.success = success;
    }
    public LoginResponse(String message, boolean success, String token){
        this.message = message;
        this.success = success;
        this.token = token;
    }

    public  String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
