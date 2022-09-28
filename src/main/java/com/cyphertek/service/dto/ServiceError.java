package com.cyphertek.service.dto;

public class ServiceError {
    private String stackTrace = null;
    private String source = null;
    private String message = null;
    private ServiceError innerException = null;

    public ServiceError() {
    }

    public ServiceError(String message) {
        this.message = message;
    }

    public ServiceError(String message, ServiceError innerException) {
        this.message = message;
        this.innerException = innerException;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServiceError getInnerException() {
        return innerException;
    }

    public void setInnerException(ServiceError innerException) {
        this.innerException = innerException;
    }
}
