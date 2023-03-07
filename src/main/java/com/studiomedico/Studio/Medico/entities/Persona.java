package com.studiomedico.Studio.Medico.entities;

import com.studiomedico.Studio.Medico.statusEnum.StatusGender;

import java.time.LocalDate;

public class Persona {
    private String name;
    private String surname;
    private String email;
    private String address;
    private String city;
    private String telephone;
    private LocalDate birthDate;
    private String description;
    private String birthCity;
    private StatusGender gender;

    public Persona() {
    }

    public Persona(String name, String surname, String email, String address, String city, String telephone, LocalDate birthDate, String description, String birthCity, StatusGender gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.description = description;
        this.birthCity = birthCity;
        this.gender = gender;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public StatusGender getGender() {
        return gender;
    }

    public void setGender(StatusGender gender) {
        this.gender = gender;
    }
}
