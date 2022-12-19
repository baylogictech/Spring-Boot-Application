package com.baylogic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.Doc;

import org.springframework.jdbc.core.RowMapper;

import com.baylogic.model.Doctors;

public class DoctorsMapper implements RowMapper<Doctors>{
	@Override
    public Doctors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctors doctor = new Doctors();
		doctor.setDoctorId(rs.getInt("doctor_id"));
		doctor.setFirstName(rs.getString("first_name"));	
		doctor.setLastName(rs.getString("last_name"));
		doctor.setProfessionalStatement(rs.getString("professional_statement"));
		doctor.setPracticingFrom(rs.getDate("practicing_from"));
		doctor.setConsultationFee(rs.getInt("consultation_fee"));
		doctor.setAge(rs.getInt("age"));
		doctor.setLanguages(rs.getString("languages"));
		doctor.setQualification(rs.getString("qualification"));
		doctor.setState(rs.getString("state"));
		doctor.setCity(rs.getString("city"));
		doctor.setGender(rs.getString("gender"));
		doctor.setUserLoginId(rs.getInt("user_login_id"));
        return doctor;
    }
	
}
