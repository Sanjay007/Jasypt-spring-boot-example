package com.frugalis.jasypt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "AGE")
    Integer age;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "CITY")
    String city;

}
