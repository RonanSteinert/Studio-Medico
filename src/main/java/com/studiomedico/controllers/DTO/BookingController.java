package com.studiomedico.controllers.DTO;

import com.studiomedico.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/new")
    public BookingResponseDTO postBooking(@RequestBody BookingRequestDTO bookingRequestDTO){
        return bookingService.postBooking (bookingRequestDTO);
    }

    @GetMapping("/{id}")
    public BookingResponseDTO getBooking(@PathVariable("id") Long id) throws Exception {
        return bookingService.getBooking( id );
    }

    @GetMapping("/list")
    public List<BookingResponseDTO> getListOfBookings(){
        return bookingService.getListOfBooking ();
    }

    @PutMapping("/{id}")
    public BookingResponseDTO putBooking(@PathVariable("id")Long id, @RequestBody BookingRequestDTO bookingRequestDTO){
        return bookingService.putBooking ( id,bookingRequestDTO );
    }

    @DeleteMapping("/{id}")
    public BookingResponseDTO deleteBooking(@PathVariable("id") Long id) throws Exception {
        return bookingService.deleteBooking(id);
    }


}
