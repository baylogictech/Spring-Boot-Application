package com.baylogic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.baylogic.model.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
	//@Procedure(procedureName = "doc_list_by_search")
//    List<Doctors> getDoctorsBySearch(String category, Long[] searchItems);
	
	@Query(nativeQuery = true, value = "SELECT doc_list_by_search(:category, :searchItems)")
	List<Doctors> getDoctorsBySearch(@Param("category") String category, @Param("searchItems") Integer[] searchItems);

}
