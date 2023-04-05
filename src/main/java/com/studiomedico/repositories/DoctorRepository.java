package com.studiomedico.repositories;

import com.studiomedico.entities.Doctor;
import com.studiomedico.statusEnum.StatusRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "SELECT * FROM studio_medico.doctor WHERE status = ?1", nativeQuery = true)
    List<Doctor> findByStatus(String status);
}
