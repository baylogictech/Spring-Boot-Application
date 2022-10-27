package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.Permissions;

public interface PermissionsRepository extends JpaRepository<Permissions, Integer> {
}
