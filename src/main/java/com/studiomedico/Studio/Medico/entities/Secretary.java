package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
@Entity
@Table
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSecretary;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;

    public Secretary() {
    }

    public Secretary(long idSecretary, String name, String surname, String address, String email, String telephone) {
        this.idSecretary = idSecretary;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    public long getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(long idSecretary) {
        this.idSecretary = idSecretary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
