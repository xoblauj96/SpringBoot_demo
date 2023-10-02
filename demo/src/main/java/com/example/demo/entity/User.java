package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "m_user")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String email;

//    @JsonIgnore
    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 120)
    private String name;

    private String civilId;
}
