package com.daon.gatemanager.api.model;

public enum ApiResponseCode {

    FLIGHT_GATE_AVAILABLE("200.000.001", "Gate is available"),
    GATE_UPDATED("200.403.002", "Gate updated");

    private String code;
    private String message;

    ApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
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
