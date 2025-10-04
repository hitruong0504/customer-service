package com.hitruong.profile.resource;

import com.hitruong.profile.domain.dto.ProfileDTO;
import com.hitruong.profile.domain.vm.ProfileVM;
import com.hitruong.profile.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class ProfileResource {
    private final ProfileService profileService;

    public ProfileResource(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("")
    public ResponseEntity<ProfileVM> createCustomer(
            @Valid @RequestBody ProfileDTO dto
    ){
        ProfileVM profileVM = profileService.createProfile(dto);
        return ResponseEntity.ok().body(profileVM);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileVM> getCustomer(
            @PathVariable Long id
    ){
        ProfileVM profileVM = profileService.getProfile(id);
        return ResponseEntity.ok().body(profileVM);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileVM> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody ProfileDTO dto
    ){
        ProfileVM profileVM = profileService.updateProfile(id, dto);
        return ResponseEntity.ok().body(profileVM);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        profileService.deleteProfile(id);
        return ResponseEntity.ok().build();
    }
}
