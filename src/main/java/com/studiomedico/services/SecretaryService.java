package com.studiomedico.services;

import com.studiomedico.controllers.DTO.*;
import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Doctor;
import com.studiomedico.entities.Secretary;
import com.studiomedico.exception.BookingNotAvailableException;
import com.studiomedico.repositories.SecretaryRepository;
import com.studiomedico.statusEnum.StatusRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;
    @Autowired
    private  BookingService bookingService;

    public SecretaryResponseDTO getSecretary(Long id){
        Secretary secretary = secretaryRepository.findById(id).orElseThrow(RuntimeException::new);
        return secretaryEntityToResponse(secretary);
    }
    public List<SecretaryResponseDTO> getAllSecretary() {
        return secretaryEntitiesToResponse();
    }

    public SecretaryResponseDTO putSecretary(Long id, SecretaryRequestDTO secretaryRequestDTO) {
        Secretary secretary = secretaryRepository.findById (id).orElseThrow (RuntimeException::new);
        secretaryRequestToEntity(secretaryRequestDTO,secretary);
        return  secretaryEntityToResponse (secretaryRepository.save(secretary));
    }

    public SecretaryResponseDTO deleteSecretary(Long id) throws Exception {
        Secretary secretary = secretaryRepository.findById ( id ).orElseThrow(Exception::new);
        if(secretaryRepository.existsById ( id )){
            secretary.setStatus(StatusRecord.Deleted);
            secretaryRepository.save(secretary);
        }else{
            //eccezione di Emi
        }
        return secretaryEntityToResponse (secretary);
    }


    public SecretaryResponseDTO postSecretary(SecretaryRequestDTO secretaryRequestDTO) {
        return secretaryEntityToResponse(secretaryRepository.save(secretaryRequestToEntity(secretaryRequestDTO)));
    }

    public Booking createBooking(Booking booking, Long idPatient) throws BookingNotAvailableException {
        return bookingService.createBooking ( booking,idPatient );
    }

    public List<Booking> allBooking() {
        return bookingService.allBooking ();
    }

    public List<BookingResponseDTO> getBookingPage(Integer page, Integer pageSize) {
        return bookingService.getBookingPage ( page,pageSize );
    }


    private Secretary secretaryRequestToEntity(SecretaryRequestDTO secretaryRequestDTO){
        Secretary secretary = new Secretary();
        return secretaryRequestToEntity (secretaryRequestDTO,secretary);
    }



    private SecretaryResponseDTO secretaryEntityToResponse(Secretary secretary){
        SecretaryResponseDTO secretaryResponseDTO = new SecretaryResponseDTO ();
        secretaryResponseDTO.setId ( secretary.getIdSecretary () );
        secretaryResponseDTO.setName ( secretary.getName () );
        secretaryResponseDTO.setSurname ( secretary.getSurname () );
        secretaryResponseDTO.setAddress ( secretary.getAddress () );
        secretaryResponseDTO.setEmail (secretary.getEmail ());
        return  secretaryResponseDTO;

    }
    private Secretary secretaryRequestToEntity(SecretaryRequestDTO secretaryRequestDTO, Secretary secretary){
        secretary.setName ( secretaryRequestDTO.getName () );
        secretary.setSurname ( secretaryRequestDTO.getSurname () );
        secretary.setAddress ( secretaryRequestDTO.getAddress () );
        secretary.setEmail ( secretaryRequestDTO.getEmail () );
        secretary.setTelephone ( secretary.getTelephone () );
        return  secretary;
    }

    private List<SecretaryResponseDTO> secretaryEntitiesToResponse(){
        List<Secretary> secretaries = secretaryRepository.findAll ();
        List<SecretaryResponseDTO> secretaryResponseDtos = new ArrayList<>();
        for(Secretary secretary : secretaries){
            secretaryResponseDtos.add(secretaryEntityToResponse(secretary));
        }
        return secretaryResponseDtos;
    }


}
