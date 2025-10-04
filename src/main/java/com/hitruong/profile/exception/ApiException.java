package com.hitruong.profile.exception;

import com.hitruong.profile.enumration.ProfileCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ProfileCode profileCode;

    public ApiException(ProfileCode profileCode) {
        super(profileCode.getMessage());
        this.profileCode = profileCode;
    }
}
