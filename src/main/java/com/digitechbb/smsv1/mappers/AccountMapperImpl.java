package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.AccountDto;
import com.digitechbb.smsv1.model.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto toDTo(Account account) {
        if (account == null) {
            return null;
        }

        return new AccountDto(
                account.getLogin(),
                account.getPassword(),
                account.getActivated(),
                account.getStatut()
        );
    }

    @Override
    public Account toEntity(AccountDto accountDto) {
        if (accountDto == null) return null;
        Account account = new Account();
        account.setLogin(accountDto.login());
        account.setPassword(accountDto.password());
        account.setActivated(accountDto.activated());
        account.setStatut(accountDto.statut());

        return account;
    }
}
