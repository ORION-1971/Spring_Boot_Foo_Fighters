package com.example.spring_boot_foo_fighters.service;


import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.mapper.UserMapper;
import com.example.spring_boot_foo_fighters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void save(UserDto userDto) {
        userRepository.save(userMapper.toUserEntity(userDto));
    }
}
