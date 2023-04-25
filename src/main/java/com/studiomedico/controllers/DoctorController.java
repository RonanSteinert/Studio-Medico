package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.controllers.DTO.DoctorRequestDTO;
import com.studiomedico.controllers.DTO.DoctorResponseDTO;
import com.studiomedico.controllers.DTO.PatientResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.repositories.DoctorRepository;
import com.studiomedico.repositories.PatientRepository;
import com.studiomedico.services.DoctorService;
import com.studiomedico.services.PatientService;
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
    private PatientService patientService;


    @PostMapping("/postdoctor")
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
    public List<DoctorResponseDTO> getAllDoctor(){
        return doctorService.getAllDoctor ();
    }

    @GetMapping("/patientbyid/{id}")
    public PatientResponseDTO getPatientById(@PathVariable(value = "id") Long id){
        return patientService.getPatient (id);
    }

    @GetMapping("/allpatient")
    public List<PatientResponseDTO> getAllPatient(){
        return patientService.getAllPatients ();
    }

    @DeleteMapping("{id}")
    public  DoctorResponseDTO deleteDoctor(@PathVariable("id") Long id) throws Exception {
        return doctorService.deleteDoctor(id);
    }

    @GetMapping("/allbooking")
    public List<Booking> getListOfBookings(){
        return doctorService.allBooking();
    }

    @GetMapping("/list")
    public List<BookingResponseDTO> getListOfBookings(@RequestParam int page, @RequestParam int pageSize){
        return doctorService.getBookingPage (page,pageSize);
    }
}
