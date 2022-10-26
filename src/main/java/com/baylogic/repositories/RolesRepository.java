package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.pojos.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
