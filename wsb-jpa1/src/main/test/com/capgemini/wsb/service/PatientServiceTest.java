package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorService doctorService;

    @Test
    @Transactional
    public void testFindVisitByPatientId() {
        //given
        //when
        List<VisitTO> visitByPatientId = patientService.findVisitById(1L);
        //then
        assertThat(visitByPatientId).isNotNull();
        assertThat(visitByPatientId.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    public void testDTOs() {
        // given
        // when
        PatientTO patient = patientService.findById(1L);
        // then
        assertThat(patient.getId()).isEqualTo(1L);
        assertThat(patient.getInsured()).isTrue();
        assertThat(patient.getFirstName()).isEqualTo("Emma");
    }

    @Test
    @Transactional
    public void testDeletePatient() {
        // given
        // when
        PatientService service = patientService;
        service.delete(1L);
        // then
        assertThat(patientDao.findOne(1L)).isNull();
        assertThat(doctorService.findById(1L)).isNotNull();
    }
}
