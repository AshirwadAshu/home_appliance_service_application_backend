package com.excel.homeas.exceptions.servicerequest;


public class ServiceRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceRequestException(String message) {
        super(message);
    }
}
