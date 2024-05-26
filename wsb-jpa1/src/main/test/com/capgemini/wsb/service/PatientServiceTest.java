package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadeVisits() {
        PatientEntity patient = patientDao.findOne(1L);
        List<VisitEntity> visits = visitDao.findByPatientId(1L);
        List<DoctorEntity> doctorsBeforeDelete = doctorDao.findAll();

        patientService.delete(1L);

        PatientEntity deletedPatient = patientDao.findOne(1L);
        List<VisitEntity> deletedVisits = visitDao.findByPatientId(1L);
        List<DoctorEntity> doctorsAfterDelete = doctorDao.findAll();

        assertThat(deletedPatient).isNull();
        assertThat(deletedVisits).isEmpty();
        assertThat(doctorsAfterDelete).containsAll(doctorsBeforeDelete);
    }

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        PatientTO patientTO = new PatientTO();
        patientTO.setFirstName("John");
        patientTO.setLastName("Doe");
        patientTO.setTelephoneNumber("123456789");
        patientTO.setEmail("john.doe@example.com");
        patientTO.setPatientNumber("P123");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setInsured(true);

        PatientTO savedPatient = patientService.save(patientTO);

        PatientTO foundPatient = patientService.findById(savedPatient.getId());

        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getFirstName()).isEqualTo("John");
        assertThat(foundPatient.getLastName()).isEqualTo("Doe");
        assertThat(foundPatient.getTelephoneNumber()).isEqualTo("123456789");
        assertThat(foundPatient.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(foundPatient.getPatientNumber()).isEqualTo("P123");
        assertThat(foundPatient.getDateOfBirth()).isEqualTo(LocalDate.of(1990, 1, 1));
        assertThat(foundPatient.isInsured()).isTrue();
    }
}
