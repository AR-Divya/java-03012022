package com.div.project.doctor.doctormodule.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoctorServiceTests {

    @Autowired
    private DoctorServiceImpl service;

    @DisplayName("Finding permanent Doctor by specialization")
    @Test
    public void testDoctorFindBySpec(){
        var op = service.permanentDoctorForGivenSpecialization("neurology");
        Assertions.assertNotNull(op.get(1));
    }

    @DisplayName("Finding Doctor by locality")
    @Test
    public void testDoctorFindByloc(){
        var op = service.findByLocality("Chennai");
        Assertions.assertNotNull(op.get(1));
    }
}
