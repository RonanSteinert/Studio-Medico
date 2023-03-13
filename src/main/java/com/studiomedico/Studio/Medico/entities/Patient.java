package com.studiomedico.Studio.Medico.entities;

import com.studiomedico.Studio.Medico.statusEnum.StatusGender;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Patient extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPatient;
    @Column(name = "gender")
    private StatusGender gender;
    @Column(name = "birthDate")
    private LocalDateTime birthDate;
    @Column(name = "birthCity")
    private String birthCity;
    @Column(name = "description")
    private String description;

    public Patient() {
    }

    public Patient(String name, String surname, String email, String address, String telephone, long idPatient, StatusGender gender, LocalDateTime birthDate, String birthCity, String description) {
        super ( name, surname, email, address, telephone );
        this.idPatient = idPatient;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
