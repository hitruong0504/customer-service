package com.hitruong.profile.domain;

import com.hitruong.profile.enumration.ProfileRole;
import com.hitruong.profile.enumration.ProfileStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String fullName;

    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)

    private ProfileRole role;

    @Enumerated(EnumType.STRING)

    private ProfileStatus status;

    private Instant createdAt;

    private Instant updateAt;

    private Boolean isDeleted;
}
