package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {
    public static VisitTO mapToTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        VisitTO visitTO = new VisitTO();
        visitTO.setId(entity.getId());
        visitTO.setDescription(entity.getDescription());
        visitTO.setTime(entity.getTime());
        visitTO.setDoctor(DoctorMapper.mapToTO(entity.getDoctor()));
        visitTO.setPatient(PatientMapper.mapToTO(entity.getPatient()));

        return visitTO;
    }

    public static VisitEntity mapToEntity(VisitTO to) {
        if (to == null) {
            return null;
        }

        VisitEntity entity = new VisitEntity();
        entity.setId(to.getId());
        entity.setDescription(to.getDescription());
        entity.setTime(to.getTime());
        entity.setDoctor(DoctorMapper.mapToEntity(to.getDoctor()));
        entity.setPatient(PatientMapper.mapToEntity(to.getPatient()));

        return entity;
    }
}
