package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.AccountDto;
import com.digitechbb.smsv1.model.entities.Account;

public interface AccountMapper {
    AccountDto toDTo(Account account);
    Account toEntity(AccountDto accountDto);
}
