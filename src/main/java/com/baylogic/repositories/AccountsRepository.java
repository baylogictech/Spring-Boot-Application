package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.pojos.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
}
