package com.studiomedico.controllers.DTO;

import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.statusEnum.StatusBooking;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingRequestDTO {

    private LocalDateTime bookingDate;
    private Doctor doctor;
    private Patient patient;

    public BookingRequestDTO(){}

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
