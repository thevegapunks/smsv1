package com.digitechbb.smsv1.controllers;


import com.digitechbb.smsv1.model.dtos.AccountDto;
import com.digitechbb.smsv1.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    @PostMapping
    private AccountDto save(@RequestBody AccountDto accountDto){
        return accountService.save(accountDto);
    }
    @GetMapping("{login}")
    private AccountDto getAccountByLogin(@PathVariable String login){
        return accountService.findAccountByLogin(login);
    }
    @GetMapping
    private List<AccountDto> getAll(){
        return accountService.getAll();
    }
    @PutMapping
    private AccountDto update(@RequestBody AccountDto accountDto){
        return accountService.updateAccount(accountDto);
    }
    @DeleteMapping("{id}")
    private void deleteById(@PathVariable Long id){
        accountService.deleteById(id);
    }

    @DeleteMapping("/deleteByLogin/{login}")
    private void deleteByLogin(@PathVariable String login){
        accountService.deleteByLogin(login);
    }

}
