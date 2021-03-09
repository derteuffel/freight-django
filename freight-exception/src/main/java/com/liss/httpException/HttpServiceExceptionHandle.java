package com.liss.httpException;

import com.liss.utils.HttpErrorCodes;

public class HttpServiceExceptionHandle extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer errorCode;

    public HttpServiceExceptionHandle(String message) {
        super(message);
    }

    public HttpServiceExceptionHandle(String message,  HttpErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode.getCode();
    }


    public HttpServiceExceptionHandle(String message, Throwable cause) {
        super(message, cause);
    }


    public HttpServiceExceptionHandle(String message, Throwable cause, HttpErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

}

