package com.studiomedico.Studio.Medico.controllers;

import com.studiomedico.Studio.Medico.entities.Doctor;
import com.studiomedico.Studio.Medico.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor){

        return doctorRepository.saveAndFlush(doctor);
    }

    @GetMapping("")
    public Optional<Doctor> getDoctor(@RequestParam Long id){
        //doctorRepository.existsById(id);
        return doctorRepository.findById(id);
    }
    @GetMapping("/get/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }
    /*
    @PutMapping("/put/{id}")
    public Optional<Doctor>  putDoctor(@PathVariable Long id, @RequestParam String telephone){
        Optional<Doctor> doctor;
        if (doctorRepository.existsById(id)){
            doctor = doctorRepository.findById(id);
            doctor.setTelephone(telephone);
            doctorRepository.saveAndFlush(doctor);
        }else {
            doctor = new Doctor();
        }
        return Optional.of(doctor);

    }*/

    @GetMapping("/getall")
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findAll();
    }


}
