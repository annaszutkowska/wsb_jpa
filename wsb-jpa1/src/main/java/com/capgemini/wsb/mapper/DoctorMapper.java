package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.util.stream.Collectors;

public class DoctorMapper {

    public static DoctorTO mapToTO(DoctorEntity entity) {
        if (entity == null) {
            return null;
        }

        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(entity.getId());
        doctorTO.setFirstName(entity.getFirstName());
        doctorTO.setLastName(entity.getLastName());
        doctorTO.setTelephoneNumber(entity.getTelephoneNumber());
        doctorTO.setEmail(entity.getEmail());
        doctorTO.setDoctorNumber(entity.getDoctorNumber());
        doctorTO.setSpecialization(entity.getSpecialization());
        doctorTO.setAddress(AddressMapper.mapToTO(entity.getAddress()));
        doctorTO.setVisits(entity.getVisits().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()));

        return doctorTO;
    }

    public static DoctorEntity mapToEntity(DoctorTO to) {
        if (to == null) {
            return null;
        }

        DoctorEntity entity = new DoctorEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setDoctorNumber(to.getDoctorNumber());
        entity.setSpecialization(to.getSpecialization());
        entity.setAddress(AddressMapper.mapToEntity(to.getAddress()));
        entity.setVisits(to.getVisits().stream().map(VisitMapper::mapToEntity).collect(Collectors.toList()));

        return entity;
    }
}
