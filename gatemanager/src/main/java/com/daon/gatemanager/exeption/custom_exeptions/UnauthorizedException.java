package com.daon.gatemanager.exeption.custom_exeptions;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.RestApiException;

public class UnauthorizedException extends RestApiException {

    public UnauthorizedException(String code, String message) {
        super(code, message);
    }

    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
