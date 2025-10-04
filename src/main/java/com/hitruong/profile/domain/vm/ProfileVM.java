package com.hitruong.profile.domain.vm;


import com.hitruong.profile.enumration.ProfileRole;
import com.hitruong.profile.enumration.ProfileStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class ProfileVM {
    private Long id;
    private String email;
    private String fullName;
    private String phone;
    private String address;
    private ProfileRole role;
    private ProfileStatus status;
    private Instant createdAt;
    private Instant updateAt;
    private Boolean isDeleted;
}
