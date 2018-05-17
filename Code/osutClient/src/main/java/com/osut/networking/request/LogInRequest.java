package com.osut.networking.request;

public class LogInRequest implements Request {
    @Override
    public String toJson() {
        return "{\"request_type\":\"logIn\", \"request_body\":{\"username\": \"fodorutioan\", \"password\": \"pass\"}}";
    }
}
