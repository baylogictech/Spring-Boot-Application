package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.UserLoginDataExternal;

public interface UserLoginDataExternalRepository extends JpaRepository<UserLoginDataExternal, Integer> {
}
