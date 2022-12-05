package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.Symptoms;

public interface SymptomsRepository extends JpaRepository<Symptoms, Integer> {
}
