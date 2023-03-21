package com.studiomedico.statusEnum;

import jakarta.persistence.Enumerated;

public enum StatusBooking {
    CONFIRMED("Booking confirmed"),
    CANCELLED("Booking cancelled");


    private final String description;

    StatusBooking(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
