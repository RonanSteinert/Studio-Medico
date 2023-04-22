package com.studiomedico.entities;

import com.studiomedico.statusEnum.StatusGender;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long idPatient;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private StatusGender gender;
    @Column(name = "birthDate")
    private LocalDateTime birthDate;
    @Column(name = "birthCity")
    private String birthCity;
    /*@ManyToOne
    @JoinColumn
    private Secretary secretary;*/

    public Patient() {
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public StatusGender getGender() {
        return gender;
    }

    public void setGender(StatusGender gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    /*public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }*/
}
