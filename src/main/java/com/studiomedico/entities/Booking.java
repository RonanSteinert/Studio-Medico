package com.studiomedico.entities;

import com.studiomedico.statusEnum.StatusBooking;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBooking;
    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "status")
    @Enumerated
    private StatusBooking status;

    public Booking() {
    }

    public Booking(long idBooking, LocalDate bookingDate, StatusBooking status) {
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
