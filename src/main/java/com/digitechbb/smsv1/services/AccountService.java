package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto save(AccountDto accountDto);
   AccountDto updateAccount(AccountDto accountDto);
    List<AccountDto> getAll();
    AccountDto findAccountByLogin(String login);
    boolean deleteById(Long id);
   boolean deleteByLogin(String login);

}
