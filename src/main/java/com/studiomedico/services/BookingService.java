package com.studiomedico.services;

import com.studiomedico.controllers.DTO.BookingRequestDTO;
import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.entities.Patient;
import com.studiomedico.exception.BookingNotAvailableException;
import com.studiomedico.repositories.BookingRepository;
import com.studiomedico.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PatientRepository patientRepository;


    public Booking createBooking(Booking booking, Long idPatient) throws BookingNotAvailableException {
        LocalDateTime bookingDate = booking.getBookingDate();
        // Calcola la data e l'ora di fine della prenotazione
        LocalDateTime endDateTime = bookingDate.plusMinutes(30);
        // Verifica se la prenotazione è disponibile
        Optional<Booking> existingBooking = bookingRepository.findByBookingDate(bookingDate);
        if (existingBooking.isPresent()) {
            throw new BookingNotAvailableException( HttpStatus.BAD_REQUEST );
        }
        // Verifica se la prenotazione si sovrappone ad altre prenotazioni
        LocalDateTime startDateTime = bookingDate;
        LocalDateTime overlapEndDateTime = bookingDate.plusMinutes(30);
        List<Booking> bookings = bookingRepository.findByBookingDateBetween(startDateTime, overlapEndDateTime);
        if (!bookings.isEmpty()) {
            throw new BookingNotAvailableException(HttpStatus.BAD_REQUEST);
        }
        // Cerca il paziente con l'ID specificato
        Optional<Patient> patient = patientRepository.findById(idPatient);
        if (patient.isEmpty()) {
            throw new NotFoundException ("Il paziente non è stato trovato.");
        }
        // Se la prenotazione è disponibile, salvala nel database
        booking.setBookingDate(endDateTime);
        booking.setPatient(patient.get());
        return bookingRepository.save(booking);
    }

    public BookingResponseDTO getBooking(long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(RuntimeException::new);
        return bookingEntityToResponse(booking);
    }


    public BookingResponseDTO putBooking(long id, BookingRequestDTO request) {
        Booking booking = bookingRepository.findById(id).orElseThrow(RuntimeException::new);
        bookingRequestToEntity(request, booking);
        return bookingEntityToResponse(bookingRepository.save(booking));

    }


    public BookingResponseDTO deleteBooking(long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(RuntimeException::new);
        bookingRepository.delete(booking);
        return bookingEntityToResponse(booking);
    }

    public List<BookingResponseDTO> getBookingPage(Integer page, Integer pageSize) {
        Page<Booking> bookings = bookingRepository.findAll(PageRequest.of(page, pageSize));
        return bookingsEntitiesToResponses(bookings.getContent());
    }

    private List<BookingResponseDTO> bookingsEntitiesToResponses(List<Booking> bookings) {
        List<BookingResponseDTO> response = new ArrayList<>();
        for(Booking booking : bookings) {
            response.add(bookingEntityToResponse(booking));
        }
        return response;
    }

    private Booking bookingRequestToEntity(BookingRequestDTO request) {
        Booking booking = new Booking();
        return bookingRequestToEntity(request, booking);
    }


    private Booking bookingRequestToEntity(BookingRequestDTO request, Booking booking){
        booking.setBookingDate(request.getBookingDate());
        booking.setDoctor(request.getDoctor());
        booking.setPatient(request.getPatient());

        return booking;
    }

    private BookingResponseDTO bookingEntityToResponse(Booking booking){
        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingDate(booking.getBookingDate());
        return response;
    }

}
