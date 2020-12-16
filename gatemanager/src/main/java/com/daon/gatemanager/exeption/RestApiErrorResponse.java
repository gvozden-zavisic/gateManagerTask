package com.daon.gatemanager.exeption;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestApiErrorResponse {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private Object result;

    public RestApiErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public RestApiErrorResponse(Object result, String message, String code) {
        this.result = result;
        this.message = message;
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
