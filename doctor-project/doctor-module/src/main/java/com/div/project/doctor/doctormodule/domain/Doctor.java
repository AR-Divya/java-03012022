package com.div.project.doctor.doctormodule.domain;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column (unique = true, nullable = false)
    private String name;

    @NotNull
    @Column (unique = false, nullable = false)
    private String specialization;

    @Column (unique = false, nullable = true)
    private String hosNm;

    @NotNull
    @Column (unique = false, nullable = false)
    private String hosLoc;

    @NotNull
    @Column (unique = false, nullable = false)
    private Boolean visit;
}
