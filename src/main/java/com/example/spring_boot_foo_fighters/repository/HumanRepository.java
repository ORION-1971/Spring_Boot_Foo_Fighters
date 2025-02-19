package com.example.spring_boot_foo_fighters.repository;

import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<HumanEntity, Long> {   // JPA - Магия методов

    //@Query("select h from HumanEntity h where h.age < :age")

    @NativeQuery("select * from humans where age < :age")
    List<HumanEntity> getHumans(@Param("age") Integer age);


    //List<HumanEntity> getHumanEntitiesByAgeIsLessThan(Integer age);


}


/*public interface HumanRepository extends PagingAndSortingRepository<HumanEntity, Long> {       // HumanRepository зависит от Entity

  @Query("select h from HumanEntity h")                               // вывод всех значений с базы данных
  List<HumanEntity> getAllHumans();                                   // создание списка из значений

  //@Query("select h from HumanEntity h where h.id=:id")                // вывод с заданным :id
  //HumanEntity getHumanById(Long id);                                   // заданный (id)

  void save(HumanEntity human);                                      // запись изменений в базе
}*/
