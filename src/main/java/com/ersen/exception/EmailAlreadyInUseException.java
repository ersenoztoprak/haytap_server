package com.ersen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ersen.entity.enums.ErrorCodes;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "E-Mail address already in use")
public class EmailAlreadyInUseException extends GeneralException {

    public EmailAlreadyInUseException(final String message) {
        super(ErrorCodes.ERR_EMAIL_ALREADY_IN_USE, message);
    }

    private static final long serialVersionUID = 1L;

}
