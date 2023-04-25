package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.controllers.DTO.SecretaryRequestDTO;
import com.studiomedico.controllers.DTO.SecretaryResponseDTO;
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

    @PostMapping("/postsecretary")
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
