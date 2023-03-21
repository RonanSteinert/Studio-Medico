package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
@Entity
@Table
public class Secretary extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSecretary;


    public Secretary() {
    }


    public long getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(long idSecretary) {
        this.idSecretary = idSecretary;
    }

}
