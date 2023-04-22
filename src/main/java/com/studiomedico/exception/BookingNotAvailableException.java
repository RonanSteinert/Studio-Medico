package com.studiomedico.exception;

import org.springframework.http.HttpStatus;

public class BookingNotAvailableException extends Exception {
    public BookingNotAvailableException(HttpStatus s) {

    }
}
