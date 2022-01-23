package com.div.project.doctor.doctormodule.service;

import com.div.project.doctor.doctormodule.domain.Doctor;
import com.div.project.doctor.doctormodule.dto.DoctorDto;
import com.div.project.doctor.doctormodule.exceptions.InvalidIdException;
import com.div.project.doctor.doctormodule.exceptions.LocalityNotFoundException;
import com.div.project.doctor.doctormodule.exceptions.NoPermanentDoctorException;
import com.div.project.doctor.doctormodule.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Override
    public DoctorDto registerDoctor(DoctorDto dto) {

        var doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setHosNm(dto.getHosNm());
        doctor.setHosLoc(dto.getHosLoc());
        doctor.setVisit(dto.getVisit());
        repository.save(doctor);
        return dto;
    }

    @Override
    public DoctorDto updateDocInfo(DoctorDto dto) throws InvalidIdException {
        Doctor doctor = repository.findById(dto.getId()).orElseThrow(() -> new InvalidIdException("Enter valid Id"));
        var doctor1 = new Doctor();
        doctor1.setId(dto.getId());
        doctor1.setName(dto.getName());
        doctor1.setSpecialization(dto.getSpecialization());
        doctor1.setHosNm(dto.getHosNm());
        doctor1.setHosLoc(dto.getHosLoc());
        doctor1.setVisit(dto.getVisit());
        repository.save(doctor1);
        return dto;
    }

    @Override
    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DoctorDto> findByLocality(String hosLoc) {
        List<Doctor> doctors = repository.findAll();
        List<DoctorDto> dtos = doctors.stream().filter(n -> n.getHosLoc().equals(hosLoc))
                .map(doc -> new DoctorDto(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpecialization(),
                        doc.getHosNm(),
                        doc.getHosLoc(),
                        doc.getVisit()
                )).collect(Collectors.toList());
        if (dtos.isEmpty()) {
            throw new LocalityNotFoundException("Doctor not found for given Locality");
        } else {
            return dtos;
        }
    }

    @Override
    public List<DoctorDto> permanentDoctorForGivenSpecialization(String specialization) {
        List<Doctor> doctors1 = repository.findAll();
        List<DoctorDto> dtos1 = doctors1.stream().filter(p -> p.getVisit() == false && p.getSpecialization().equals(specialization))
                .map(doc1 -> new DoctorDto(
                        doc1.getId(),
                        doc1.getName(),
                        doc1.getSpecialization(),
                        doc1.getHosNm(),
                        doc1.getHosLoc(),
                        doc1.getVisit()
                )).collect(Collectors.toList());
        if (dtos1.isEmpty()) {
            throw new NoPermanentDoctorException("Permanent Doctor not found for given specialization");
        } else {
            return dtos1;
        }
    }
}
