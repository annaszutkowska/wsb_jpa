package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

    @Override
    public List<VisitEntity> findByPatientId(Long patientId) {
        TypedQuery<VisitEntity> query = entityManager.createQuery(
                "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId", VisitEntity.class);
        query.setParameter("patientId", patientId);
        return query.getResultList();
    }
}
