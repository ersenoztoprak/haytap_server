package com.ersen.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ersen.entity.dto.response.RestErrorMessage;
import com.ersen.entity.enums.ErrorCodes;
import com.ersen.exception.GeneralException;

/**
 * Globally catches, logs and handles exceptions
 * 
 * @author ersen
 *
 */
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleInvalidRequest(Exception e, ServletWebRequest request) {

        HttpStatus httpStatus = null;
        int errorCode = 0;
        String exceptionMessage = null;
        HttpHeaders headers = new HttpHeaders();

        ResponseStatus st = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        if (st != null && e instanceof GeneralException) {
        	GeneralException se = (GeneralException) e;

            httpStatus = st.value();
            exceptionMessage = se.getExceptionMessage() != null ? se.getExceptionMessage() : st.reason();
            errorCode = se.getCode();
            logger.error("Request: " + request.getRequest().getRequestURL() + " raised " + e);

        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            errorCode = ErrorCodes.INTERNAL_SERVER_ERROR.getCode();
            exceptionMessage = "An internal error has occured";
            logger.error(exceptionMessage, e);
        }

        headers.setContentType(MediaType.APPLICATION_JSON);

        RestErrorMessage error = new RestErrorMessage(httpStatus, errorCode, exceptionMessage, e.toString(), request.getRequest().getRequestURI());
        return handleExceptionInternal(e, error, headers, httpStatus, request);
    }
}