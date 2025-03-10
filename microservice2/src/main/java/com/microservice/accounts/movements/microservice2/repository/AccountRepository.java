package com.microservice.accounts.movements.microservice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.accounts.movements.microservice2.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
