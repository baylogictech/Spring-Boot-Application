package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
		Specialization findBySpecializationId(Integer specializationId);
}
