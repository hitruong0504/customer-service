package com.hitruong.customer.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private String address;
    @Enumerated(EnumType.STRING)
    private CustomerRole role;
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;
    private Instant createdAt;
}
