package com.ersen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ersen.entity.enums.ErrorCodes;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Username already taken")
public class UsernameAlreadyTakenException extends GeneralException {

    public UsernameAlreadyTakenException(final String message) {
        super(ErrorCodes.ERR_USERNAME_ALREADY_TAKEN, message);
    }

    private static final long serialVersionUID = 1L;

}
