package com.daon.gatemanager.exeption;

public class DaonException extends RuntimeException {

    public DaonException() {
    }

    public DaonException(String message) {
        super(message);
    }

    public DaonException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaonException(Throwable cause) {
        super(cause);
    }

    public DaonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
