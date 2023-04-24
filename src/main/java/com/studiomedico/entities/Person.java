package com.studiomedico.entities;

import com.studiomedico.statusEnum.StatusRecord;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
@MappedSuperclass
public class Person {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "created_on")
    private LocalDate createdOn;
    @Column(name = "modify_on")
    private LocalDate modifyOn;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusRecord status;

    public Person() {
    }

    /*public Person(String name, String surname, String email, String address, String telephone, String createdBy, String modifiedBy, LocalDate createdOn, LocalDate modifyOn, boolean eliminated) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdOn = createdOn;
        this.modifyOn = modifyOn;
        this.eliminated = eliminated;
    }*/

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(LocalDate modifyOn) {
        this.modifyOn = modifyOn;
    }

    public StatusRecord getStatus() {
        return status;
    }

    public void setStatus(StatusRecord status) {
        this.status = status;
    }
}
