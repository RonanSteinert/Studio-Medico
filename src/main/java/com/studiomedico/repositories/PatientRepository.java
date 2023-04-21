package com.studiomedico.repositories;

import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
