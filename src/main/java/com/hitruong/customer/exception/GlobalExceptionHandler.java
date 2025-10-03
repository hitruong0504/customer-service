package com.hitruong.customer.exception;

import com.hitruong.customer.enumration.CustomerCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handle(ApiException ex) {
        CustomerCode code = ex.getCustomerCode();

        Map<String, Object> response = new HashMap<>();
        response.put("status", code.getHttpStatus().value());
        response.put("name", code.getName());
        response.put("message", code.getMessage());
        response.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, code.getHttpStatus());
    }
}
