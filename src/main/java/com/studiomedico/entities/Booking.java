package com.studiomedico.entities;

import com.studiomedico.statusEnum.StatusBooking;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking", nullable = false)
    private long idBooking;
    @NotNull
    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;
    @ManyToOne
    @JoinColumn(name="id_patient")
    private Patient patient;


    public Booking(){}

    public Booking(long idBooking, LocalDateTime bookingDate) {
        this.idBooking = idBooking;
        this.bookingDate = bookingDate;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
