package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.exception.ResourceNotFoundException;
import com.digitechbb.smsv1.mappers.AccountMapper;
import com.digitechbb.smsv1.model.dtos.AccountDto;
import com.digitechbb.smsv1.model.entities.Account;
import com.digitechbb.smsv1.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);

        Account savedAccount = accountRepository.save(account);

        return accountMapper.toDTo(savedAccount);

    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findByLogin(accountDto.login()).orElseThrow(() -> new ResourceNotFoundException("Not found Account with login = " + accountDto.login()));

        Account updatedAccount = accountMapper.toEntity(accountDto);
        updatedAccount.setId(account.getId());
        return accountMapper.toDTo(accountRepository.save(updatedAccount));
    }

    @Override
    public List<AccountDto> getAll() {
//        List<Account> accountList = accountRepository.findAll();
//        List<AccountDto> accountDtoList = new ArrayList<>();
//        for (Account a: accountList) {
//            accountDtoList.add(accountMapper.toDTo(a));
//        }
        return accountRepository.findAll().stream().map(account -> accountMapper.toDTo(account)).collect(Collectors.toList());
    }

    @Override
    public AccountDto findAccountByLogin(String login) {
        Account account = accountRepository.findByLogin(login).orElseThrow(() -> new ResourceNotFoundException("Not found Account with login = " + login));
        return accountMapper.toDTo(account);
    }

    @Override
    public boolean deleteById(Long id) {
//        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Account with id = " + id));
//        if (account != null) {
//            accountRepository.deleteById(id);
//            return true;
//        } else
//            return false;
        accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Account with id = " + id));

        accountRepository.deleteById(id);
        return true;

    }

    @Override
    public boolean deleteByLogin(String login) {
//        Account account = accountRepository.findByLogin(login).get();
//        if (account != null) {
//            accountRepository.deleteById(account.getId());
//            return true;
//        } else {
//            return false;
//        }
        Account account = accountRepository.findByLogin(login).
                orElseThrow(() -> new ResourceNotFoundException("Not found Account with login " + login));

        accountRepository.deleteById(account.getId());
        return true;


    }
}
