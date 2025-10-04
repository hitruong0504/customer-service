package com.hitruong.profile.service.impl;

import com.hitruong.profile.domain.Profile;
import com.hitruong.profile.enumration.ProfileCode;
import com.hitruong.profile.enumration.ProfileRole;
import com.hitruong.profile.enumration.ProfileStatus;
import com.hitruong.profile.domain.dto.ProfileDTO;
import com.hitruong.profile.domain.mapper.ProfileMapper;
import com.hitruong.profile.domain.vm.ProfileVM;
import com.hitruong.profile.exception.ApiException;
import com.hitruong.profile.repository.ProfileRepository;
import com.hitruong.profile.service.ProfileService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    private ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository, ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    @Override
    public ProfileVM createProfile(ProfileDTO dto) {
        if(profileRepository.existsByEmail(dto.getEmail())) {
            throw new ApiException(ProfileCode.EMAIL_EXISTS);
        }
        Profile profile = profileMapper.toEntity(dto);
        profile.setCreatedAt(Instant.now());
        profile.setStatus(ProfileStatus.PENDING);
        profile.setRole(ProfileRole.CUSTOMER);
        profile.setUpdateAt(Instant.now());
        profileRepository.save(profile);
        return profileMapper.toVM(profile);
    }

    @Override
    public ProfileVM getProfile(Long id){
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ApiException(ProfileCode.PROFILE_NOT_FOUND));
        return profileMapper.toVM(profile);
    }

    @Override
    public ProfileVM updateProfile(Long id, ProfileDTO dto) {
        Profile profile = profileRepository.findByEmailAndId(dto.getEmail(), id)
                .orElseThrow(() -> new ApiException(ProfileCode.PROFILE_NOT_FOUND_BY_ID_AND_EMAIL));
        profile = profileMapper.partialUpdate(dto, profile);
        profile.setUpdateAt(Instant.now());
        profileRepository.save(profile);
        return profileMapper.toVM(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ApiException(ProfileCode.PROFILE_NOT_FOUND));
        profile.setStatus(ProfileStatus.DELETED);
        profile.setIsDeleted(true);
        profile.setUpdateAt(Instant.now());
        profileRepository.save(profile);
    }
}
