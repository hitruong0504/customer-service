package com.hitruong.customer.enumration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomerCode {

    CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "Customer not found.", HttpStatus.NOT_FOUND),
    EMAIL_EXISTS("EMAIL_EXISTS", "Email already exists.", HttpStatus.BAD_REQUEST),
    CUSTOMER_NOT_FOUND_BY_ID_AND_EMAIL("CUSTOMER_NOT_FOUND_BY_ID_AND_EMAIL", "Customer not found by id and email.", HttpStatus.NOT_FOUND),;

    private final String name;
    private final String message;
    private final HttpStatus httpStatus;
}
