package com.studiomedico.controllers;

import com.studiomedico.entities.Patient;
import com.studiomedico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/newpatient")
    public Patient addPatient(@RequestBody Patient patient){
       return patientRepository.saveAndFlush(patient);
    }
    @GetMapping("/get/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id);
    }
    @GetMapping("/getall")
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
}
