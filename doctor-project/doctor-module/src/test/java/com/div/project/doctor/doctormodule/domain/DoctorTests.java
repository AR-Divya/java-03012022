package com.div.project.doctor.doctormodule.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoctorTests {

    @DisplayName("Checking Object creation")
    @Test
    void testObjectCreation(){
        var doctor = new Doctor();
        Assertions.assertNotNull(doctor);
    }
}
