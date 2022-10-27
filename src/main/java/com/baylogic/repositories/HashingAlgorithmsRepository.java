package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.HashingAlgorithms;

public interface HashingAlgorithmsRepository extends JpaRepository<HashingAlgorithms, Integer> {
}
