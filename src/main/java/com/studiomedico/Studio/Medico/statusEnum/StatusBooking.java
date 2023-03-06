package com.studiomedico.Studio.Medico.statusEnum;

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
