package com.example.spring_boot_foo_fighters.service;

import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import com.example.spring_boot_foo_fighters.mapper.UserMapper;
import com.example.spring_boot_foo_fighters.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserDto userDto;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init() {
        userDto = new UserDto();
    }

    @Test
    void save() {
        userDto.setAge(40);

        UserEntity userEntity = new UserEntity();

        when(userMapper.toUserEntity(userDto)).thenReturn(userEntity);       // (userMapper.toUserEntity(userDto)
        when(userRepository.save(userEntity)).thenReturn(userEntity);        // userRepository.save(...);
        //when(userRepository.save(userMapper.toUserEntity(userDto))).thenReturn(userEntity);

        UserEntity actual = userService.save(userDto);

        assertEquals(userEntity, actual);
    }

    @Test
    void save_IfAgeLessThan30_ThrowException() {
        userDto.setAge(20);

        assertThrows(IllegalArgumentException.class, () -> userService.save(userDto));
    }

        @Test
    void getUserById() {
    }

    @Test
    void putServ() {
    }

    @Test
    void deleteServ() {                                     // удаление с базы данных через JSON
        Long id = 333L;
        userRepository.deleteById(id);
        verify(userRepository, times(1)).deleteById(id);
    }
}