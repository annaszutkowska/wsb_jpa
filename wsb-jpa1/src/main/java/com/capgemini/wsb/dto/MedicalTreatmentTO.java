package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;


public class MedicalTreatmentTO implements Serializable {

    private Long id;

    private String description;

    private TreatmentType type;

    private VisitTO visit;
}
