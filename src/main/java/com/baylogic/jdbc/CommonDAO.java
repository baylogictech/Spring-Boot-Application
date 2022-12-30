package com.baylogic.jdbc;

import java.util.List;

import com.baylogic.db.PGArrayGeneric;
import com.baylogic.model.DocSpecializations;
import com.baylogic.model.Doctors;

public interface CommonDAO {
	public List<Doctors> getDoctors(String searchType,  Long[] searchTypeIds);
	public List<Doctors> getDoctors(String searchType,  Long searchTypeId);
	//public List<Doctors> getDoctorsBySearch2(String searchType,  Long searchTypeId);
	public List<DocSpecializations> getDoctorSpecializations(Long userLoginId);

}
