package com.example.spring_boot_foo_fighters.mapper;

import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setAge(userDto.getAge());
        userEntity.setName(userDto.getName());
        userEntity.setIsVerified(userDto.getIsVerified());

        return userEntity;
    }
}
