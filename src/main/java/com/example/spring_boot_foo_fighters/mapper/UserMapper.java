package com.example.spring_boot_foo_fighters.mapper;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    @Mapping(target = "name", source = "firstName")
    @Mapping(target = "phoneNumber", expression = "java(deletePlus(userDto.getPhoneNumber()))")
    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);

    List<UserDto> toUserDto(List<UserEntity> userEntity);

    default String deletePlus(String phoneNumber) {
        return phoneNumber.replace("+", "");
    }

}
