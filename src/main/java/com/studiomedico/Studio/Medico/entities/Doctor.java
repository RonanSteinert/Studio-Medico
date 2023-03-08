package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
@Entity
@Table

public class Doctor extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDoctor;


    public Doctor() {
    }

    public Doctor(String name, String surname, String email, String address, String telephone, long idDoctor) {
        super ( name, surname, email, address, telephone );
        this.idDoctor = idDoctor;
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }


}
