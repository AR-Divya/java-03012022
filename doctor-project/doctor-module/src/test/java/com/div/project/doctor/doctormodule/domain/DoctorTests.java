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

    @DisplayName("checking getters and setters")
    @Test
    void testObjectGettersSetters(){
        var doc = new Doctor();

        doc.setId(10L);
        doc.setName("Deepa");
        doc.setSpecialization("cardiology");
        doc.setHosNm("AIIMS");
        doc.setHosLoc("Chennai");
        doc.setVisit(true);

        Assertions.assertEquals(10, doc.getId());
        Assertions.assertEquals("Deepa", doc.getName());
        Assertions.assertEquals("cardiology", doc.getSpecialization());
        Assertions.assertEquals("AIIMS", doc.getHosNm());
        Assertions.assertEquals("Chennai", doc.getHosLoc());
        Assertions.assertEquals(true, doc.getVisit());
    }
}
