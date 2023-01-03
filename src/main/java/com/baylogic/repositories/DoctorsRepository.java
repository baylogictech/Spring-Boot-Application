package com.baylogic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.baylogic.model.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer>, DoctorsRepositoryCustom{
	
	Doctors findByUserLoginId(Long userLoginId);
	
	 @Query(nativeQuery = true, value = "Select * from doc_list_by_search(:category, :searchItems)")
	 List<Doctors> getDoctors(@Param("category") String category, @Param("searchItems") Long[] searchItems);
	 @Query(nativeQuery = true, value = "Select doc_list_by_search2(:category, :searchItem);")
	 List<Doctors> getDoctors(@Param("category") String category, @Param("searchItem") Long searchItem);
	 @Query(nativeQuery = true, value = "Select doc_list_by_search4();")
	 List<Doctors> getDoctors();
}
