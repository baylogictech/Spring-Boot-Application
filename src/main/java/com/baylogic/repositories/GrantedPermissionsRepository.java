package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.GrantedPermissions;

public interface GrantedPermissionsRepository extends JpaRepository<GrantedPermissions, Integer> {
}
