package com.microservice.accounts.movements.microservice2.service;

import java.util.List;

import com.microservice.accounts.movements.microservice2.dto.AccountDto;

public interface AccountService {

    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(int AccountId);
    AccountDto createAccount(AccountDto AccountDto);
    AccountDto updateAccount(int AccountId, AccountDto udatedAccount);
    void deleteAccount(int AccountId);

}
