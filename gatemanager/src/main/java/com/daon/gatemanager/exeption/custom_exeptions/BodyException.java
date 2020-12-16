package com.daon.gatemanager.exeption.custom_exeptions;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.RestApiException;

public class BodyException extends RestApiException {

    public BodyException(String code, String message) {
        super(code, message);
    }

    public BodyException(ErrorCode errorCode) {
        super(errorCode);
    }
}
