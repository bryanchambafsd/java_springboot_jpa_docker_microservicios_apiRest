package com.microservice.accounts.movements.microservice2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.accounts.movements.microservice2.dto.AccountDto;
import com.microservice.accounts.movements.microservice2.entity.Account;
import com.microservice.accounts.movements.microservice2.exception.ResourseNotFoundException;
import com.microservice.accounts.movements.microservice2.mapper.AccountMapper;
import com.microservice.accounts.movements.microservice2.repository.AccountRepository;
import com.microservice.accounts.movements.microservice2.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> account = accountRepository.findAll();
        return account.stream().map((accounts) -> AccountMapper.mapToAccountDto(accounts)).toList();
    }

    @Override
    public AccountDto getAccountById(int accountId) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new ResourseNotFoundException("Account is not exists with the given ID: " + accountId));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto updateAccount(int accountId, AccountDto udatedAccount) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new ResourseNotFoundException("Account is not exists with the given ID: " + accountId));
        
        account.setNumber(udatedAccount.getNumber());
        account.setType(udatedAccount.getType());
        account.setBalance(udatedAccount.getBalance());
        account.setState(udatedAccount.getState());
        account.setDescription(udatedAccount.getDescription());
        account.setIdClient(udatedAccount.getIdClient());

        Account updatedAccountObj = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(updatedAccountObj);
    }

    @Override
    public void deleteAccount(int accountId) {
        accountRepository.findById(accountId)
        .ifPresentOrElse(accountRepository::delete, 
            () -> { throw new ResourseNotFoundException("Account does not exist with ID: " + accountId); });
    }

}
