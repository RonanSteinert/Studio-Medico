package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.SecretaryRequestDTO;
import com.studiomedico.controllers.DTO.SecretaryResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.exception.BookingNotAvailableException;
import com.studiomedico.services.BookingService;
import com.studiomedico.services.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    private SecretaryService secretaryService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/new")
    public SecretaryResponseDTO postSecretary(@RequestBody SecretaryRequestDTO secretaryRequestDTO){
        return secretaryService.postSecretary(secretaryRequestDTO);
    }

    @PostMapping("/new/{id}")
    public Booking createBooking(@RequestBody Booking booking, @PathVariable (value = "id") Long idPatient) throws BookingNotAvailableException {
        return secretaryService.createBooking(booking,idPatient);
    }


}
