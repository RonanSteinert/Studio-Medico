package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.*;
import com.studiomedico.entities.Booking;
import com.studiomedico.exception.BookingNotAvailableException;
import com.studiomedico.services.BookingService;
import com.studiomedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    private SecretaryService secretaryService;

    @Autowired
    private BookingService bookingService;

    @PutMapping("/{id}")
    public SecretaryResponseDTO putSecretary(@PathVariable("id") Long id, @RequestBody SecretaryRequestDTO secretaryRequestDTO){
        return secretaryService.putSecretary(id, secretaryRequestDTO);
    }

    @GetMapping("/{id}")
    public SecretaryResponseDTO getSecretaryPathVar(@PathVariable Long id) {

        return secretaryService.getSecretary(id);
    }
    @DeleteMapping("/{id}")
    public  SecretaryResponseDTO deleteSecretary(@PathVariable("id") Long id) throws Exception {
        return secretaryService.deleteSecretary(id);
    }
    @GetMapping("/allsecretary")
    public List<SecretaryResponseDTO> getAllSecretary(){
        return secretaryService.getAllSecretary ();
    }




    @PostMapping("/new")
    public SecretaryResponseDTO postSecretary(@RequestBody SecretaryRequestDTO secretaryRequestDTO){
        return secretaryService.postSecretary(secretaryRequestDTO);
    }
    //secretary controller can post a booking
    @PostMapping("/booking/{id}")
    public Booking createBooking(@RequestBody Booking booking, @PathVariable (value = "id") Long idPatient) throws BookingNotAvailableException {
        return secretaryService.createBooking(booking,idPatient);
    }

    @GetMapping("/allbooking")
    public List<Booking> getListOfBookings(){
        return secretaryService.allBooking();
    }

    @GetMapping("/list")
    public List<BookingResponseDTO> getListOfBookings(@RequestParam int page, @RequestParam int pageSize){
        return secretaryService.getBookingPage (page,pageSize);
    }

}
