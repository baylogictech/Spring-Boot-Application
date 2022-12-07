package com.baylogic.service;

import java.util.List;

import com.baylogic.model.Diagnosis;
import com.baylogic.model.DocSpecializations;
import com.baylogic.model.Doctors;
import com.baylogic.model.Specialization;
import com.baylogic.model.Symptoms;

public interface ProvidersService {
	public List<Symptoms> getSymptoms();
	public List<Specialization> getSpecializations();
	public List<Diagnosis> getDiagnosis();
	public boolean saveDocSpecialization(DocSpecializations docSpecializations);
	public List<Doctors> getDoctors();
}
