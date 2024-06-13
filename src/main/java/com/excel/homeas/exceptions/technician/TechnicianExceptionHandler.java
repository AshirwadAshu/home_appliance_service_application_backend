package com.excel.homeas.exceptions.technician;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.homeas.response.Response;

@RestControllerAdvice
public class TechnicianExceptionHandler {
    @ExceptionHandler(TechnicianException.class)
    public ResponseEntity<Response<String>> technicianNotFound(RuntimeException exp) {
        return ResponseEntity.status(HttpStatus.OK).body(Response.<String>builder()
                .data(null)
                .isError(true)
                .message("Technician Not Found")
                .build());
    }
}
