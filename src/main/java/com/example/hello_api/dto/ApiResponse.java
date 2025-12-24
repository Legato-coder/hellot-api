package com.example.hello_api.dto;

public class ApiResponse<T> {

    private String echoToken;
    private T data;
    private String message;

    // No-args constructor (needed by Jackson)
    public ApiResponse() {
    }

    // All-args constructor
    public ApiResponse(String echoToken, T data, String message) {
        this.echoToken = echoToken;
        this.data = data;
        this.message = message;
    }

    // Getter & Setter
    public String getEchoToken() {
        return echoToken;
    }

    public void setEchoToken(String echoToken) {
        this.echoToken = echoToken;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
