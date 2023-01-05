package com.baylogic.service;

import java.sql.Array;
import java.sql.Types;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baylogic.db.PGArrayGeneric;
import com.baylogic.jdbc.CommonDAO;
import com.baylogic.model.Diagnosis;
import com.baylogic.model.DocSpecializations;
import com.baylogic.model.Doctors;
import com.baylogic.model.Specialization;
import com.baylogic.model.Symptoms;
import com.baylogic.repositories.DiagnosisRepository;
import com.baylogic.repositories.DocSpecializationsRepository;
import com.baylogic.repositories.DoctorsRepository;
import com.baylogic.repositories.SpecializationRepository;
import com.baylogic.repositories.SymptomsRepository;

@Service("productService")
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
	private CommonDAO commonDAO;
	

	   @Autowired
	   @PersistenceContext
	   private EntityManager em;

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
	//	List<DocSpecializations> docSpecializations = docSpecRepo.findAll(); 
		List<Doctors> doctorsList = doctorsRepo.findAll();		
		int index = 0;
		for(Doctors doctor : doctorsList) {
			List<DocSpecializations> docSpecializations = commonDAO.getDoctorSpecializations(doctor.getUserLoginId());			
			for(DocSpecializations docSpe : docSpecializations) {
				//if(docSpe.getSpecializationType().equalsIgnoreCase(WebKeys.SPECIALIZATION_TYPE)) {
					Specialization specialization = specializationRepo.findBySpecializationId(docSpe.getSpecializationTypeId());
					if(specialization != null) {	
						doctor.setSpecializationType(specialization.getSpecializationName());
					}
				//}
			}
			doctorsList.set(index,doctor);
			index++;
		}
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
	public List<Doctors> getDoctors(String searchType, Long[] searchTypeIds) {
		PGArrayGeneric st = new PGArrayGeneric();	
	  	st.setArray(Types.BIGINT, searchTypeIds);
	  	long[] test = {1,2};
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("getDoctors");
	    spq.registerStoredProcedureParameter("PARAM1", String.class, ParameterMode.IN);
	    spq.registerStoredProcedureParameter("PARAM2", long[].class, ParameterMode.IN);
	    return spq.setParameter("PARAM1", searchType).setParameter("PARAM2", st).getResultList();
	}

	@Override
	public List<Doctors> getDoctors(String searchType, Integer searchTypeId) {
		StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("getDoctors2");
	    spq.registerStoredProcedureParameter("PARAM1", String.class, ParameterMode.IN);
	    spq.registerStoredProcedureParameter("PARAM2", Integer.class, ParameterMode.IN);
	    return spq.setParameter("PARAM1", searchType).setParameter("PARAM2", searchTypeId.intValue()).getResultList();
	}

}

	