package com.studiomedico.services;

import com.studiomedico.controllers.DTO.BookingRequestDTO;
import com.studiomedico.controllers.DTO.BookingResponseDTO;
import com.studiomedico.entities.Booking;
import com.studiomedico.repositories.BookingRepository;
import com.studiomedico.statusEnum.StatusBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingResponseDTO postBooking(BookingRequestDTO bookingRequestDTO){
        return bookingEntityToResponse ( bookingRepository.save ( bookingRequestToEntity ( bookingRequestDTO ) ) );
    }

    public BookingResponseDTO getBooking(Long id) throws Exception {
        Booking booking= bookingRepository.findById ( id ).orElseThrow(Exception::new);
        return bookingEntityToResponse ( booking );
    }

    public List<BookingResponseDTO> getListOfBooking(){
        return bookingEntitiesToResponse ();
    }

    public BookingResponseDTO putBooking(Long id, BookingRequestDTO bookingRequestDTO) {
        Booking booking = bookingRepository.findById (id).orElseThrow (RuntimeException::new);
        bookingRequestToEntity (bookingRequestDTO,booking);
        return  bookingEntityToResponse (bookingRepository.save(booking));
    }

    public BookingResponseDTO deleteBooking(Long id) throws Exception{
        Booking booking = bookingRepository.findById (id).orElseThrow (Exception::new);
        if(bookingRepository.existsById (id)){
            booking.setStatus ( StatusBooking.CANCELLED );
            bookingRepository.save ( booking );
        }else{
            //eccezione
        }return bookingEntityToResponse ( booking );
    }

    private List<BookingResponseDTO> bookingEntitiesToResponse(){
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingResponseDTO> bookindResponseDTOS = new ArrayList<> ();
        for(Booking booking : bookings){
            bookindResponseDTOS.add(bookingEntityToResponse (booking));
        }
        return bookindResponseDTOS;
    }
    private Booking bookingRequestToEntity(BookingRequestDTO bookingRequestDTO){
        Booking booking = new Booking ();
        return bookingRequestToEntity (bookingRequestDTO,booking);
    }

    private BookingResponseDTO bookingEntityToResponse(Booking booking){
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO ();
        bookingResponseDTO.setId ( booking.getIdBooking () );
        bookingResponseDTO.setBookingDate ( booking.getBookingDate () );
        bookingResponseDTO.setStatus ( booking.getStatus () );
        return bookingResponseDTO;
    }
    private Booking bookingRequestToEntity(BookingRequestDTO bookingRequestDTO,Booking booking){
        booking.setBookingDate ( bookingRequestDTO.getBookingDate () );
        booking.setStatus ( bookingRequestDTO.getStatus () );
        return booking;
    }
}
