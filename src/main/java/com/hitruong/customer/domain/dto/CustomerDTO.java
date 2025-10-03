package com.hitruong.customer.domain.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String email;
    private String password;
    private String phone;
    private String fullName;
    private String address;
}
