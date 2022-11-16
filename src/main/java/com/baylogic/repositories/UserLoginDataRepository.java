package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.UserLoginData;

public interface UserLoginDataRepository extends JpaRepository<UserLoginData, Integer> {
	UserLoginData findByUsername(String userName);
	UserLoginData findByPasswordRecoveryToken(String passwordRecoveryToken);
}
