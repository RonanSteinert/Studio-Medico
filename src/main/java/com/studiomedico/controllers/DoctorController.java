package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.DoctorRequestDTO;
import com.studiomedico.controllers.DTO.DoctorResponseDTO;
import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.repositories.DoctorRepository;
import com.studiomedico.repositories.PatientRepository;
import com.studiomedico.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/new")
    public DoctorResponseDTO postDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
        return doctorService.postDoctor(doctorRequestDTO);
    }

    @GetMapping("/{id}")
    public DoctorResponseDTO getDoctorPathVar(@PathVariable Long id) {
        return doctorService.getDoctor(id);
    }

    @GetMapping("/id")
    public DoctorResponseDTO getDoctorReqParam(@RequestParam Long id){
        //doctorRepository.existsById(id);
        return doctorService.getDoctor(id);
    }

    @PutMapping("{id}")
    public DoctorResponseDTO putDoctor(@PathVariable("id") Long id, @RequestBody DoctorRequestDTO doctorRequestDTO){
        return doctorService.putDoctor(id, doctorRequestDTO);
    }

    @GetMapping("/alldoctor")
    public List<Doctor> getAllDoctor(){
        return doctorRepository.findByStatus("0");
    }

    //non serve questa get nel dottore
    @GetMapping("/getallpatient")
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    @DeleteMapping("{id}")
    public  DoctorResponseDTO deleteDoctor(@PathVariable("id") Long id) throws Exception {
        return doctorService.deleteDoctor(id);
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

    /*
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
     */
}
