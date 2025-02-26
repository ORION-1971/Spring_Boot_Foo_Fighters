package com.example.spring_boot_foo_fighters.controller;


import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import com.example.spring_boot_foo_fighters.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")                                   // задает очередной адрес с переменной http://localhost:8080/humans/getById/1 - ...
    public UserDto getHumanById(@PathVariable Long id){
        UserDto userById = userService.getUserById(id);// возвращает хюмана с запрошенным ID со строки адреса
        return userById;
    }

    @PostMapping
    public UserEntity save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }



    @PutMapping("/{id}")                                            //  http://localhost:8080/humans/getById/1 - ...
    public void updateContr(@PathVariable Long id, @RequestBody UserDto userDto){
        userService.putServ(id, userDto);                              // возвращает хюмана с запрошенным ID со строки адреса
    }
}
