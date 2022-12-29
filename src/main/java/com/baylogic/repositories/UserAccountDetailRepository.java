package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.UserAccountDetail;

public interface UserAccountDetailRepository extends JpaRepository<UserAccountDetail, Integer> {
	UserAccountDetail findByUserId(Long userId);
}
