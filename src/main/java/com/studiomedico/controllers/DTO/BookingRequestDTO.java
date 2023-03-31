package com.studiomedico.controllers.DTO;

import com.studiomedico.statusEnum.StatusBooking;

import java.time.LocalDate;

public class BookingRequestDTO {

    private LocalDate bookingDate;
    private StatusBooking status;

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public StatusBooking getStatus() {
        return status;
    }

    public void setStatus(StatusBooking status) {
        this.status = status;
    }
}
