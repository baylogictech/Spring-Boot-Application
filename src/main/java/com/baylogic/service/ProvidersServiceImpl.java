package com.baylogic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baylogic.model.Diagnosis;
import com.baylogic.model.Specialization;
import com.baylogic.model.Symptoms;
import com.baylogic.repositories.DiagnosisRepository;
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

}
