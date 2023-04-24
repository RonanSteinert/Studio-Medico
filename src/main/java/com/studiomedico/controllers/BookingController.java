package com.studiomedico.controllers;

import com.studiomedico.controllers.DTO.BookingRequestDTO;
import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.exception.BookingNotAvailableException;
import com.studiomedico.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping("/new/{id}")
    public Booking createBooking( @RequestBody Booking booking, @PathVariable (value = "id") Long idPatient) throws BookingNotAvailableException {
        return bookingService.createBooking(booking,idPatient);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id){
        return bookingService.getBooking(id);
    }
    /*@GetMapping("/patient")
    public List<BookingResponseDTO> getBookingsByPatient() {
        return bookingService.getBookingsByPatient(AuthenticationContext.get().getUsername());
    }*/
    @GetMapping("/allbooking")
    public List<Booking> getListOfBookings(){
        return bookingService.allBooking ();
    }

    @GetMapping("/bookings/{id}")
    public List<BookingResponseDTO> getAllActiveBookings(@PathVariable Long id) {
        return bookingService.getAllActiveBooking(id);
    }

    @GetMapping("/list")
    public List<BookingResponseDTO> getListOfBookings(@RequestParam int page, @RequestParam int pageSize){
        return bookingService.getBookingPage (page,pageSize);
    }

    @PutMapping("/{id}")
    public BookingResponseDTO putBooking(@PathVariable("id")Long id, @RequestBody BookingRequestDTO bookingRequestDTO){
        return bookingService.putBooking ( id,bookingRequestDTO );
    }

    @DeleteMapping("/{id}")
    public BookingResponseDTO deleteBooking(@PathVariable("id") Long id){
        return bookingService.deleteBooking(id);
    }


}
