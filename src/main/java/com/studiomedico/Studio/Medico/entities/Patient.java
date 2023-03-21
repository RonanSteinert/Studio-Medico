package com.studiomedico.Studio.Medico.entities;

import com.studiomedico.Studio.Medico.statusEnum.StatusGender;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPatient;
    @Column(name = "gender")
    private StatusGender gender;
    @Column(name = "birthDate")
    private LocalDateTime birthDate;
    @Column(name = "birthCity")
    private String birthCity;
    @Column(name = "description")
    private String description;

    public Patient() {
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
