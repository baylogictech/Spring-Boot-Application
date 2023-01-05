package com.baylogic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.baylogic.model.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {// , DoctorsRepositoryCustom{
	
	Doctors findByUserLoginId(Long userLoginId);
}
