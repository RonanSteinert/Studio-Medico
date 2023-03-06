package com.studiomedico.Studio.Medico.entities;

import com.studiomedico.Studio.Medico.statusEnum.StatusEnum;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private long idBooking;
    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "status")
    private StatusEnum status;

    public Booking() {
    }

    public Booking(long idBooking, LocalDate bookingDate, StatusEnum status) {
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
