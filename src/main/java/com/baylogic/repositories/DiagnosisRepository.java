package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
}
