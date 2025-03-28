package com.example.spring_boot_foo_fighters.service;


import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import com.example.spring_boot_foo_fighters.exception.ErrorCode;
import com.example.spring_boot_foo_fighters.exception.ServiceException;
import com.example.spring_boot_foo_fighters.mapper.UserMapper;
import com.example.spring_boot_foo_fighters.rabbitmq.RabbitMqMessageSender;
import com.example.spring_boot_foo_fighters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RabbitMqMessageSender rabbitMqMessageSender;
    private final RedisTemplate<String, Object> redisTemplate;

    private static final String USERS_KEY = "users";       // Ключ для списка людей
    private static final String USER_KEY_PREFIX = "user:"; // Префикс для отдельных людей


    public UserEntity save(UserDto userDto) {
            if (userDto.getAge() < 20) {
                throw new ServiceException(ErrorCode.AGE_NOT_VALID);
            }
            if (userDto.getFirstName().length() > 15) {
                throw new ServiceException(ErrorCode.NAME_NOT_VALID, userDto.getFirstName());
            }

            UserEntity user1 = userMapper.toUserEntity(userDto);          /// перевод с Dto в Entity
            UserEntity user = userRepository.save(user1);                 /// сохранение Entity в БД

            //rabbitMqMessageSender.send(userDto);                         // С Security не работает!!!!

            //add user to redis
            redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), userMapper.toUserDto(user), 10, TimeUnit.MINUTES);
            return user;
    }

    public UserDto getUserById(Long id) {                                // возвращает хюмана с базы данных по ID
        String redisKey = USER_KEY_PREFIX + id;
        UserDto userDto = (UserDto) redisTemplate.opsForValue().get(redisKey);

        if (userDto != null) {
            log.info("Человек с ID {} найден в Redis", id);
            return userDto;
        }
        log.info("Человек с ID {} не найден в Redis, ищем в базе", id);

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));        // если нет такого вернуть null
        userDto = userMapper.toUserDto(userEntity);

        redisTemplate.opsForValue().set(redisKey, userDto, 10, TimeUnit.MINUTES);
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

    public void deleteServ(Long id) {                                     // удаление с базы данных через JSON
        userRepository.deleteById(id);
    }
}
