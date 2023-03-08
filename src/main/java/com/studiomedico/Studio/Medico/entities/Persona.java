package com.studiomedico.Studio.Medico.entities;

import com.studiomedico.Studio.Medico.statusEnum.StatusGender;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
@MappedSuperclass
public class Persona {

    private String name;

    private String surname;

    private String email;

    private String address;

    private String telephone;

    public Persona() {
    }

    public Persona(String name, String surname, String email, String address, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
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
}
