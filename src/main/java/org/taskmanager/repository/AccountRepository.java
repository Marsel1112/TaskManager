package org.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account getAccountByEmail(String email);
}
