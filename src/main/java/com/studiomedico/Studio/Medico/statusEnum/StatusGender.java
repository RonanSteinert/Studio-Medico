package com.studiomedico.Studio.Medico.statusEnum;

public enum StatusGender {
    MALE("Male"),
    FEMALE("Female"),
    UNDEFINED("Rcchiooooooooooooooooooooooooooooo");

    private final String description;

    StatusGender(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
