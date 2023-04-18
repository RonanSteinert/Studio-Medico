package com.studiomedico.entities;

import com.studiomedico.statusEnum.StatusBooking;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBooking;
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusBooking status;

    public Booking() {
    }

    public Booking(long idBooking, LocalDateTime bookingDate, StatusBooking status) {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(long idBooking) {
        this.idBooking = idBooking;
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
