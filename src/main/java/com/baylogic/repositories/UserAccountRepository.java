package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
}
