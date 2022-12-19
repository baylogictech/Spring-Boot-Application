package com.baylogic.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.baylogic.db.PGArrayGeneric;
import com.baylogic.mapper.DoctorsMapper;
import com.baylogic.model.Doctors;

@Repository
public class JdbcDoctorsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Doctors> getDoctorsBySearch(String searchType,  PGArrayGeneric searchTypeIds) {
		List<Doctors> doctors = null;		
		doctors = jdbcTemplate.query("SELECT * from doc_list_by_search2(?,?)", new DoctorsMapper(), new Object[] {searchType, searchTypeIds}); 
		return doctors;
	}
	
	public List<Doctors> getDoctorsBySearch(String searchType,  Integer searchTypeId) {
		List<Doctors> doctors = null;		
		doctors = jdbcTemplate.query("SELECT * from doc_list_by_search2(?,?)", new DoctorsMapper(), new Object[] {searchType, searchTypeId});  //"+searchType+","+searchTypeId+"
		return doctors;
	}
	
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

}
