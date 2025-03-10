package com.microservice.persons.clients.microservice1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_codigo")
    private int id;

    @Column(name = "per_identi", nullable = false, unique = true)
    private String identification;

    @Column(name = "per_name", nullable = false, length = 255)
    private String name;

    @Column(name = "per_gender", nullable = false, length = 25)
    private String gender;

    @Column(name = "per_age", nullable = false)
    private Short age;

    @Column(name = "per_direcc", nullable = false, length = 255)
    private String direction;

    @Column(name = "per_phone", nullable = false, length = 15)
    private String phone;

}
