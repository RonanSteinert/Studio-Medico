package com.studiomedico.Studio.Medico.controllers;

import com.studiomedico.Studio.Medico.entities.Patient;
import com.studiomedico.Studio.Medico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        Patient newPatient = patientRepository.saveAndFlush(patient);
        return  newPatient;
    }
}
