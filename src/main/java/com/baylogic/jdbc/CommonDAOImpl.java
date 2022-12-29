package com.baylogic.jdbc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.baylogic.db.PGArrayGeneric;
import com.baylogic.mapper.DocSpecializationsMapper;
import com.baylogic.mapper.DoctorsMapper;
import com.baylogic.model.DocSpecializations;
import com.baylogic.model.Doctors;
import com.baylogic.util.WebKeys;

@Repository
public class CommonDAOImpl implements CommonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CommonDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Doctors> getDoctorsBySearch(String searchType,  PGArrayGeneric searchTypeIds) {
		List<Doctors> doctors = null;		
		doctors = jdbcTemplate.query("SELECT * from doc_list_by_search(?,?)", new DoctorsMapper(), new Object[] {searchType, searchTypeIds}); 
		return doctors;
	}
	
	@Override
	public List<Doctors> getDoctorsBySearch(String searchType,  Integer searchTypeId) {
		List<Doctors> doctors = null;		
		doctors = jdbcTemplate.query("SELECT * from doc_list_by_search2(?,?)", new DoctorsMapper(), searchType, searchTypeId);  //"+searchType+","+searchTypeId+"
		doctors.forEach(doctor -> System.out.println("doctor id"+doctor.getDoctorId()));
		return doctors;
	}
	
	@Override
	public List<Doctors> getDoctorsBySearch2(String searchType,  Long searchTypeId) {
	    List<Doctors> doctors = new ArrayList<Doctors>();		
	    doctors = this.jdbcTemplate.query(
	    	    "SELECT DISTINCT doc.* FROM public.doctors doc, "
	    	    + "public.doc_specializations doc_spec "
	    	    + "WHERE doc.user_login_id = doc_spec.user_id "
	    	    + "AND lower(doc_spec.specialization_type) = lower("+searchType+") "
	    	    + "AND specialization_type_id = "+searchTypeId+";",
	    	    new DoctorsMapper());
	    return doctors;
	}

	@Override
	public List<DocSpecializations> getDoctorSpecializations(Long userLoginId) {
		List<DocSpecializations> docSpecializations = Collections.emptyList();
		docSpecializations = this.jdbcTemplate.query("select * from doc_specializations where user_id=? and specialization_type=?" , new DocSpecializationsMapper(), userLoginId, WebKeys.SPECIALIZATION_TYPE );
		return docSpecializations;
	}
		
	
	
}
