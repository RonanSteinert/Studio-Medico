package com.studiomedico.controllers.DTO;

import com.studiomedico.statusEnum.StatusGender;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class PatientRequestDTO extends PersonaDTO {

    private StatusGender gender;

    private LocalDateTime birthDate;

    private String birthCity;

    private String description;

    public StatusGender getGender() {
        return gender;
    }

    public void setGender(StatusGender gender) {
        this.gender = gender;
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
