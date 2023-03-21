package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
@Entity
@Table

public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDoctor;


    public Doctor() {
    }

    public Doctor(long idDoctor) {
        super();
        this.idDoctor = idDoctor;
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }


}
