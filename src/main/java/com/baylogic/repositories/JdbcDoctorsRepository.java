package com.baylogic.repositories;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.baylogic.db.PGArrayGeneric;
import com.baylogic.model.Doctors;

@Repository
public class JdbcDoctorsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Doctors> getDoctorsBySearch(String category,  PGArrayGeneric searchItems) {
		List<Doctors> doctors = null;		
		SqlRowSet rows = jdbcTemplate.queryForRowSet("SELECT * from doc_list_by_search(?,?)", category, searchItems); 
		while(rows.next()) {
			Doctors doctor = new Doctors();
			doctor.setDoctorId(rows.getInt(0));
			doctors.add(doctor);
		}

		return doctors;
	}
	
	public List<Doctors> getDoctorsBySearch2(String searchType,  Long searchTypeId) {
		List<Doctors> doctors = null;		
		SqlRowSet rows = jdbcTemplate.queryForRowSet("SELECT * from doc_list_by_search2(?,?)", searchType, searchTypeId); 
		while(rows.next()) {
			Doctors doctor = new Doctors();
			doctor.setDoctorId(rows.getInt(0));
			doctors.add(doctor);
		}

		return doctors;
	}

}
