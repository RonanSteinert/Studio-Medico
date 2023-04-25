package com.studiomedico.controllers.DTO;

import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.statusEnum.StatusBooking;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingResponseDTO {

    private LocalDateTime bookingDate;


    public BookingResponseDTO(){}

    public BookingResponseDTO(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }


}
