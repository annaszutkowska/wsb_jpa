package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    List<PatientTO> findAll();

    PatientTO findById(Long id);

    PatientTO save(PatientTO patient);

    void delete(Long id);

    List<VisitTO> findVisitById(Long patientId);
}
