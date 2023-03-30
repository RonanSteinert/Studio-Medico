package com.studiomedico.controllers.DTO;

import com.studiomedico.statusEnum.StatusGender;

public class PatientRequestDTO extends PersonaDTO {
    private Integer years;
    private String description;
    private StatusGender gender;

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusGender getGender() {
        return gender;
    }

    public void setGender(StatusGender gender) {
        this.gender = gender;
    }
}
