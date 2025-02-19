package com.example.spring_boot_foo_fighters.controller;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import com.example.spring_boot_foo_fighters.service.HumanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/humans")                                 // задает адрес  http://localhost:8080/humans
public class HumanController {

  private final HumanService humanService;                   //   HumanController зависит от HumanService

  @GetMapping()                                           // очередной адрес  http://localhost:8080/humans/getAll
  public List<HumanDto> getAllHumans(){
    List<HumanDto> allHumans = humanService.getAllHumans();// возвращает список всех хюманов
    return allHumans;
  }

  @GetMapping("/{id}")                                   // задает очередной адрес с переменной http://localhost:8080/humans/getById/1 - ...
  public HumanDto getHumanById(@PathVariable Long id){
    HumanDto humanById = humanService.getHumanById(id);// возвращает хюмана с запрошенным ID со строки адреса
    return humanById;
  }

  @PostMapping()
  public void saveContr(@RequestBody HumanDto humanDto){
    humanService.saveServ(humanDto);
  }

  @DeleteMapping("/{id}")
  public void deleteContr(@PathVariable Long id){
    humanService.deleteServ(id);
  }

  @PutMapping("/{id}")                                   //  http://localhost:8080/humans/getById/1 - ...
  public void updateContr(@PathVariable Long id, @RequestBody HumanDto humanDto){
    humanService.putServ(id, humanDto);                              // возвращает хюмана с запрошенным ID со строки адреса
  }

  @GetMapping("/age/{age}")                                      // SQL ЗАПРОС
  public List<HumanEntity> getHumansByAge(@PathVariable Integer age){
    return humanService.getHumansByAge(age);
  }

}
