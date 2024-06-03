package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.AccountMapper;
import com.digitechbb.smsv1.model.dtos.AccountDto;
import com.digitechbb.smsv1.model.entities.Account;
import com.digitechbb.smsv1.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        return accountMapper.toDTo(accountRepository.save(account));
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findByLogin(accountDto.login());
        if (account==null) return null;
        Account updatedAccount = accountMapper.toEntity(accountDto);
        updatedAccount.setId(account.getId());
        return accountMapper.toDTo(accountRepository.save(updatedAccount));
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accountList = accountRepository.findAll();
        if (accountList==null) return null;
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account a: accountList) {
            accountDtoList.add(accountMapper.toDTo(a));
        }
        return accountDtoList ;
    }

    @Override
    public AccountDto findAccountByLogin(String login) {
        Account account = accountRepository.findByLogin(login);
        if (account==null) return null;
        return accountMapper.toDTo(account);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void deleteByLogin(String login) {
        Account account = accountRepository.findByLogin(login);
        accountRepository.deleteById(account.getId());

    }
}
