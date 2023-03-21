package com.studiomedico.Studio.Medico.repositories;

import com.studiomedico.Studio.Medico.entities.Doctor;
import com.studiomedico.Studio.Medico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
