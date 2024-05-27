package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<VisitEntity> findVisitsById(Long id) {
        String hql = "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId";
        TypedQuery<VisitEntity> query = entityManager.createQuery(hql, VisitEntity.class);
        query.setParameter("patientId", id);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientByLastName(String lastName) {
        String hql = "FROM PatientEntity p WHERE p.lastName = :lastName";
        TypedQuery<PatientEntity> query = entityManager.createQuery(hql, PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientWithMoreThanXVisits(Long numOfVisits) {
        String hql = "SELECT p FROM PatientEntity p " +
                "JOIN VisitEntity v ON p.id = v.patient.id " +
                "GROUP BY p.id " +
                "HAVING COUNT(v.id) > :visitCount";
        TypedQuery<PatientEntity> query = entityManager.createQuery(hql, PatientEntity.class);
        query.setParameter("visitCount", numOfVisits);
        return query. getResultList();
    }

    @Override
    public List<PatientEntity> findInsuredPatient() {
        String jpql = "SELECT p FROM PatientEntity p WHERE p.isInsured = TRUE";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        return query.getResultList();
    }
}
