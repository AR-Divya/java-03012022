package com.div.project.doctor.doctormodule.controller;


import com.div.project.doctor.doctormodule.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @DisplayName("Post - Testing register Doctor")
    @Test
    public void testPostMethod(){
        String url = "http://"+"localhost"+":"+port+"/doctor";
        var doctor = new Doctor();
        doctor.setId(10L);
        doctor.setName("Jasmine");
        doctor.setSpecialization("cardiology");
        doctor.setHosNm("AIIMS");
        doctor.setHosLoc("Chennai");
        doctor.setVisit(true);

        var re =template.postForEntity(url,doctor,Doctor.class);
        Assertions.assertEquals(HttpStatus.OK,re.getStatusCode());
    }


    @DisplayName("Get - Checking Object is not null")
    @Test
    public void testGetMethod(){

        String url = "http://"+"localhost"+":"+port+"/doctor";

        Doctor doctor = template.getForObject(url,Doctor.class);

        Assertions.assertNotNull(doctor);
    }

    @DisplayName("Delete - Deleting doctor")
    @Test
    public void testDeleteMethod(){
        String url = "http://" + "localhost"+":"+port+"/doctor";
        template.delete(url);
    }
}
