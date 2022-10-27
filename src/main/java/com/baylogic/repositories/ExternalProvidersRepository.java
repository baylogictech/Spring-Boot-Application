package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.ExternalProviders;

public interface ExternalProvidersRepository extends JpaRepository<ExternalProviders, Integer> {
}
