package com.example.spring_boot_foo_fighters.mapper;

import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "name", source = "firstName")
    @Mapping(target = "phoneNumber", expression = "java(deletePlus(userDto))")
    UserEntity toUserEntity(UserDto userDto);

    @Mapping(target = "firstName", source = "name")
    UserDto toUserDto(UserEntity userEntity);

    List<UserDto> toUserDto(List<UserEntity> userEntity);

    default String deletePlus(UserDto userDto) {
        return userDto.getPhoneNumber().replace("+", "");
    }

}
