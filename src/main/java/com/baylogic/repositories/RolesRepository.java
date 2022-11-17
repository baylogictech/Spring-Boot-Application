package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
	Roles findByRoleDescription(String roleDescription);
}
