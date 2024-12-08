package org.taskmanager.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.taskmanager.model.dto.AccountRegistrationDTO;
import org.taskmanager.model.entity.Account;
import org.taskmanager.service.AccountService;

import java.util.Map;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public void createAccount(@RequestBody AccountRegistrationDTO accountRegistrationDTO){
        accountService.createAccount(accountRegistrationDTO);
    }

    @GetMapping
    public Account getAccount(@RequestBody AccountRegistrationDTO accountRegistrationDTO){
        return accountService.getAccount(accountRegistrationDTO);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Map<String, String> updateAccountData){
        accountService.updateAccount(id,updateAccountData);
    }

    @DeleteMapping("/{id}")
    public void removeAccount(@PathVariable Long id){
        accountService.changeAccountStatus(id,false);
    }

    @PostMapping("/{id}")
    public void restoreAccount(@PathVariable Long id){
        accountService.changeAccountStatus(id,true);
    }
}
