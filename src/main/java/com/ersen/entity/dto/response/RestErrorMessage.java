package com.ersen.entity.dto.response;

import org.springframework.http.HttpStatus;

/**
 * Error message format send to clients
 * 
 * @author ersen
 *
 */

public class RestErrorMessage {

    // http status code
    private int httpStatusCode;
    // custom error code of application
    private int code;
    // error description specified for exception
    private String message;
    // type of exception
    private String exception;
    // path send by client
    private String path;

    public RestErrorMessage(HttpStatus status, int code, String message, String exception, String path) {
        this.httpStatusCode = status.value();
        this.code = code;
        this.message = message;
        this.exception = exception;
        this.path = path;
    }

    public int getStatus() {
        return httpStatusCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getException() {
        return exception;
    }

    public String getPath() {
        return path;
    }
}