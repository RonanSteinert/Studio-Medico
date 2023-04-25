package com.studiomedico.entities;

import jakarta.persistence.*;
@Entity
@Table

public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_doctor")
    private Long idDoctor;


    public Doctor() {
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }

}
