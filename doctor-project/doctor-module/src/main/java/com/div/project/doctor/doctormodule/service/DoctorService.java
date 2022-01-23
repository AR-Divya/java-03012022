package com.div.project.doctor.doctormodule.service;

import com.div.project.doctor.doctormodule.dto.DoctorDto;
import com.div.project.doctor.doctormodule.exceptions.InvalidIdException;
import java.util.List;

public interface DoctorService {

    public DoctorDto registerDoctor(DoctorDto dto);

    DoctorDto updateDocInfo(DoctorDto dto) throws InvalidIdException;

    public void deleteDoctor(Long id);

    List<DoctorDto> findByLocality(String hosLoc);

    List<DoctorDto> permanentDoctorForGivenSpecialization(String specialization);
}
