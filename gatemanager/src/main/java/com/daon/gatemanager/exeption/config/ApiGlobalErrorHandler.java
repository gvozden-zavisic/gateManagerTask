package com.daon.gatemanager.exeption.config;

import com.daon.gatemanager.exeption.ErrorCode;
import com.daon.gatemanager.exeption.RestApiErrorResponse;
import com.daon.gatemanager.exeption.RestApiException;
import com.daon.gatemanager.exeption.custom_exeptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.StringJoiner;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiGlobalErrorHandler {

    @Autowired
    private ExceptionLogger logger;

    @ExceptionHandler({GateException.class})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    protected RestApiErrorResponse handleGate(RestApiException ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ex.getResult(), ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler({BodyException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected RestApiErrorResponse handle(RestApiException ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ex.getResult(), ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected RestApiErrorResponse handleFootprintOfferDate(RestApiException ex) {
        if (ex instanceof EntityNotFoundException)
            logger.error(EntityNotFoundException.class.getSimpleName().concat(" ").concat(ex.getCode()));
        else
            logger.error(ex);
        return new RestApiErrorResponse(ex.getResult(), ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    protected RestApiErrorResponse handleUnauthorized(UnauthorizedException ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler(HibernateConstraintException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected RestApiErrorResponse handleHibernateConstraintException(RestApiException ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestApiErrorResponse processRuntimeException(RuntimeException ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ex.getMessage(), "500");
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected RestApiErrorResponse missingHeader(MissingRequestHeaderException ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ErrorCode.HEADER_MISS.getMessage() + ex.getHeaderName(), ErrorCode.HEADER_MISS.getCode());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected RestApiErrorResponse handleNoHandlerFoundException(Exception ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ex.getMessage(), ErrorCode.NO_HANDLER.getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected RestApiErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        logger.error(ex);
        List<FieldError> bindingResult = ex.getBindingResult().getFieldErrors();
        StringJoiner errorFileds = new StringJoiner(",");
        for (FieldError error : bindingResult) {
            errorFileds.add(error.getField());
        }
        return new RestApiErrorResponse("Fields [" + errorFileds.toString() + "] in request are not valid", ErrorCode.INVALID_ARGUMENT.getCode());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected RestApiErrorResponse handleBadJsonException(Exception ex) {
        logger.error(ex);
        return new RestApiErrorResponse(ErrorCode.MESSAGE_NOT_READABLE.getMessage(), ErrorCode.MESSAGE_NOT_READABLE.getCode());
    }

}
