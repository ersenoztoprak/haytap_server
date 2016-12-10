package com.ersen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ersen.entity.enums.ErrorCodes;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "user not found")
public class UserNotFoundException extends GeneralException {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super(ErrorCodes.ERR_USERNAME_ALREADY_TAKEN);
	}

}
