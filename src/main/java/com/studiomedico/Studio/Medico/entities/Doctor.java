package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
@Entity
@Table

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDoctor;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;

    public Doctor() {
    }

    public Doctor(long idDoctor, String name, String surname, String city, String address) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.address = address;
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
