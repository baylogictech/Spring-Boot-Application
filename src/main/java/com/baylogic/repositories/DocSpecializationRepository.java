package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.DocSpecialization;

public interface DocSpecializationRepository extends JpaRepository<DocSpecialization, Integer> {
}
