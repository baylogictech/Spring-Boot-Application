package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.DocSpecializations;

public interface DocSpecializationsRepository extends JpaRepository<DocSpecializations, Integer> {
	DocSpecializations findByUserId(Integer userId);
}
