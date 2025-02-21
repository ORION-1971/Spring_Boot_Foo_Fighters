package com.example.spring_boot_foo_fighters.service;


import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import com.example.spring_boot_foo_fighters.mapper.UserMapper;
import com.example.spring_boot_foo_fighters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void save(UserDto userDto) {
        userRepository.save(userMapper.toUserEntity(userDto));
    }

    public UserDto getUserById(Long id) {                                // возвращает хюмана с базы данных по ID
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));        // если нет такого вернуть null
        UserDto userDto = userMapper.toUserDto(userEntity);
        return userDto;
    }



    @Transactional
    public void putServ(Long id, UserDto userDto) {                                // возвращает хюмана с базы данных по ID
        UserEntity userEntity = userRepository.findById(id).orElse(null);//userMapper.toUserEntity(getUserById(id));

        userEntity.setId(id);

        userEntity.setName(userDto.getFirstName());
        userEntity.setAge(userDto.getAge());
        userEntity.setIsVerified(userDto.getIsVerified());
        userEntity.setPhoneNumber(userDto.getPhoneNumber());
        userEntity.setCreatedDate(userEntity.getCreatedDate());
        userRepository.save(userEntity);
    }
}
