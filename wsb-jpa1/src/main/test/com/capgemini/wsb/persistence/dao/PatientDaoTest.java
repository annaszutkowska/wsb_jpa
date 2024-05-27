package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {
        // given
        // when
        List<PatientEntity> patientEntity = patientDao.findPatientByLastName("Davis");
        // then
        assertThat(patientEntity).isNotEmpty();
        assertThat(patientEntity.size()).isEqualTo(3);
        assertThat(patientEntity.get(0).getLastName()).isEqualTo("Davis");
    }

    @Transactional
    @Test
    public void testShouldFindPatientByMoreThanOneVisit(){
        //given
        //when
        List<PatientEntity> patientWithMoreThanXVisits = patientDao.findPatientWithMoreThanXVisits(2L);
        //then
        assertThat(patientWithMoreThanXVisits).isNotEmpty();
        assertThat(patientWithMoreThanXVisits.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void testFindInsuredPatient(){
        //given
        //when
        List<PatientEntity> insuredPatients = patientDao.findInsuredPatient();
        //then
        assertThat(insuredPatients).isNotEmpty();
        assertThat(insuredPatients.size()).isEqualTo(6);
    }
}