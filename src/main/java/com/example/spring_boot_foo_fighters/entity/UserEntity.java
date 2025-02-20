package com.example.spring_boot_foo_fighters.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.YesNoConverter;

import java.time.LocalDateTime;


@Entity
@Table(name = "users", schema = "foo_fighters")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    private Integer age;

    private String phoneNumber;

    @Column
    //@Convert(converter = YesNoConverter.class)         // конвертирует true в "Y" (исправить type в varchar(10)->liquibase
    private Boolean isVerified;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
