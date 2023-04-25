package com.studiomedico.controllers.DTO;

import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.statusEnum.StatusBooking;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingRequestDTO {

    private LocalDateTime bookingDate;

    public BookingRequestDTO(){}

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }


}
