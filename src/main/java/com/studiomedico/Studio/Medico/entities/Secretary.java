package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
@Entity
@Table
public class Secretary extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSecretary;


    public Secretary() {
    }

    public Secretary(String name, String surname, String email, String address, String telephone, long idSecretary) {
        super ( name, surname, email, address, telephone );
        this.idSecretary = idSecretary;
    }

    public long getIdSecretary() {
        return idSecretary;
    }

    public void setIdSecretary(long idSecretary) {
        this.idSecretary = idSecretary;
    }

}
