package com.baylogic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.baylogic.model.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
	@Query(nativeQuery = true, value = "SELECT * from doc_list_by_search2(:searchType, :searchTypeId)")
	public List<Doctors> getDoctorsBySearch(@Param("searchType") String searchType, @Param("searchTypeId") Long searchTypeId);

}
