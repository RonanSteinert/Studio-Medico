package com.studiomedico.services;

import com.studiomedico.controllers.DTO.BookingRequestDTO;
import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    //capire come gestire prenotazione

    @Autowired
    private BookingRepository bookingRepository;

    public BookingResponseDTO postBooking(BookingRequestDTO bookingRequestDTO){
        return bookingEntityToResponse (bookingRepository.save ( bookingRequestToEntity ( bookingRequestDTO ) ));
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
