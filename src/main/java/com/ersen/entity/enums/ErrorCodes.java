package com.ersen.entity.enums;

public enum ErrorCodes {

    INTERNAL_SERVER_ERROR(1000),
    ERR_USER_NOT_FOUND_EXCEPTION(1001),
    ERR_UNCORRECT_USER_TYPE(1002),
    ERR_CATEGORY_NOT_FOUND(1003),
    ERR_INVALID_REQUEST_PARAMETERS(1004),
    ERR_EMAIL_ALREADY_IN_USE(1012),
    ERR_USERNAME_ALREADY_TAKEN(1013);
    
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
