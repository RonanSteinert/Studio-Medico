package com.studiomedico.Studio.Medico.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.AuthProvider;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSecretary;

    private String name;
    private String surname;
    private String address;
    private String email;
    private String telephone;
}
