package com.hitruong.profile.service;

import com.hitruong.profile.domain.dto.ProfileDTO;
import com.hitruong.profile.domain.vm.ProfileVM;
import jakarta.validation.Valid;

public interface ProfileService {
    ProfileVM createProfile(@Valid ProfileDTO dto);

    ProfileVM getProfile(Long id);

    ProfileVM updateProfile(Long id, @Valid ProfileDTO dto);

    void deleteProfile(Long id);
}
