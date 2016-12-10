package com.ersen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ersen.entity.enums.ErrorCodes;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "unknown category")
public class CategoryNotFoundException extends GeneralException {

	private static final long serialVersionUID = 1L;
	
	public CategoryNotFoundException() {
		super(ErrorCodes.ERR_EMAIL_ALREADY_IN_USE);
	}

}
