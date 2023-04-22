package com.studiomedico.repositories;

import com.studiomedico.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    Optional<Booking> findByBookingDate(LocalDateTime bookingDate);

    List<Booking> findByBookingDateBetween(LocalDateTime bookingStart, LocalDateTime bookingEnd);
}