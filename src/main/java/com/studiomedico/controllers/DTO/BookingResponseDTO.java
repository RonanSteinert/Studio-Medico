package com.studiomedico.controllers.DTO;

import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import com.studiomedico.statusEnum.StatusBooking;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingResponseDTO {

    private LocalDateTime bookingDate;

    private DoctorResponseDTO doctor;

    private PatientResponseDTO patient;

    public BookingResponseDTO(){}

    public BookingResponseDTO(LocalDateTime bookingDate, DoctorResponseDTO doctor, PatientResponseDTO patient) {
        this.bookingDate = bookingDate;
        this.doctor = doctor;
        this.patient = patient;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public DoctorResponseDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorResponseDTO doctor) {
        this.doctor = doctor;
    }

    public PatientResponseDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientResponseDTO patient) {
        this.patient = patient;
    }
}
