package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
}
