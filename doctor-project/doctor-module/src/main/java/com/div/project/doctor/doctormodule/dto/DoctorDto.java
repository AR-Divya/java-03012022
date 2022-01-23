package com.div.project.doctor.doctormodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Setter
@Getter
public class DoctorDto {

    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private String specialization;

    private String hosNm;

    @NotNull
    private String hosLoc;

    @NotNull
    private Boolean visit;
}
