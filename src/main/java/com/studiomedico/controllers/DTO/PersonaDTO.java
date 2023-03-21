package com.studiomedico.controllers.DTO;

public class PersonaDTO {
    private String name;
    private String surname;
    private String email;
    private String address;
    private String telephone;
    private String fiscalCode;

    public PersonaDTO() {
    }

    public PersonaDTO(String name, String surname, String email, String address, String telephone, String fiscalCode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.fiscalCode = fiscalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}
