package com.hitruong.profile.domain.dto;

import lombok.Data;

@Data
public class ProfileDTO {
    private String email;
    private String password;
    private String phone;
    private String fullName;
    private String address;
    private Boolean isDeleted = false;
}
