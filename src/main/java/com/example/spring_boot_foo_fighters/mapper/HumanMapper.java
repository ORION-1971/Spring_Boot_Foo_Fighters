package com.example.spring_boot_foo_fighters.mapper;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HumanMapper {             //     ПЕРЕНОС ДАННЫХ  С ENTITY B DTO

    public HumanEntity toHumanEntity(HumanDto humanDto) {          // переводчик с humanDTO в humanEntuty
        HumanEntity humanEntity = new HumanEntity();

        humanEntity.setAge(humanDto.getAge());
        humanEntity.setName(humanDto.getName());

        return humanEntity;
    }

    public HumanDto toHumanDto(HumanEntity humanEntity) {          // переводчик с humanEntuty в humanDTO
        HumanDto humanDto = new HumanDto();

        humanDto.setAge(humanEntity.getAge());
        humanDto.setName(humanEntity.getName());

        return humanDto;
    }

                                                                 //переводчик СПИСКА humanEntuty в  СПИСОК humanDTO
    public List<HumanDto> toHumanDto(List<HumanEntity> humanEntity) {

        return humanEntity.stream()
                .map(s -> new HumanDto(s.getName(), s.getAge()))
                .toList();
    }
}
