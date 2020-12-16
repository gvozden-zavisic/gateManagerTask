package com.daon.gatemanager.exeption;

public enum ErrorCode {
    GATE_MISS("200.403.001", "Gate missing"),
    FLIGHT_MISS("200.403.002", "Flight missing"),
    GATE_UNAVAILABLE("200.403.003", "Gate unavailable"),

    UNAUTHORIZED_ACCESS("401.403.001", "Unauthorized"),
    HEADER_MISS("400.403.402", "Header missing: "),
    NO_HANDLER("401.403.003", "No Handler Found"),
    INVALID_ARGUMENT("401.403.004", "Argument Not Valid"),
    MESSAGE_NOT_READABLE("401.403.005", "wrong formated request");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
