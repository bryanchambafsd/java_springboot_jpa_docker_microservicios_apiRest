package com.microservice.accounts.movements.microservice2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.accounts.movements.microservice2.dto.AccountDto;
import com.microservice.accounts.movements.microservice2.service.AccountService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    // GET ALL ACCOUNTS REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts() {
        List<AccountDto> account = accountService.getAllAccounts();
        return ResponseEntity.ok(account);
    }

    // GET ACCOUNT REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") int accountId) {
        AccountDto accountDto = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDto);
    }
    
    // ADD ACCOUNT REST API
    @Validated
    @PostMapping
    public ResponseEntity<AccountDto> createAccount (@Valid @RequestBody AccountDto accountDto){
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    // UPDATE ACCOUNT REST API
    @Validated
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount (@PathVariable("id") int accountId, 
                                            @Valid @RequestBody AccountDto updatedAccountDto) {
        AccountDto accountDto = accountService.updateAccount(accountId, updatedAccountDto);
        return ResponseEntity.ok(accountDto);
    }

    // SOFT DELETE ACCOUNT REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") int accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}
