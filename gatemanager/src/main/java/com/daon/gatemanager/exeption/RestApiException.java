package com.daon.gatemanager.exeption;

public class RestApiException extends DaonException {

    private Object result;

    private String message;

    private String code;

    public RestApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestApiException(ErrorCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public RestApiException(Object result, ErrorCode code) {
        this.result = result;
        this.code = code.getCode();
        this.message = code.getMessage();
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