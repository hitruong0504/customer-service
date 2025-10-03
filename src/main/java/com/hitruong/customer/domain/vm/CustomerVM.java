package com.hitruong.customer.domain.vm;


import com.hitruong.customer.enumration.CustomerRole;
import com.hitruong.customer.enumration.CustomerStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class CustomerVM {
    private Long id;
    private String email;
    private String fullName;
    private String phone;
    private String address;
    private CustomerRole role;
    private CustomerStatus status;
    private Instant createdAt;
}
