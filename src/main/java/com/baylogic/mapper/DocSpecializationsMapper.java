package com.baylogic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.Doc;

import org.springframework.jdbc.core.RowMapper;

import com.baylogic.model.DocSpecializations;
import com.baylogic.model.Doctors;

public class DocSpecializationsMapper implements RowMapper<DocSpecializations>{
	@Override
    public DocSpecializations mapRow(ResultSet rs, int rowNum) throws SQLException {
		DocSpecializations docSpecializations = new DocSpecializations();
		docSpecializations.setUserId(rs.getInt("user_id"));
		docSpecializations.setSpecializationType(rs.getString("specialization_type"));
		docSpecializations.setSpecializationTypeId(rs.getInt("specialization_type_id"));
        return docSpecializations;
    }
	
}
