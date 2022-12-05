package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.UserAccountDetail;

public interface UserAccountRepository extends JpaRepository<UserAccountDetail, Integer> {
}
