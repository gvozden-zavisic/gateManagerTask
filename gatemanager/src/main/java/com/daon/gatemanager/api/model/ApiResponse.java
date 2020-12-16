package com.daon.gatemanager.api.model;

public class ApiResponse<T> {
    private T results;
    private String code;
    private String message;

    public ApiResponse(T results, ApiResponseCode apiResponseCode) {
        this.results = results;
        this.code = apiResponseCode.getCode();
        this.message = apiResponseCode.getMessage();
    }

    public ApiResponse() {
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}