package com.studiomedico.Studio.Medico.controllers;

import com.studiomedico.Studio.Medico.entities.Doctor;
import com.studiomedico.Studio.Medico.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorRepository.saveAndFlush(doctor);
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam long id){
        //doctorRepository.existsById(id);
        return doctorRepository.getById(id);
    }

}
