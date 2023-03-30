package com.studiomedico.controllers.DTO;


public class DoctorRequestDTO extends PersonaDTO {
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }


    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
