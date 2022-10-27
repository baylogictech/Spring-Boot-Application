package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.EmailValidationStatus;

public interface EmailValidationStatusRepository extends JpaRepository<EmailValidationStatus, Integer> {
}
