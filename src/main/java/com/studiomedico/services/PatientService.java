package com.studiomedico.services;

import com.studiomedico.controllers.DTO.PatientRequestDTO;
import com.studiomedico.controllers.DTO.PatientResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Patient;
import com.studiomedico.repositories.BookingRepository;
import com.studiomedico.repositories.PatientRepository;
import com.studiomedico.statusEnum.StatusRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BookingService bookingService;


    public PatientResponseDTO getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(RuntimeException::new);
        return patientEntityToResponse (patient);
    }

    public List<PatientResponseDTO> getAllPatients() {
        return patientEntitiesToResponse ();
    }

    public PatientResponseDTO postPatient(PatientRequestDTO patientRequestDTO) {
        return patientEntityToResponse ( patientRepository.save(patientRequestToEntity(patientRequestDTO)));
    }

    public PatientResponseDTO putPatient(Long id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById (id).orElseThrow (RuntimeException::new);
        patientRequestToEntity (patientRequestDTO,patient);
        return  patientEntityToResponse (patientRepository.save(patient));
    }
    public PatientResponseDTO deletePatient(Long id) throws Exception{
        Patient patient = patientRepository.findById (id).orElseThrow (Exception::new);
        if(patientRepository.existsById (id)){
            patient.setStatus ( StatusRecord.Deleted );
            patientRepository.save ( patient );
        }else{

            //eccezione
        }return patientEntityToResponse ( patient );

    }


    private Patient patientRequestToEntity(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient ();
        return patientRequestToEntity (patientRequestDTO,patient);
    }

    private List<PatientResponseDTO> patientEntitiesToResponse(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = new ArrayList<> ();
        for(Patient patient : patients){
            patientResponseDTOS.add(patientEntityToResponse (patient));
        }
        return patientResponseDTOS;
    }

    public PatientResponseDTO patientEntityToResponse(Patient patient){

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO ();
        patientResponseDTO.setId( patient.getIdPatient () );
        patientResponseDTO.setName ( patient.getName () );
        patientResponseDTO.setSurname ( patient.getSurname () );
        patientResponseDTO.setEmail ( patient.getEmail () );
        patientResponseDTO.setAddress ( patient.getAddress () );
        patientResponseDTO.setTelephone ( patient.getTelephone () );
        patientResponseDTO.setStatusRecord ( patient.getStatus () );
        patientResponseDTO.setBirthCity ( patient.getBirthCity () );
        patientResponseDTO.setBirthDate ( patient.getBirthDate () );
        patientResponseDTO.setGender ( patient.getGender () );
        return patientResponseDTO;

    }
    private Patient patientRequestToEntity(PatientRequestDTO patientRequestDTO, Patient patient) {

        patient.setName ( patientRequestDTO.getName () );
        patient.setSurname ( patientRequestDTO.getSurname () );
        patient.setEmail ( patientRequestDTO.getEmail () );
        patient.setAddress ( patientRequestDTO.getAddress () );
        patient.setTelephone ( patientRequestDTO.getTelephone ());
        patient.setStatus ( patientRequestDTO.getStatusRecord());
        patient.setBirthCity ( patientRequestDTO.getBirthCity () );
        patient.setBirthDate (patientRequestDTO.getBirthDate ());
        patient.setGender ( patientRequestDTO.getGender () );
        return patient;
    }



}
