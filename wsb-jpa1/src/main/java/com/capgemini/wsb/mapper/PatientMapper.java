package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientMapper {

    public static PatientTO mapToTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        PatientTO patientTO = new PatientTO();
        patientTO.setId(entity.getId());
        patientTO.setFirstName(entity.getFirstName());
        patientTO.setLastName(entity.getLastName());
        patientTO.setTelephoneNumber(entity.getTelephoneNumber());
        patientTO.setEmail(entity.getEmail());
        patientTO.setPatientNumber(entity.getPatientNumber());
        patientTO.setDateOfBirth(entity.getDateOfBirth());
        patientTO.setInsured(entity.isInsured());
        patientTO.setAddress(AddressMapper.mapToTO(entity.getAddress()));
        patientTO.setVisits(entity.getVisits().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()));

        return patientTO;
    }

    public static PatientEntity mapToEntity(PatientTO to) {
        if (to == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setPatientNumber(to.getPatientNumber());
        entity.setDateOfBirth(to.getDateOfBirth());
        entity.setInsured(to.isInsured());
        entity.setAddress(AddressMapper.mapToEntity(to.getAddress()));
        entity.setVisits(to.getVisits().stream().map(VisitMapper::mapToEntity).collect(Collectors.toList()));

        return entity;
    }
}
