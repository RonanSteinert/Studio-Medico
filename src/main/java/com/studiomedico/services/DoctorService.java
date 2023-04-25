package com.studiomedico.services;

import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.controllers.DTO.DoctorRequestDTO;
import com.studiomedico.controllers.DTO.DoctorResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Doctor;
import com.studiomedico.repositories.DoctorRepository;
import com.studiomedico.statusEnum.StatusRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private BookingService bookingService;

    public DoctorResponseDTO postDoctor(DoctorRequestDTO doctorRequestDto) {
        return doctorEntityToResponse(doctorRepository.save(doctorRequestToEntity(doctorRequestDto)));
    }

    public DoctorResponseDTO getDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(RuntimeException::new);
        return doctorEntityToResponse(doctor);
    }

    public List<DoctorResponseDTO> getAllDoctor() {
        return doctorEntitiesToResponse();
    }

    public DoctorResponseDTO putDoctor(Long id, DoctorRequestDTO doctorRequestDTO) {
        Doctor doctor = doctorRepository.findById (id).orElseThrow (RuntimeException::new);
        doctorRequestToEntity(doctorRequestDTO,doctor);
        return  doctorEntityToResponse (doctorRepository.save(doctor));
    }

    public DoctorResponseDTO deleteDoctor(Long id) throws Exception {
        Doctor doctor = doctorRepository.findById ( id ).orElseThrow(Exception::new);
        if(doctorRepository.existsById ( id )){
        doctor.setStatus(StatusRecord.Deleted);
        doctorRepository.save(doctor);
        }else{
         //eccezione di Emi
        }
        return doctorEntityToResponse (doctor);
    }
    public List<Booking> allBooking() {
        return bookingService.allBooking ();
    }

    public List<BookingResponseDTO> getBookingPage(Integer page, Integer pageSize) {
        return bookingService.getBookingPage ( page,pageSize );
    }

    public DoctorResponseDTO doctorEntityToResponse(Doctor doctor){

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO ();
        doctorResponseDTO.setId ( doctor.getIdDoctor () );
        doctorResponseDTO.setName (doctor.getName ());
        doctorResponseDTO.setSurname ( doctor.getSurname () );
        doctorResponseDTO.setEmail ( doctor.getEmail () );
        doctorResponseDTO.setAddress ( doctor.getAddress () );
        doctorResponseDTO.setTelephone ( doctor.getTelephone ());
        doctorResponseDTO.setStatusRecord(doctor.getStatus ());
        return  doctorResponseDTO;

    }

    private List<DoctorResponseDTO> doctorEntitiesToResponse(){
        List<Doctor> dottori = doctorRepository.findAll ();
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
        doctor.setTelephone ( doctorRequestDTO.getTelephone ());
        doctor.setStatus ( doctorRequestDTO.getStatusRecord());
        return doctor;
    }


}


