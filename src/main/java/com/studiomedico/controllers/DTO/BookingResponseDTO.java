package com.studiomedico.controllers.DTO;

import com.studiomedico.statusEnum.StatusBooking;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingResponseDTO {

    private Long id;
    private LocalDateTime bookingDate;
    private StatusBooking status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public StatusBooking getStatus() {
        return status;
    }

    public void setStatus(StatusBooking status) {
        this.status = status;
    }
}
