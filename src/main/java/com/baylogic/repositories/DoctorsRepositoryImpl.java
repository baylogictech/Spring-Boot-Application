/*
 * package com.baylogic.repositories;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import
 * javax.persistence.StoredProcedureQuery;
 * 
 * import com.baylogic.model.Doctors;
 * 
 * public class DoctorsRepositoryImpl implements DoctorsRepositoryCustom{
 * 
 * @PersistenceContext private EntityManager em;
 * 
 * @Override public List<Doctors> getDoctorList(String category, Integer
 * searchItem) { StoredProcedureQuery findByProcedure =
 * em.createNamedStoredProcedureQuery("getDoctors");
 * findByProcedure.setParameter("search_type", category);
 * findByProcedure.setParameter("search_type_id", searchItem);
 * findByProcedure.execute(); return findByProcedure.getResultList(); }
 * 
 * 
 * }
 */