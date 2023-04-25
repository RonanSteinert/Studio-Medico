package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.controllers.DTO.PatientRequestDTO;
import com.studiomedico.controllers.DTO.PatientResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.repositories.BookingRepository;
import com.studiomedico.services.BookingService;
import com.studiomedico.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/patient")
public class PatientController {

   @Autowired
    private PatientService patientService;
   @Autowired
   private BookingService bookingService;

   @PostMapping("/new")
   public PatientResponseDTO postPatient(@RequestBody PatientRequestDTO patientRequestDTO){
       return patientService.postPatient(patientRequestDTO);
   }

   @GetMapping("/{id}")
    public PatientResponseDTO getPatient(@PathVariable("id")Long id){
       return patientService.getPatient(id);
   }

   @GetMapping("/all")
   public List<PatientResponseDTO> getAllPatient(){
       return patientService.getAllPatients();
   }

   @GetMapping("/booking/{id}")
   public Optional<Booking> getBookingById(@PathVariable Long id){
       return bookingService.getSingleBooking ( id );
   }

   @PutMapping("/{id}")
    public PatientResponseDTO putPatient(@PathVariable("id") Long id, @RequestBody PatientRequestDTO patientRequestDTO){
       return patientService.putPatient(id,patientRequestDTO);
   }

   @DeleteMapping("/{id}")
   public  PatientResponseDTO deletePatient(@PathVariable("id") Long id) throws Exception {
       return patientService.deletePatient(id);
   }



   }





