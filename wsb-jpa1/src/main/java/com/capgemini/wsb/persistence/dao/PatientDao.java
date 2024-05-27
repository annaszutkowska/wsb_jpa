package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    public List<VisitEntity> findVisitsById(Long id);

    List<PatientEntity> findPatientByLastName(String lastName);

    List<PatientEntity> findPatientWithMoreThanXVisits(Long numOfVisits);

    List<PatientEntity> findInsuredPatient();
}
