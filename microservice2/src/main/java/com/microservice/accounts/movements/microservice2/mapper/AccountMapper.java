package com.microservice.accounts.movements.microservice2.mapper;

import com.microservice.accounts.movements.microservice2.dto.AccountDto;
import com.microservice.accounts.movements.microservice2.entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto (Account account) {
        return new AccountDto(
            account.getId(),
            account.getNumber(),
            account.getType(),
            account.getBalance(),
            account.getState(),
            account.getDescription(),
            account.getIdClient()
        );
    }

    public static Account mapToAccount (AccountDto accountDto) {
        return new Account(
            accountDto.getId(),
            accountDto.getNumber(),
            accountDto.getType(),
            accountDto.getBalance(),
            accountDto.getState(),
            accountDto.getDescription(),
            accountDto.getIdClient()
        );
    }

}
