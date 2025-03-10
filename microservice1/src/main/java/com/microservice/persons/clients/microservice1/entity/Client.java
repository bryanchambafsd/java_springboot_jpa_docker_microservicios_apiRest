package com.microservice.persons.clients.microservice1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "tbl_clients")
public class Client {

    @Id
    @Column(name = "cli_codigo", nullable = false, length = 25)
    private String id;

    @Column(name = "cli_passwo", nullable = false, length = 255)
    private String password;

    @Column(name = "cli_state", nullable = false, columnDefinition = "CHAR(1)")
    private String state;

    @OneToOne
    @JoinColumn(name = "per_codigo", referencedColumnName = "per_codigo")
    private Person idPerson;

}
