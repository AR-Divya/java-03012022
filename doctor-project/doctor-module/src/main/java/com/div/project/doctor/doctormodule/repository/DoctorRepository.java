package com.div.project.doctor.doctormodule.repository;

import com.div.project.doctor.doctormodule.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
