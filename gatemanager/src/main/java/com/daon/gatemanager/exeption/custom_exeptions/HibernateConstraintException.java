package com.daon.gatemanager.exeption.custom_exeptions;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.RestApiException;

public class HibernateConstraintException extends RestApiException {

    public HibernateConstraintException(String code, String message) {
        super(code, message);
    }

    public HibernateConstraintException(ErrorCode errorCode) {
        super(errorCode);
    }

    public HibernateConstraintException(ErrorCode errorCode, Exception ex) {
        super(ex, errorCode);
    }
}
