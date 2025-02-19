package com.example.spring_boot_foo_fighters.repository;



import com.example.spring_boot_foo_fighters.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
