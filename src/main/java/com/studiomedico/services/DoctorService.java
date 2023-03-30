package com.studiomedico.services;

import com.studiomedico.controllers.DTO.DoctorRequestDTO;
import com.studiomedico.controllers.DTO.DoctorResponseDTO;
import com.studiomedico.entities.Doctor;
import com.studiomedico.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDto) {
        return doctorEntityToResponse(doctorRepository.save(doctorRequestToEntity(doctorRequestDto)));
    }

    public DoctorResponseDTO getDoctor(Long id){
        Doctor doctor = doctorRepository.findById ( id ).orElseThrow(RuntimeException::new);
        return doctorEntityToResponse(doctor);
    }

    public List<DoctorResponseDTO> getAllDoctor() {
        return doctorEntitiesToResponse();
    }


    private DoctorResponseDTO doctorEntityToResponse(Doctor doctor){

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO ();
        doctorResponseDTO.setName (doctor.getName ());
        doctorResponseDTO.setSurname ( doctor.getSurname () );
        doctorResponseDTO.setEmail ( doctor.getEmail () );
        doctorResponseDTO.setAddress ( doctorResponseDTO.getAddress () );
        doctorResponseDTO.setTelephone ( doctorResponseDTO.getTelephone () );
        doctorResponseDTO.setFiscalCode ( doctorResponseDTO.getFiscalCode () );
        return  doctorResponseDTO;

    }

    private List<DoctorResponseDTO> doctorEntitiesToResponse(){
        List<Doctor> dottori = new ArrayList<> ();
        List<DoctorResponseDTO> doctorResponseDtos = new ArrayList<> ();
        for(Doctor doctor : dottori){
            doctorResponseDtos.add(doctorEntityToResponse(doctor));
        }
        return doctorResponseDtos;
    }

    private Doctor doctorRequestToEntity(DoctorRequestDTO doctorRequestDto){
        Doctor doctor = new Doctor ();
        return doctorRequestToEntity(doctorRequestDto,doctor);
    }
    
    private Doctor doctorRequestToEntity(DoctorRequestDTO doctorRequestDTO, Doctor doctor) {

        doctor.setName ( doctorRequestDTO.getName () );
        doctor.setSurname ( doctorRequestDTO.getSurname () );
        doctor.setEmail ( doctorRequestDTO.getEmail () );
        doctor.setAddress ( doctorRequestDTO.getAddress () );
        doctor.setTelephone ( doctorRequestDTO.getTelephone () );
        return doctor;
    }
}


