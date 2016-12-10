package com.ersen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ersen.entity.enums.ErrorCodes;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request parameters")
public class InvalidRequestParametersException extends GeneralException {

    private static final long serialVersionUID = 1L;

    public InvalidRequestParametersException(String message) {
        super(ErrorCodes.ERR_INVALID_REQUEST_PARAMETERS, message);
    }

}
