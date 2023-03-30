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

    @GetMapping("/{id}")
    public DoctorResponseDTO getDoctor(@PathVariable("id") Long id){
        return doctorService.getDoctor (id);
    }

    @GetMapping("/alldoctor")
    public List<DoctorResponseDTO> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @PutMapping("/{id}")
    public DoctorResponseDTO putDoctor(@PathVariable("id")Long id,@RequestBody DoctorRequestDTO doctorRequestDTO){
        return doctorService.putDoctor (id,doctorRequestDTO);
    }

    @DeleteMapping("/{id}")
    public  DoctorResponseDTO deleteDoctor(@PathVariable("id") Long id) throws Exception {
        return doctorService.deleteDoctor(id);
    }


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
