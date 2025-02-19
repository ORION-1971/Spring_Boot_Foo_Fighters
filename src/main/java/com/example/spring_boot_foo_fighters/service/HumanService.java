package com.example.spring_boot_foo_fighters.service;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import com.example.spring_boot_foo_fighters.mapper.HumanMapper;
import com.example.spring_boot_foo_fighters.repository.HumanRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;                     // HumanService зависит от HumanRepository
    private final HumanMapper humanMapper;

    @Transactional
    public List<HumanDto> getAllHumans() {                              // возвращает список всех хюманов с базы данных
        List<HumanDto> humanDto = humanMapper.toHumanDto(humanRepository.findAll());
        return humanDto;
    }

    public HumanDto getHumanById(Long id) {                                // возвращает хюмана с базы данных по ID
        HumanEntity humanEntity = humanRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Human with id " + id + " not found"));        // если нет такого вернуть null
        HumanDto humanDto = humanMapper.toHumanDto(humanEntity);
        return humanDto;
    }

    public void saveServ(HumanDto humanDto) {                             // внесение изменений в базу данных через JSON
        humanRepository.save(humanMapper.toHumanEntity(humanDto));
    }

    public void deleteServ(Long id) {                                     // удаление с базы данных через JSON
        humanRepository.deleteById(id);
    }

    @Transactional
    public void putServ(Long id, HumanDto humanDto) {                                // возвращает хюмана с базы данных по ID
        HumanEntity humanEntity = humanMapper.toHumanEntity(getHumanById(id));

        humanEntity.setId(id);

        humanEntity.setName(humanDto.getName());
        humanEntity.setAge(humanDto.getAge());
        humanEntity.setCreatedAt(humanEntity.getCreatedAt());
        humanRepository.save(humanEntity);
    }

    public List<HumanEntity> getHumansByAge(Integer age) {                        // SQL   ЗАПРОС
        return humanRepository.getHumans(age);
    }
    /*public List<HumanEntity> getHumansByAge(Integer age) {
        return humanRepository.getHumanEntitiesByAgeIsLessThan(age);
    }*/
}
