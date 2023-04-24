package com.studiomedico.services;

import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.controllers.DTO.SecretaryRequestDTO;
import com.studiomedico.controllers.DTO.SecretaryResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Secretary;
import com.studiomedico.exception.BookingNotAvailableException;
import com.studiomedico.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;
    @Autowired
    private  BookingService bookingService;


    public SecretaryResponseDTO postSecretary(SecretaryRequestDTO secretaryRequestDTO) {
        return secretaryEntityToResponse(secretaryRepository.save(secretaryRequestToEntity(secretaryRequestDTO)));
    }

    public Booking createBooking(Booking booking, Long idPatient) throws BookingNotAvailableException {
        return bookingService.createBooking ( booking,idPatient );
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


}
