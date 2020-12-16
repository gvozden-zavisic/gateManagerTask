package com.daon.gatemanager.exeption.custom_exeptions;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.RestApiException;

public class EntityNotFoundException extends RestApiException {

    public EntityNotFoundException(String code, String message) {
        super(code, message);
    }

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

}