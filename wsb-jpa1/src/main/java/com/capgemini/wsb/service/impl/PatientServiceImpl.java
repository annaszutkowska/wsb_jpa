package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public List<PatientTO> findAll() {
        return patientDao.findAll().stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public PatientTO findById(Long id) {
        return PatientMapper.mapToTO(patientDao.findOne(id));
    }

    @Override
    public PatientTO save(PatientTO patient) {
        PatientEntity entity = PatientMapper.mapToEntity(patient);
        return PatientMapper.mapToTO(patientDao.save(entity));
    }

    @Override
    public void delete(Long id) {
        patientDao.delete(id);
    }
}
