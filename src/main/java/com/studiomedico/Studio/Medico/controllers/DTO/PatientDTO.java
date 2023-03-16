package com.studiomedico.Studio.Medico.controllers.DTO;

import com.studiomedico.Studio.Medico.statusEnum.StatusGender;

public class PatientDTO extends PersonaDTO {
    private Integer years;
    private String description;
    private StatusGender gender;

    public PatientDTO() {
    }

    public PatientDTO(String name, String surname, String email, String address, String telephone, String fiscalCode, Integer years, String description, StatusGender gender) {
        super(name, surname, email, address, telephone, fiscalCode);
        this.years = years;
        this.description = description;
        this.gender = gender;
    }

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
