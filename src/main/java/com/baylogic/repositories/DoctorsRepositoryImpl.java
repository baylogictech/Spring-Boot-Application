package com.baylogic.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.baylogic.model.Doctors;

public class DoctorsRepositoryImpl implements DoctorsRepositoryCustom{
    @PersistenceContext
    private EntityManager em;

	@Override
	public List<Doctors> getDoctorList(String category, Long searchItem) {
		StoredProcedureQuery findByProcedure =
	              em.createNamedStoredProcedureQuery("getDoctors").setParameter("search_type", category).setParameter("search_type_id", searchItem);
	        return findByProcedure.getResultList();
	}


}
