package com.baylogic.service;

import java.sql.Types;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baylogic.db.PGArrayGeneric;
import com.baylogic.model.Diagnosis;
import com.baylogic.model.DocSpecializations;
import com.baylogic.model.Doctors;
import com.baylogic.model.Specialization;
import com.baylogic.model.Symptoms;
import com.baylogic.repositories.DiagnosisRepository;
import com.baylogic.repositories.DocSpecializationsRepository;
import com.baylogic.repositories.DoctorsRepository;
import com.baylogic.repositories.JdbcDoctorsRepository;
import com.baylogic.repositories.SpecializationRepository;
import com.baylogic.repositories.SymptomsRepository;

@Service
public class ProvidersServiceImpl implements ProvidersService {
	@Autowired
	private SymptomsRepository symptomsRepo;
	@Autowired
	private SpecializationRepository specializationRepo;
	@Autowired
	private DiagnosisRepository diagnosisRepo;
	@Autowired
	private DocSpecializationsRepository docSpecRepo;
	@Autowired
	private DoctorsRepository doctorsRepo;
	@Autowired
	private JdbcDoctorsRepository jdbcDoctorRepo;

	@Override
	public List<Symptoms> getSymptoms() {
		// TODO Auto-generated method stub
		return symptomsRepo.findAll();
	}

	@Override
	public List<Specialization> getSpecializations() {
		// TODO Auto-generated method stub
		return specializationRepo.findAll();
	}

	@Override
	public List<Diagnosis> getDiagnosis() {
		// TODO Auto-generated method stub
		return diagnosisRepo.findAll();
	}
	
	@Override
	public List<Doctors> getDoctors() {
		// TODO Auto-generated method stub
		//List<DocSpecializations> docSpecializations = docSpecRepo.findAll(); 
		List<Doctors> doctorsList = doctorsRepo.findAll();		
		/*for(Doctors doctor : doctorsList) {
			DocSpecializations docSpecialization = docSpecRepo.findByUserId(doctor.getUserLoginId());
			doctor.setSpecializationType(docSpecialization.getSpecializationType());
		}*/
		return doctorsList;
	}

	@Override
	public boolean saveDocSpecialization(DocSpecializations docSpecializations) {
		try {
			docSpecRepo.save(docSpecializations);
		}catch (Exception e) {
			return false;
		}
		return true;		
	}

	@Override
	public List<Doctors> searchDoctors(String searchType, List<Long> searchTypeIds) {
		PGArrayGeneric st = new PGArrayGeneric();
		st.setArray(Types.BIGINT, searchTypeIds.toArray());
		return jdbcDoctorRepo.getDoctorsBySearch(searchType, st);
	}

	@Override
	public List<Doctors> getDoctors(String searchType, Long searchTypeId) {
		return jdbcDoctorRepo.getDoctorsBySearch2(searchType, searchTypeId);
	}

	@Override
	public List<Doctors> searchDoctors(String searchType, Integer searchTypeId) {
		// TODO Auto-generated method stub
		return jdbcDoctorRepo.getDoctorsBySearch(searchType, searchTypeId);
	}

}

	