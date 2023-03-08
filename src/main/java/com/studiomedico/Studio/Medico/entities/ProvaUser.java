package com.studiomedico.Studio.Medico.entities;

import com.studiomedico.Studio.Medico.statusEnum.StatusGender;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDate;

@Entity
@Table
public class ProvaUser extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public ProvaUser(String name, String surname, String email, String address, String telephone, long id) {
        super(name, surname, email, address, telephone);
        this.id = id;
    }

}
