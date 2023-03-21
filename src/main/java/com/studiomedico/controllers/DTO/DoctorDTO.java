package com.studiomedico.controllers.DTO;

public class DoctorDTO extends PersonaDTO {
    private String specialization;

    public DoctorDTO() {
    }

    public DoctorDTO(String name, String surname, String email, String address, String telephone, String fiscalCode, String specialization) {
        super(name, surname, email, address, telephone, fiscalCode);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
