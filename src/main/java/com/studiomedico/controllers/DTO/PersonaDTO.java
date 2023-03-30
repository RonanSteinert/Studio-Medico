package com.studiomedico.controllers.DTO;

import com.studiomedico.statusEnum.StatusRecord;

public class PersonaDTO {

    private StatusRecord statusRecord = StatusRecord.Active;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String telephone;
    private String fiscalCode;

    public StatusRecord getStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(StatusRecord statusRecord) {
        this.statusRecord = statusRecord;
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
