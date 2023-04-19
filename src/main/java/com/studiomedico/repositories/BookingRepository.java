package com.studiomedico.repositories;

import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findBydoctor (Doctor doctor_id);
    List<Booking> findBypatient (Patient patient_id);


    List<Booking> findBydateReservation(LocalDateTime dateReservation);
}
