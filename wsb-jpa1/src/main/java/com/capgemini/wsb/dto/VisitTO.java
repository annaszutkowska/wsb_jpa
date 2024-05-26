package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitTO implements Serializable {

    private Long id;

    private String description;

    private LocalDateTime time;

    private PatientTO patient;

    private DoctorTO doctor;
}
