package com.hitruong.customer.enumration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomerCode {

    CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "Customer not found.", HttpStatus.NOT_FOUND);

    private final String name;
    private final String message;
    private final HttpStatus httpStatus;
}
