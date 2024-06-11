package com.digitechbb.smsv1.controllers;


import com.digitechbb.smsv1.model.dtos.AccountDto;
import com.digitechbb.smsv1.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping
    private ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto) {
        AccountDto accountDto1 = accountService.save(accountDto);
        return new  ResponseEntity<>(accountDto1,HttpStatus.OK);

    }

    @GetMapping("{login}")
    private ResponseEntity<AccountDto> getAccountByLogin(@PathVariable String login) {
        AccountDto accountDto = accountService.findAccountByLogin(login);
        if (accountDto != null) {
            return new  ResponseEntity<>(accountDto,HttpStatus.OK);
        } else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    private ResponseEntity<List<AccountDto>> getAll() {

        List<AccountDto> accountDtoList = accountService.getAll();
        if(accountDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(accountDtoList, HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<AccountDto> update(@RequestBody AccountDto accountDto) {
        AccountDto accountDto1 = accountService.updateAccount(accountDto);
        return new ResponseEntity<>(accountDto1,HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    private ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        boolean isDeleted = accountService.deleteById(id);
        if (isDeleted)
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByLogin/{login}")
    private ResponseEntity<Void> deleteByLogin(@PathVariable String login) {
        boolean isDeleted = accountService.deleteByLogin(login);
        if (isDeleted)
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);

        else {
            return  new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
