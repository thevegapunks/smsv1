package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByLogin(String login);

}
