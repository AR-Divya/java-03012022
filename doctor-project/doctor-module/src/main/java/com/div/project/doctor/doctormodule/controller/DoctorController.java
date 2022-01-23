package com.div.project.doctor.doctormodule.controller;

import com.div.project.doctor.doctormodule.dto.AppResponse;
import com.div.project.doctor.doctormodule.dto.DoctorDto;
import com.div.project.doctor.doctormodule.exceptions.InvalidIdException;
import com.div.project.doctor.doctormodule.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public ResponseEntity<AppResponse<DoctorDto>> registerDoctor(@Valid @RequestBody DoctorDto dto) {

        var svObj = service.registerDoctor(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor registered successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<DoctorDto>> updateDocInfo(@RequestBody DoctorDto dto) {
        var svObj = service.updateDocInfo(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor info updated successfully");
        response.setBody(svObj);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<DoctorDto>> deleteDoctor(@PathVariable("id") Long id) {
        service.deleteDoctor(id);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Deleted doctor successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{hosLoc}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findByLocality(@PathVariable String hosLoc) {
        var svObj = service.findByLocality(hosLoc);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("List of Doctors for given Locality");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/per/{specialization}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> permanentDoctorForGivenSpecialization(@PathVariable String specialization) {
        var svObj = service.permanentDoctorForGivenSpecialization(specialization);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Permanent Doctors for given specialization");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for (ObjectError oe : errors) {
            FieldError fe = (FieldError) oe;
            String errorField = fe.getField();
            String errorMessage = fe.getDefaultMessage();
            messages.put(errorField, errorMessage);
        }
        return messages;
    }
}
