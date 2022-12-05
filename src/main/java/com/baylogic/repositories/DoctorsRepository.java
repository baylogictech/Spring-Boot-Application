package com.baylogic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baylogic.model.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
}
