package com.microservice.accounts.movements.microservice2.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mov_date", nullable = false)
    private LocalDate date;

    @Column(name = "mov_type", nullable = false, length = 25)
    private String type;

    @Column(name = "mov_value", nullable = false, precision = 16, scale = 2)
    private BigDecimal value;

    @Column(name = "mov_balance", nullable = false, precision = 16, scale = 2)
    private BigDecimal balance;

    @Column(name = "mov_state", nullable = false, length = 25)
    private String state;

    @ManyToOne
    @JoinColumn(name = "acc_code", referencedColumnName = "acc_code", nullable = false)
    private Account accountId;

}
