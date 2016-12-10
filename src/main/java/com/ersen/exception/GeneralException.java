package com.ersen.exception;

import com.ersen.entity.enums.ErrorCodes;

/**
 * Base custom exception specified for application.<br>
 * All custom exceptions must extend this class to define their special error code
 * 
 * @author ersen
 *
 */
public abstract class GeneralException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String exceptionMessage;

    public GeneralException(ErrorCodes code) {
        this.code = code.getCode();
    }

    public GeneralException(ErrorCodes code, String message) {
        this(code);
        this.exceptionMessage = message;
    }

    public int getCode() {
        return code;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }


}
