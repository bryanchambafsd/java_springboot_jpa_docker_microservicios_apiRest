package com.microservice.accounts.movements.microservice2.entity;

import java.math.BigDecimal;

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
@Table(name = "tbl_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_code")
    private int id;

    @Column(name = "acc_number", nullable = false, unique = true, length = 25)
    private String number;

    @Column(name = "acc_type", nullable = false, length = 25)
    private String type;

    @Column(name = "acc_balance", nullable = false, precision = 16, scale = 2)
    private BigDecimal balance;

    @Column(name = "acc_state", nullable = false)
    private String state;

    @Column(name = "acc_description", nullable = false, length = 255)
    private String description;

    @Column(name = "cli_code", nullable = false)
    private String idClient;

}
