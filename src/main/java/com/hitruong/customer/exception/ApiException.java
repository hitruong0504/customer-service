package com.hitruong.customer.exception;

import com.hitruong.customer.enumration.CustomerCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class ApiException extends RuntimeException {

    private final CustomerCode customerCode;

    public ApiException(CustomerCode customerCode) {
        super(customerCode.getMessage());
        this.customerCode = customerCode;
    }
}
