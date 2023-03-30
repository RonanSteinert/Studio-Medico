package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.DoctorRequestDTO;
import com.studiomedico.controllers.DTO.DoctorResponseDTO;
import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.repositories.DoctorRepository;
import com.studiomedico.repositories.PatientRepository;
import com.studiomedico.services.DoctorService;
import com.studiomedico.services.PatientService;
import com.studiomedico.statusEnum.StatusRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/new")
    public DoctorResponseDTO createDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
        return doctorService.createDoctor(doctorRequestDTO);
    }

    /*
    @GetMapping("")
    public Optional<Doctor> getDoctor(@RequestParam Long id){
        //doctorRepository.existsById(id);
        return doctorRepository.findById(id);
    }

     */
    @GetMapping("/doctorbyid/{id}")
    public DoctorResponseDTO getDoctor(@PathVariable("id") Long id){
        return doctorService.getDoctor (id);
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

    @GetMapping("/alldoctor")
    public List<DoctorResponseDTO> getAllDoctor(){
        return doctorService.getAllDoctor ();
    }



    @GetMapping("/allpatient")
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        if (doctorRepository.existsById(id)) {
            Doctor doctor = doctorRepository.findById(id).get();
            doctor.setStatus(StatusRecord.Deleted);
            doctorRepository.saveAndFlush(doctor);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("no doctor exist with id " + id, HttpStatus.NOT_FOUND);
        }
    }
}
