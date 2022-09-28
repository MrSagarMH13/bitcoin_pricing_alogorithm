package com.cyphertek.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse<T> {

    private T result;
    private boolean isSuccess;
    private HttpStatus statusCode;
    private ServiceError error = null;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @JsonProperty("isSuccess")
    public boolean isSuccess() {
        return isSuccess;
    }

    @JsonProperty("isSuccess")
    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ServiceError getError() {
        return error;
    }

    public void setError(ServiceError error) {
        this.error = error;
    }

    public ServiceResponse<T> success(T tResult) {
        ServiceResponse<T> serviceResponse = new ServiceResponse<>();
        serviceResponse.setResult(tResult);
        serviceResponse.setSuccess(true);
        serviceResponse.setStatusCode(HttpStatus.OK);
        return serviceResponse;
    }

    public ServiceResponse<T> errorResult(String message) {
        return this.errorResult(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceResponse<T> errorResult(String message, HttpStatus httpStatusCode) {
        return this.errorResult(new ServiceError(message), httpStatusCode);
    }

    public ServiceResponse<T> errorResult(String message, ServiceError serviceError) {
        return this.errorResult(message, serviceError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceResponse<T> errorResult(String message, ServiceError serviceError, HttpStatus httpStatusCode) {
        return this.errorResult(new ServiceError(message, serviceError), httpStatusCode);
    }

    public ServiceResponse<T> errorResult(ServiceError serviceError) {
        return this.errorResult(serviceError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ServiceResponse<T> errorResult(ServiceError exception, HttpStatus httpStatusCode) {
        ServiceResponse<T> serviceResponse = new ServiceResponse<>();
        serviceResponse.setResult(null);
        serviceResponse.setSuccess(false);
        serviceResponse.setError(exception);
        serviceResponse.setStatusCode(httpStatusCode);
        return serviceResponse;
    }
}
