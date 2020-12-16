package com.daon.gatemanager.exeption.custom_exeptions;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.RestApiException;

public class GateException extends RestApiException {

    public GateException(String code, String message) {
        super(code, message);
    }

    public GateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public GateException(Object result, ErrorCode errorCode) {
        super(result, errorCode);
    }
}
