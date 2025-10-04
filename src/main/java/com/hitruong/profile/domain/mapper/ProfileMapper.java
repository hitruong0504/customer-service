package com.hitruong.profile.domain.mapper;

import com.hitruong.profile.domain.Profile;
import com.hitruong.profile.domain.dto.ProfileDTO;
import com.hitruong.profile.domain.vm.ProfileVM;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileDTO toDto(Profile profile);
    Profile toEntity(ProfileDTO dto);
    ProfileVM toVM(Profile profile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Profile partialUpdate(ProfileDTO dto, @MappingTarget Profile profile);
}
